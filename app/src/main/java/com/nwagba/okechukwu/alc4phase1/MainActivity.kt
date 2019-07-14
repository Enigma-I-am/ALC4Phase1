package com.nwagba.okechukwu.alc4phase1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        profile.setOnClickListener {

            intent = Intent(this@MainActivity, ProfileActivity::class.java)
            startActivity(intent)

        }


        about_alc.setOnClickListener {

            intent = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(intent)

        }
    }
}
