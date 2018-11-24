package co.example.lutfillahmafazi.radio

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRadio1.setOnClickListener {
            val intent = Intent(this,Radio1::class.java)
            intent.putExtra("urlRadio1","http://stream.masima.co.id:8000/prambors.m3u")
            startActivity(intent)
        }
    }
}
