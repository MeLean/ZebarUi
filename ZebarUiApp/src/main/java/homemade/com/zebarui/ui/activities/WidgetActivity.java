package homemade.com.zebarui.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import homemade.com.zebarui.R;
import homemade.com.zebarui.constants.Preferences;
import homemade.com.zebarui.ui.fragments.CardItemFragment;
import homemade.com.zebarui.ui.fragments.EmptyFragment;
import homemade.com.zebarui.ui.fragments.NotificationsFragment;
import homemade.com.zebarui.ui.fragments.OfferFragment;
import homemade.com.zebarui.ui.fragments.ScannerFragment;

public class WidgetActivity extends AppCompatActivity {
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_left_img_title_right_text);
        setSupportActionBar(mToolbar);

        this.setBackToolbarBackButton();

        Intent startedIntend = getIntent();
        String fragmentName = startedIntend.getStringExtra(Preferences.FRAGMENT_NAME);
        switch (fragmentName) {
             case Preferences.OFFERS:
                this.setupOffersView();
                break;
            case Preferences.SCANNER:
                this.setupScannerView();
                break;
            case Preferences.NOTIFICATION:
                this.setupNotificationView();
                break;
            case Preferences.CARD_VIEW:
                this.setupCartItemView();
                break;
            case Preferences.REQUEST_CARD:
                this.setupRequestCardView();
                break;
            default:
                throw new UnsupportedOperationException("There is no case for fragment " + fragmentName);
        }
    }

    @Override
    public void onBackPressed() {

        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getFragmentManager().popBackStack();
        }

    }


    private void setupScannerView() {
        ((TextView) mToolbar.findViewById(R.id.tw_toolbar_title_text)).setText(getString(R.string.add_text));
        ((TextView) mToolbar.findViewById(R.id.btn_toolbar_right_text)).setText(getString(R.string.skip_text));
        this.addFragment(new ScannerFragment(), R.id.widget_container);
    }

    private void setupNotificationView() {
        ((TextView) mToolbar.findViewById(R.id.tw_toolbar_title_text)).setText(getString(R.string.notifications_text));
        this.addFragment(new NotificationsFragment(), R.id.widget_container);
    }

    private void setupOffersView() {
        ((TextView) mToolbar.findViewById(R.id.tw_toolbar_title_text)).setText(getString(R.string.offers_text));
        this.addFragment(new OfferFragment(), R.id.widget_container);
    }

    private void setupCartItemView() {
        ((TextView) mToolbar.findViewById(R.id.tw_toolbar_title_text)).setText(getString(R.string.card_text));
        ((TextView) mToolbar.findViewById(R.id.btn_toolbar_right_text)).setText(getString(R.string.delete_text));
        this.addFragment(new CardItemFragment(), R.id.widget_container);
    }

    private void setupRequestCardView() {
        ((TextView) mToolbar.findViewById(R.id.tw_toolbar_title_text)).setText(getString(R.string.choose_brand));
        //todo change whit appropriate fragment
        this.addFragment(new EmptyFragment(), R.id.widget_container);
    }



    private void killActivity(){
        this.finish();
    }


    private void addFragment(Fragment fragment, int containerId){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment)
                .commit();
    }

    private void setBackToolbarBackButton(){
        ImageButton backButton =(ImageButton) mToolbar.findViewById(R.id.btn_toolbar_left_img);
        backButton.setImageResource(R.drawable.btn_back_states);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                killActivity();
            }
        });
    }
}
