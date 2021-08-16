package com.example.playsoundapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
public class MainActivity extends AppCompatActivity {
MediaPlayer mediaPlayer;
    SeekBar seekBar;
    AudioManager audioManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar=(SeekBar)findViewById(R.id.seekBar);
        mediaPlayer=MediaPlayer.create(this,R.raw.tune);
        audioManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        int maxv=audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curv=audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        seekBar.setMax(maxv);seekBar.setProgress(curv);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
    public void playmusic(View view){
mediaPlayer.start();
    }
    public void pausemusic(View view){
        if(mediaPlayer.isPlaying())
mediaPlayer.pause();
    }
}