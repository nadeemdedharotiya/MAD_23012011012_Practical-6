package com.example.mad_23012011030_practical6

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AlarmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alarm)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        title = "MAD_Animation_Practical"

        val alarmImage = findViewById<ImageView>(R.id.imageView)
        val frameAnimation = alarmImage.drawable as AnimationDrawable

        val heartAnimation = findViewById<ImageView>(R.id.imageView3)
        val heartFrameAnimation = heartAnimation.drawable as AnimationDrawable

        heartFrameAnimation.start()
        frameAnimation.start()
    }
}
