package homemade.com.zebarui.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import homemade.com.zebarui.R;
import homemade.com.zebarui.ui.activities.VideoActivity;

public class ProfileFragment extends Fragment implements View.OnClickListener{

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        view.findViewById(R.id.btn_profile_notification).setOnClickListener(this);
        view.findViewById(R.id.btn_profile_edit).setOnClickListener(this);
        view.findViewById(R.id.btn_profile_tutorial).setOnClickListener(this);
        view.findViewById(R.id.btn_profile_logout).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.btn_profile_logout){
            getActivity().onBackPressed();
        }else if(id == R.id.btn_profile_tutorial){
            if (getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                playVideoStr("tutorial_portrait_1920");
            }else {
                playVideoStr("tutorial_landscape_3gp");
            }
        } else if(id == R.id.btn_profile_notification){
            //todo implement notification screen
            Toast.makeText(getContext(), "Notification is clicked", Toast.LENGTH_SHORT).show();
        } else if(id == R.id.btn_profile_edit){
           getActivity()
                   .getSupportFragmentManager()
                   .beginTransaction()
                   .replace(R.id.profile_fragment_container, new ProfileEditFragment())
                   .commit();
        }
    }

    private void playVideoStr(String resourceName) {
        Context context = getContext();
        Intent videoPlaybackActivity = new Intent(context, VideoActivity.class);
        int res=this.getResources().getIdentifier(resourceName, "raw", context.getPackageName());
        videoPlaybackActivity.putExtra("fileRes", res);
        startActivity(videoPlaybackActivity);
    }
}
