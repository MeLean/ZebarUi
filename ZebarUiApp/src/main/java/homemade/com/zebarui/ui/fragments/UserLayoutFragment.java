package homemade.com.zebarui.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import homemade.com.zebarui.R;
import homemade.com.zebarui.ui.activities.ProfileActivity;

public class UserLayoutFragment extends Fragment implements View.OnClickListener{

    public UserLayoutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_layout, container, false);
        view.findViewById(R.id.profile_launcher).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.profile_launcher){
            startActivity(new Intent(getContext(), ProfileActivity.class));
        }
    }
}
