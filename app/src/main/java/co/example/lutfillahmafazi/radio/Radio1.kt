package co.example.lutfillahmafazi.radio

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_radio1.*

class Radio1 : AppCompatActivity() {

    lateinit var player: MediaPlayer
    var url : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio1)

        url = intent.getStringExtra("urlRadio1")

        myProgressBar.isIndeterminate = false
        myProgressBar.visibility = View.INVISIBLE
        myProgressBar.max = 100

        setPlaying()

        btnPlay.isEnabled = true
        btnStop.isEnabled = false

        btnPlay.setOnClickListener {
            myProgressBar.isIndeterminate = true
            myProgressBar.visibility = View.VISIBLE
            player.prepareAsync()
            player.setOnPreparedListener {
                player -> player.start()
                myProgressBar.isIndeterminate = false
            }

            btnPlay.isEnabled = false
            btnStop.isEnabled = true
        }
    }
    private fun setPlaying(){
        player = MediaPlayer()
        player.setDataSource(url)
        player.setOnBufferingUpdateListener { mediaPlayer, percent ->
            myProgressBar.isIndeterminate = true
            myProgressBar.secondaryProgress = 100
        }
    }
}
