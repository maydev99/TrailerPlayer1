package com.bombadu.trailerplayer1

import android.media.Image
import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class FullscreenActivity : AppCompatActivity() {

    private var isControlShowing = false
    private var isPlaying = true
    private lateinit var videoView: VideoView

    val hpVideoUrl = "https://www.ibrahimabah.com/ibfilms/Harry.Potter-The.Ultimate.Collection.%20I%20-%20VIII%20.%202001-2011.1080p.Bluray.x264.anoXmous/Harry%20Potter%201/Harry.Potter.And.The.Sorcerers.Stone.2001.UEE.1080p.Bluray.x264.anoXmous_.mp4"
    val videoUrl = "https://www.cinemaworldtheaters.com/trailers/ferris_bueller.mp4"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fullscreen)
        supportActionBar?.hide()

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN)

        videoView = findViewById(R.id.videoView)

        videoView.setVideoPath(videoUrl)
        videoView.start()

        videoView.setOnClickListener {
            showControls()
        }
    }

    private fun showControls() {
        val control = findViewById<ImageView>(R.id.controlImageView)
        var stopPosition = 0
        if (!isControlShowing) {
            control.visibility = View.VISIBLE
            isControlShowing = true

            control.setOnClickListener {
                if (isPlaying) {
                    control.setImageResource(R.drawable.ic_baseline_play_arrow_24)
                    stopPosition = videoView.currentPosition
                    videoView.pause()
                } else {
                    control.setImageResource(R.drawable.ic_baseline_pause_24)
                    videoView.seekTo(stopPosition)
                    videoView.start()
                }
            }

        } else {
            control.visibility = View.GONE
            isControlShowing = false
        }

    }

}