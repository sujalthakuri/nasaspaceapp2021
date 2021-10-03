package com.example.nasaspaceapp2021.ui

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.VideoView
import com.example.nasaspaceapp2021.R

class EndActivity : AppCompatActivity() {
    private lateinit var mp : MediaPlayer
    private lateinit var videoBackground : VideoView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)



        videoBackground = findViewById(R.id.videoEnd)
        videoBackground.setVideoPath("android.resource://" + packageName  + "/" + R.raw.landed);
        videoBackground.start()

        val handler = Handler()
        handler.postDelayed({
            mp = MediaPlayer.create(this, R.raw.eagle);
            mp.start()
        },2000)

    }
}