package homemade.com.zebarui.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.navdrawer.SimpleSideDrawer;

import homemade.com.zebarui.R;
import homemade.com.zebarui.constants.Preferences;
import homemade.com.zebarui.ui.fragments.EmptyFragment;
import homemade.com.zebarui.ui.fragments.MapFragment;
import homemade.com.zebarui.ui.fragments.OfferTabulatedFragment;
import homemade.com.zebarui.utils.NavigationResolver;

public class TabulatedActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mLeftTab;
    private TextView mRightTab;
    private Fragment mLeftTabFragment;
    private Fragment mRightTabFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);


        //checking intent for fragment name
        Intent startedIntend = getIntent();
        String fragmentName = startedIntend.getStringExtra(Preferences.FRAGMENT_NAME);

        //adding toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_left_img_tabs);
        setSupportActionBar(toolbar);

        //adding navigation drawer
        SimpleSideDrawer navigationDrawer = new SimpleSideDrawer(this);
        navigationDrawer.setLeftBehindContentView(R.layout.left_showing_menu);

        //setting navigation buttons clickListener
        NavigationResolver resolver = NavigationResolver.getInstance();
        resolver.initialize(this, navigationDrawer);
        resolver.resolve();


        switch (fragmentName) {
            case Preferences.OFFERS:
                setFragments(getString(
                        R.string.meal_deal),
                        getString(R.string.sales),
                        new OfferTabulatedFragment(),
                        //todo change whit appropriate fragment
                        new EmptyFragment()
                );
                break;
            case Preferences.MAP:
                setFragments(getString(
                        R.string.map_text),
                        getString(R.string.map_list_view),
                        new MapFragment(),
                        //todo change whit appropriate fragment
                        new EmptyFragment()
                );
                break;
            default:
                throw new UnsupportedOperationException("No case to for fragment name : " + fragmentName);
        }
    }

    private void setFragments(
            String leftTabName,
            String rightTabName,
            Fragment leftFragment,
            EmptyFragment rightFragment) {

        mLeftTab = (TextView)findViewById(R.id.toolbar_left_tab);
        mLeftTab.setOnClickListener(this);
        mLeftTab.setText(leftTabName);
        mRightTab = (TextView) findViewById(R.id.toolbar_right_tab);
        mRightTab.setOnClickListener(this);
        mRightTab.setText(rightTabName);

        mRightTabFragment = rightFragment;
        mLeftTabFragment = leftFragment;

        addFragment(leftFragment, R.id.offers_fragment_container);

    }

    private void addFragment(Fragment fragment, int containerId){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment)
                .commit();
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.toolbar_left_tab){
            mLeftTab.setBackgroundResource(R.drawable.shape_tab_left_prs);
            mLeftTab.setTextColor(ContextCompat.getColor(this,R.color.colorPrimary));
            mRightTab.setBackgroundResource(R.drawable.shape_tab_right);
            mRightTab.setTextColor(ContextCompat.getColor(this,R.color.yellow));

            addFragment(mLeftTabFragment, R.id.offers_fragment_container);

        }else if(id == R.id.toolbar_right_tab){
            mRightTab.setBackgroundResource(R.drawable.shape_tab_right_prs);
            mRightTab.setTextColor(ContextCompat.getColor(this,R.color.colorPrimary));
            mLeftTab.setBackgroundResource(R.drawable.shape_tab_left);
            mLeftTab.setTextColor(ContextCompat.getColor(this,R.color.yellow));

            addFragment(mRightTabFragment, R.id.offers_fragment_container);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mRightTabFragment = null;
        mLeftTabFragment = null;
    }
}
