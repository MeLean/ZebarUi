package homemade.com.zebarui.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.navdrawer.SimpleSideDrawer;

import homemade.com.zebarui.R;
import homemade.com.zebarui.constants.Preferences;
import homemade.com.zebarui.utils.NavigationResolver;

public class AddItemActivity extends AppCompatActivity implements View.OnClickListener {
    NavigationResolver mResolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        //adding toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_left_img_title_right_text);
        setSupportActionBar(toolbar);

        //set custom title of toolbar
        ((TextView) toolbar.findViewById(R.id.tw_toolbar_title_text)).setText(getString(R.string.add_text));

        //adding navigation drawer
        SimpleSideDrawer navigationDrawer = new SimpleSideDrawer(this);
        navigationDrawer.setLeftBehindContentView(R.layout.left_showing_menu);
        //setting navigation buttons clickListener
        NavigationResolver resolver = NavigationResolver.getInstance();
        resolver.initialize(this, navigationDrawer);
        resolver.resolve();

        //set onClickListeners
        findViewById(R.id.btn_launch_scanner).setOnClickListener(this);
        findViewById(R.id.btn_request_card).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //adding navigation drawer
        SimpleSideDrawer navigationDrawer = new SimpleSideDrawer(this);
        navigationDrawer.setLeftBehindContentView(R.layout.left_showing_menu);
        //setting navigation buttons clickListener
        NavigationResolver setter = NavigationResolver.getInstance();
        setter.initialize(this, navigationDrawer);
        setter.resolve();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_launch_scanner){
            Intent intent = new Intent(this, WidgetActivity.class);
            intent.putExtra(Preferences.FRAGMENT_NAME, Preferences.SCANNER);
            this.startActivity(intent);
        } else if (id == R.id.btn_request_card){
            Intent intent = new Intent(this, WidgetActivity.class);
            intent.putExtra(Preferences.FRAGMENT_NAME, Preferences.REQUEST_CARD);
            this.startActivity(intent);
        }
    }
}
