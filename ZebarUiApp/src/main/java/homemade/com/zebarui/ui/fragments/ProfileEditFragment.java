package homemade.com.zebarui.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import homemade.com.zebarui.R;

public class ProfileEditFragment extends Fragment {

    public ProfileEditFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
           return inflater.inflate(R.layout.fragment_profile_edit, container, false);
    }
}
