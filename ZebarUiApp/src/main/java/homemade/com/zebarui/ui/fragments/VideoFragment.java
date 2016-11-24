package homemade.com.zebarui.ui.fragments;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import homemade.com.zebarui.R;

public class VideoFragment extends Fragment implements MediaPlayer.OnPreparedListener, View.OnTouchListener {
    private VideoView mVideoView;

    public VideoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_player, container, false);

        int fileRes=0;
        Bundle e = getActivity().getIntent().getExtras();
        if (e!=null) {
            fileRes = e.getInt("fileRes");
        }

        mVideoView = (VideoView)view.findViewById(R.id.vv_video_player);
        //mVideoView.setOnCompletionListener(this);
        mVideoView.setOnPreparedListener(this);
        mVideoView.setOnTouchListener(this);

        if (!playFileRes(fileRes)){
            getActivity().onBackPressed();
        }

        mVideoView.start();
        return view;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.setLooping(true);
    }
    private boolean playFileRes(int fileRes) {
        if (fileRes==0) {
            stopPlaying();
            return false;
        } else {
            mVideoView.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + fileRes));
            return true;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        if (id ==  R.id.vv_video_player)
            stopPlaying();
        return true;
    }

    @Override
    public void onDetach() {
        stopPlaying();
        super.onDetach();
    }

    private void stopPlaying() {
        if (mVideoView.isPlaying()) {
            mVideoView.stopPlayback();
        }
    }
}
