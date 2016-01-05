package stivan.camera;
import android.content.Context;
import android.graphics.Camera;
import android.util.Size;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;


/**
 * Created by Stivan on 08/12/2015.
 */
public class preview extends ViewGroup implements SurfaceHolder.Callback{

    private final String TAG ="Priview";

    SurfaceView mSurfaceView;
    SurfaceHolder mHolder;
    Size mPriviewSize;
    List<android.hardware.Camera.Size> mSupportedPreviewSizes;
    Camera mCamera;

    Preview(Context context, SurfaceView sv){
        super(context);

        mSurfaceView = sv;

        mHolder = mSurfaceView.getHolder();
        mHolder.addCallback(this);
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }
    public void setCamera(android.hardware.Camera camera){
        mCamera = camera;
        if(mCamera != null){
            mSupportedPreviewSizes=mCamera.getParameters()

        }

    public void surfaceCreated(SurfaceHolder holder){
        mCamera = camera;
        if(mCamera != null){
            mCamera.stopPreview();

        }
    }

}
