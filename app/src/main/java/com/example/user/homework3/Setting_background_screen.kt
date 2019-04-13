package com.example.user.homework3

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_setting_background_screen.*
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso


class Setting_background_screen : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_background_screen)
        Picasso.get().load(R.drawable.one).into(imgAvatar);
        Picasso.get().load(R.drawable.one).into(imgOne);
        Picasso.get().load(R.drawable.two).into(imgTwo);
        Picasso.get().load(R.drawable.three).into(imgThree);
        Picasso.get().load(R.drawable.four).into(imgFour);
        Picasso.get().load(R.drawable.five).into(imgFive);
        Picasso.get().load(R.drawable.six).into(imgSix);
        imgOne.setTag(R.drawable.one);
        imgTwo.setTag(R.drawable.two);
        imgThree.setTag(R.drawable.three);
        imgFour.setTag(R.drawable.four);
        imgFive.setTag(R.drawable.five);
        imgSix.setTag(R.drawable.six);
        addEvent()
    }
    private fun addEvent() {
        imgOne.setOnClickListener(this)
        imgTwo.setOnClickListener(this)
        imgThree.setOnClickListener(this)
        imgFour.setOnClickListener(this)
        imgFive.setOnClickListener(this)
        imgSix.setOnClickListener(this)
        btnSave.setOnClickListener(this)
    }
    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnSave -> {
                val intent = Intent()
                intent.putExtra("background", imgAvatar.getTag() as Int)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
            else -> {
                v.getTag()
                Picasso.get().load(v.getTag()as Int).into(imgAvatar)
                imgAvatar.setTag(v.getTag() as Int)
            }
        }
    }
}
