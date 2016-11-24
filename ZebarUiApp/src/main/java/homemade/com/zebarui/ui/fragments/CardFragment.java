package homemade.com.zebarui.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import homemade.com.zebarui.R;
import homemade.com.zebarui.constants.Preferences;
import homemade.com.zebarui.ui.activities.WidgetActivity;

public class CardFragment extends Fragment implements View.OnClickListener{

    public CardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card_layout, container, false);
        view.findViewById(R.id.fragment_card_layout).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.fragment_card_layout){
            Intent intent = new Intent(getContext(), WidgetActivity.class);
            intent.putExtra(Preferences.FRAGMENT_NAME, Preferences.CARD_VIEW);
            startActivity(intent);
        }
    }
}
