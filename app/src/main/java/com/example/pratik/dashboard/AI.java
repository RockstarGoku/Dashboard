package com.example.pratik.dashboard;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class AI extends AppCompatActivity {
    VideoView vid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai);
        vid = (VideoView)findViewById(R.id.videoView);
    }
    public void playVideo(View v) {
        MediaController m = new MediaController(this);
        vid.setMediaController(m);

        String path = "android.resource://com.example.pratik.dashboard/"+R.raw.ai;

        Uri u = Uri.parse(path);

        vid.setVideoURI(u);

        vid.start();

    }
}
