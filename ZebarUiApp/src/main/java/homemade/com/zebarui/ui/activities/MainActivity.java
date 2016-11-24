package homemade.com.zebarui.ui.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.navdrawer.SimpleSideDrawer;

import homemade.com.zebarui.R;
import homemade.com.zebarui.ui.fragments.CardFragment;
import homemade.com.zebarui.ui.fragments.UserLayoutFragment;
import homemade.com.zebarui.utils.NavigationResolver;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //adding toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_left_img_title_right_text);
        setSupportActionBar(toolbar);

        //set custom title of toolbar
        ((TextView) toolbar.findViewById(R.id.tw_toolbar_title_text)).setText(getString(R.string.card_tickets_text));

        //adding user layout fragment and cards fragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.user_layout_fragment_container, new UserLayoutFragment())
                .replace(R.id.user_layout_cards_fragment_container, new CardFragment())
                .commit();

        //adding floating action button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddItemActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        //adding navigation drawer
        SimpleSideDrawer navigationDrawer = new SimpleSideDrawer(this);
        navigationDrawer.setLeftBehindContentView(R.layout.left_showing_menu);
        //setting navigation buttons clickListener
        NavigationResolver resolver = NavigationResolver.getInstance();
        resolver.initialize(this, navigationDrawer);
        resolver.resolve();
    }
}