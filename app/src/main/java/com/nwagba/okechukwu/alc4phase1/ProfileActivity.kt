package com.nwagba.okechukwu.alc4phase1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.request.RequestOptions
import com.nwagba.okechukwu.alc4phase1.config.GlideApp
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val actionBar = supportActionBar
        actionBar!!.title = "Profile"
        actionBar.setDisplayHomeAsUpEnabled(true)

        name.text = "Nwagba Okechukwu Martin"
        track.text = "Track: Android"
        country.text= "Country: Nigeria"
        email.text = "Email: Nwagba001@gmail.com"
        phone_number.text = "Phone Number: 07056322074"
        slack.text = "Slack Username: @enigma_I_am"

        val imageUrl = "https://pbs.twimg.com/profile_images/1018793408989626369/HuXXo0ZC_400x400.jpg"

        loadImage(imageUrl,imageView)


    }

    private fun loadImage(url:String , imgview:ImageView){

        GlideApp.with(this@ProfileActivity)
            .load(url)
            .apply(RequestOptions.circleCropTransform())
            .placeholder(R.drawable.ic_account_circle_black_24dp)
            .into(imgview)


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
