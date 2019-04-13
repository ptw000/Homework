package com.example.user.homework3

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.ColorInt
import android.util.Log
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addEvents()
    }
    private fun addEvents() {
        btnBackground.setOnClickListener(this)
        btnTitle.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btnBackground -> {
                val intent = Intent(this, Setting_background_screen::class.java)
                startActivityForResult(intent, REQUEST_SETTING_BACKGROUND_CODE)
            }
            R.id.btnTitle -> {
                val intent = Intent(this, Setting_title_screen::class.java)
                startActivityForResult(intent, REQUEST_SETTING_TITLE_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_SETTING_BACKGROUND_CODE && resultCode == Activity.RESULT_OK) {
            val background = data?.getIntExtra("background", 0)!!
            Picasso.get().load(background).into(imgAvatar)
        }
        else if(requestCode == REQUEST_SETTING_TITLE_CODE && resultCode == Activity.RESULT_OK) {
            val text = data?.getStringExtra("text")
            val color = data?.getIntExtra("color", 0)!!
            txtName.setText(text)
            txtName.setTextColor(color)
        }
    }
    companion object {
        const val REQUEST_SETTING_BACKGROUND_CODE = 1
        const val REQUEST_SETTING_TITLE_CODE = 2
    }
}
