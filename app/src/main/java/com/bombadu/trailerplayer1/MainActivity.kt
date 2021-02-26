package com.bombadu.trailerplayer1

import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.VideoView
import com.bombadu.trailerplayer1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.fullScreenButton.setOnClickListener {
            startActivity(Intent(this, FullscreenActivity::class.java))
        }

        val videoUrl = "https://www.cinemaworldtheaters.com/trailers/ferris_bueller.mp4"
        val hpVideoUrl = "https://www.ibrahimabah.com/ibfilms/Harry.Potter-The.Ultimate.Collection.%20I%20-%20VIII%20.%202001-2011.1080p.Bluray.x264.anoXmous/Harry%20Potter%201/Harry.Potter.And.The.Sorcerers.Stone.2001.UEE.1080p.Bluray.x264.anoXmous_.mp4"
        val videoView = findViewById<VideoView>(R.id.videoView)

        //videoView.setVideoPath(hpVideoUrl)
       // videoView.start()
        /*val uri = Uri.parse(videoUrl)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.setDataAndType(uri, "video/mp4")
        startActivity(intent)*/
    }
}