package mahmudah.m3113135_tugas_camera;

        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
        import android.content.pm.ActivityInfo;
        import android.hardware.Camera;
        import android.net.Uri;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.Surface;
        import android.view.SurfaceView;
        import android.view.View;
        import android.view.ViewGroup;
        import android.view.Window;
        import android.view.WindowManager;
        import android.widget.Button;
        import android.widget.FrameLayout;
        import android.widget.Toast;

        import java.io.File;

public class MainActivity extends Activity {

    private static final String TAG = "Main Activity";
    Preview preview;
    Button buttonClick;
    Camera camera;
    Activity act;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ctx = this;
        act = this;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

       preview = new Preview(this, (SurfaceView) findViewById(R. id.surfaceView));
        preview.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        ((FrameLayout) findViewById(R.id.layout)).addView(preview);
        preview.setKeepScreenOn(true);

        preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                camera.takePicture(shutterCallback, rawCallback, jpegCallback);
            }
        });

        Toast.makeText(ctx, "Touch anywhere on screen top take picture", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        int numCams = android.hardware.Camera.getNumberOfCameras();
        if (numCams > 0){
            try {
                camera = android.hardware.Camera.open(0);
                camera.startPreview();
                preview.setCamera(camera);
                Toast.makeText(ctx, "Camera found", Toast.LENGTH_LONG).show();
            } catch (Exception e){}
        }
    }

    @Override
    protected void onPause(){
        if (camera != null){
            camera.stopPreview();
            preview.setCamera(null);
            camera.release();
            camera = null;
        }
        super.onPause();
    }

    private void resetCam(){
        camera.startPreview();
        preview.setCamera(camera);
    }

    private void refreshGallery(File file){
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        mediaScanIntent.setData(Uri.fromFile(file));
        sendBroadcast(mediaScanIntent);
    }

    Camera.ShutterCallback shutterCallback = new Camera.ShutterCallback(){
        @Override
        public void onShutter(){

        }
    };

    Camera.PictureCallback rawCallback = new Camera.PictureCallback(){
        @Override
        public  void onPictureTaken(byte[] data, Camera camera){}
    };

    Camera.PictureCallback jpegCallback = new Camera.PictureCallback(){
        @Override
        public void onPictureTaken(byte[] data, Camera camera){}
    };
}