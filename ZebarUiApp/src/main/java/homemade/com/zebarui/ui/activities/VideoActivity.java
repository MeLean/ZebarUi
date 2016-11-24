package homemade.com.zebarui.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import homemade.com.zebarui.R;
import homemade.com.zebarui.ui.fragments.VideoControlFragment;
import homemade.com.zebarui.ui.fragments.VideoFragment;

;

public class VideoActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_video);

        getSupportFragmentManager().beginTransaction()
                .replace( R.id.video_holder, new VideoFragment())
                .replace(R.id.video_controls_holder, new VideoControlFragment())
                .commit();
    }
}