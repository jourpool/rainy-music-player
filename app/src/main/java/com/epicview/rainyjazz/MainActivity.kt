package com.epicview.rainyjazz

import android.graphics.Color
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Build



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.navigationBarColor = Color.TRANSPARENT
            window.setBackgroundDrawable(getDrawable(R.drawable.background))
            lytMain.setBackgroundResource(0)
        }

        val musicPlayer = MediaPlayer.create(this, R.raw.music)
        val rainPlayer = MediaPlayer.create(this, R.raw.rain)

        musicPlayer.isLooping = true
        rainPlayer.isLooping = true

        btnToggleMusic.setOnClickListener {
            if(musicPlayer.isPlaying) {
                musicPlayer.pause()
                rainPlayer.pause()
                btnToggleMusic.setImageResource(R.drawable.btn_play)
            }else {
                musicPlayer.start()
                rainPlayer.start()
                btnToggleMusic.setImageResource(R.drawable.btn_pause)
            }
        }
    }
}
