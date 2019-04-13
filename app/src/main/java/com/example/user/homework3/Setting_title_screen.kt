package com.example.user.homework3

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_setting_title_screen.*

class Setting_title_screen : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_title_screen)
        addEvents()
    }
    private fun addEvents() {
        imgAvatar.setOnClickListener(this)
        imgOne.setOnClickListener(this)
        imgTwo.setOnClickListener(this)
        imgThree.setOnClickListener(this)
        imgFour.setOnClickListener(this)
        imgFive.setOnClickListener(this)
        imgSix.setOnClickListener(this)
        btnSave.setOnClickListener(this)
        imgOne.setTag(R.color.colorPrimaryDark)
        imgTwo.setTag(R.color.colorGreen)
        imgThree.setTag(R.color.colorOrange)
        imgFour.setTag(R.color.colorPink)
        imgFive.setTag(R.color.colorYellowt)
        imgSix.setTag(R.color.colorRed)
        imgAvatar.setTag(R.color.colorPrimaryDark)
    }
    override fun onClick(v: View) {
        when(v.id) {
            R.id.btnSave -> {
                val intent = Intent();
                intent.putExtra("text", edText.text.toString())
                intent.putExtra("color",  resources.getColor(imgAvatar.getTag() as Int))
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
            else -> {
                imgAvatar.setBackgroundResource(v.getTag() as Int)
                imgAvatar.setTag(v.getTag())

            }
        }
    }
}
