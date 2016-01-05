package com.example.nisrina.prakt13b;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.util.List;

/**
 * Created by nisrina on 12/8/15.
 */
public class Preview extends ViewGroup implements SurfaceHolder.Callback {

    private final String TAG = "Preview";
    SurfaceView mSurfaceView;
    SurfaceHolder mHolder;
    Size mPreviewSize;
    List<Size> mSupportedPreviewSize;
    Camera mCamera;

    Preview(Context context, SurfaceView sv){
        super(context);

        mSurfaceView = sv;
        mHolder = mSurfaceView.getHolder();
        mHolder.addCallback(this);
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

    }

    public void setCamera(Camera camera){
        mCamera = camera;
        if(mCamera!=null){
            mSupportedPreviewSize = mCamera.getParameters().getSupportedPreviewSizes();

            Camera.Parameters params = mCamera.getParameters();

            List<String> focusModes = params.getSupportedFocusModes();
            if(focusModes.contains(Camera.Parameters.FOCUS_MODE_AUTO)){
                params.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
                mCamera.setParameters(params);
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        final int width = resolveSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        final int height = resolveSize(getSuggestedMinimumHeight(), heightMeasureSpec);

        setMeasuredDimension(width, height);

        if(mSupportedPreviewSize != null){
            mPreviewSize = getOptimalPreviewSize(mSupportedPreviewSize, width, height);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b){
        if(changed && getChildCount() > 0){
            final View child = getChildAt(0);

            final int width = r - l;
            final int height = b - t;
            int previewWidth = width;
            int previewHeight = height;

            if(mPreviewSize != null){
                previewHeight=mPreviewSize.height;
                previewWidth=mPreviewSize.width;
            }

            if(width * previewHeight > height * previewWidth){
                final int scaledChildWidth = previewWidth * height / previewHeight;
                child.layout((width - scaledChildWidth) /2, 0, (width + scaledChildWidth) / 2 , height);
            }else{
                final int scaledChildHeight = previewHeight * width / previewWidth;
                child.layout(0, (height - scaledChildHeight) / 2, width, (height + scaledChildHeight) / 2);
            }
        }
    }

    public void surfaceCreated(SurfaceHolder holder){
        try{
            if(mCamera != null){
                mCamera.setPreviewDisplay(holder);
            }
        }catch (IOException exception){
            Log.e(TAG, "IOException caused by setPreviewDisplay()", exception);
        }
    }

    public void surfaceDestroyed(SurfaceHolder holder){
        if(mCamera != null){
            mCamera.stopPreview();
        }
    }

    private android.hardware.Camera.Size getOptimalPreviewSize(List<android.hardware.Camera.Size> sizes, int w, int h){
        final double ASPECT_TOLLERANCE = 0.1;
        double targetRatio = (double) w / h;
        if(sizes == null)return null;

        Size optimalSize = null;
        double minDiff = Double.MAX_VALUE;

        int targetHeight = h;

        for (android.hardware.Camera.Size size : sizes){
            double ratio = (double) size.width / size.height;
            if(Math.abs(ratio - targetRatio) > ASPECT_TOLLERANCE) continue;
            if(Math.abs(size.height - targetHeight) < minDiff){
                optimalSize = size;
                minDiff = Math.abs(size.height - targetHeight);
            }
        }

        if(optimalSize == null){
            minDiff = Double.MAX_VALUE;
            for(android.hardware.Camera.Size size : sizes){
                if(Math.abs(size.height - targetHeight) < minDiff){
                    optimalSize = size;
                    minDiff = Math.abs(size.height - targetHeight);
                }
            }
        }
        return optimalSize;
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h){
        if(mCamera != null){
            android.hardware.Camera.Parameters parameters = mCamera.getParameters();
            parameters.setPreviewSize(mPreviewSize.width, mPreviewSize.height);
            requestLayout();

            mCamera.setParameters(parameters);
            mCamera.startPreview();
        }
    }
}
