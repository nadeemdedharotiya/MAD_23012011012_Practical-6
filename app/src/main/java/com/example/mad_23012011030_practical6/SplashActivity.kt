package com.example.mad_23012011030_practical6

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity(), Animation.AnimationListener {

    lateinit var guniLogo: ImageView
    lateinit var guniFrontAnimation: AnimationDrawable
    lateinit var animGrowSpin: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        guniLogo = findViewById(R.id.main_image_uvpce)
        guniLogo.setBackgroundResource(R.drawable.uvpce_animation_list)

        guniFrontAnimation = guniLogo.background as AnimationDrawable

        animGrowSpin = AnimationUtils.loadAnimation(this, R.anim.twin_animation)
        animGrowSpin.setAnimationListener(this)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            guniFrontAnimation.start()
            Handler().postDelayed({
                guniLogo.startAnimation(animGrowSpin)
            }, 1000)
        } else {
            guniFrontAnimation.stop()
        }
    }

    override fun onAnimationEnd(animation: Animation?) {
        val intent = Intent(this, AlarmActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onAnimationRepeat(animation: Animation?) {}
    override fun onAnimationStart(animation: Animation?) {}
}
