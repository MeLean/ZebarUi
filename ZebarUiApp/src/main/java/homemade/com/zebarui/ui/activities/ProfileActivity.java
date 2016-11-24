package homemade.com.zebarui.ui.activities;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import homemade.com.zebarui.R;
import homemade.com.zebarui.ui.fragments.ProfileFragment;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //adding toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_left_img_title_right_text);
        setSupportActionBar(toolbar);
        //set custom title of toolbar
        ((TextView) toolbar.findViewById(R.id.tw_toolbar_title_text)).setText(getString(R.string.profile_text));
        //set custom left picture
        ImageButton backButton =(ImageButton) toolbar.findViewById(R.id.btn_toolbar_left_img);
        backButton.setImageResource(R.drawable.btn_back_states);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //set custom right picture
        toolbar.findViewById(R.id.btn_toolbar_right_text).setBackgroundResource(R.drawable.btn_lang_states);

        //adding profile fragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.profile_fragment_container, new ProfileFragment())
                .commit();
    }
}
