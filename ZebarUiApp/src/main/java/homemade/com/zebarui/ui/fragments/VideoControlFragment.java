package homemade.com.zebarui.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import homemade.com.zebarui.R;

public class VideoControlFragment extends Fragment implements View.OnClickListener{

    public VideoControlFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_player_controls, container, false);
        view.findViewById(R.id.btn_done_video_player).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        //todo do better video interrupting
        getActivity().finish();
    }
}
