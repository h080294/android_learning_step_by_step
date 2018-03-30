package com.johnhao.demo.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.johnhao.demo.R;

import java.io.File;
import java.io.IOException;

public class MediaPlayAudioActivity extends BaseActivity implements View.OnClickListener{

    private MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_play_audio);
        setTitle("Play Audio");
        Button audio_play = findViewById(R.id.btn_media_audio_play);
        Button audio_pause = findViewById(R.id.btn_media_audio_pause);
        Button audio_stop = findViewById(R.id.btn_media_audio_stop);
        audio_play.setOnClickListener(this);
        audio_pause.setOnClickListener(this);
        audio_stop.setOnClickListener(this);

        if (ContextCompat.checkSelfPermission(MediaPlayAudioActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MediaPlayAudioActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            initPlayer();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    initPlayer();
                } else {
                    Toast.makeText(this, "You denined the permission, this will be closed the app", Toast.LENGTH_LONG).show();
                    finish();
                }
                break;
            default:
                break;
        }
    }

    private void initPlayer() {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "music.mp3");
            mediaPlayer.setDataSource(file.getPath());
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_media_audio_play:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                }
                break;
            case R.id.btn_media_audio_pause:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                }
                break;
            case R.id.btn_media_audio_stop:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.reset();
                    initPlayer();
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }
}
