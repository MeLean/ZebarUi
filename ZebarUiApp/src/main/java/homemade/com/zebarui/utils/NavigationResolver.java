package homemade.com.zebarui.utils;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.navdrawer.SimpleSideDrawer;

import homemade.com.zebarui.R;
import homemade.com.zebarui.constants.Preferences;
import homemade.com.zebarui.ui.activities.AddItemActivity;
import homemade.com.zebarui.ui.activities.MainActivity;
import homemade.com.zebarui.ui.activities.TabulatedActivity;
import homemade.com.zebarui.ui.activities.ProfileActivity;
import homemade.com.zebarui.ui.activities.WidgetActivity;


public class NavigationResolver implements View.OnClickListener {
    private Context mContext;
    private SimpleSideDrawer mNav;
    private static NavigationResolver mInstance = new NavigationResolver();

    private NavigationResolver(){

    }

    public static NavigationResolver getInstance() {
        return mInstance;
    }

    //todo make singleton
    public void initialize(Context context, SimpleSideDrawer nav) {
        this.mContext = context;
        this.mNav = nav;
    }

    public void resolve(){
        mNav.findViewById(R.id.btn_toolbar_left_img).setOnClickListener(this);
        mNav.findViewById(R.id.menu_btn_home).setOnClickListener(this);
        mNav.findViewById(R.id.menu_btn_add).setOnClickListener(this);
        mNav.findViewById(R.id.menu_btn_offers).setOnClickListener(this);
        mNav.findViewById(R.id.menu_btn_map).setOnClickListener(this);
        mNav.findViewById(R.id.btn_notification).setOnClickListener(this);
        mNav.findViewById(R.id.img_user).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_toolbar_left_img:
                mNav.toggleLeftDrawer();
                break;
            case R.id.menu_btn_home:
                mNav.closeLeftSide();//this needed to close the drawer in order to prevent stay open after Back button is pressed
                mContext.startActivity( new Intent(mContext, MainActivity.class));
                break;
            case R.id.menu_btn_add:
                mNav.closeLeftSide();
                mContext.startActivity( new Intent(mContext, AddItemActivity.class));
                break;
            case R.id.menu_btn_offers:
                mNav.closeLeftSide();
                mContext.startActivity(
                        new Intent(mContext, TabulatedActivity.class)
                                .putExtra(Preferences.FRAGMENT_NAME, Preferences.OFFERS));
                break;
            case R.id.menu_btn_map:
                mNav.closeLeftSide();
                mNav.closeLeftSide();
                mContext.startActivity(
                        new Intent(mContext, TabulatedActivity.class)
                                .putExtra(Preferences.FRAGMENT_NAME, Preferences.MAP));
                break;
            case R.id.btn_notification:
                mNav.closeLeftSide();
                mContext.startActivity(
                        new Intent(mContext, WidgetActivity.class)
                                .putExtra(Preferences.FRAGMENT_NAME, Preferences.NOTIFICATION));
                break;

            case R.id.img_user:
                mNav.closeLeftSide();
                mContext.startActivity( new Intent(mContext, ProfileActivity.class));
                break;
            default:
                throw new UnsupportedOperationException("There is no click action for id: " + id);
        }
    }
}
