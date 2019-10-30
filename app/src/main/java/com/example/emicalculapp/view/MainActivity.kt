package com.example.emicalculapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import com.example.emicalculapp.R

class MainActivity : AppCompatActivity() {

    val TEXT_REQUEST = 1
    val EXTRA_MESSAGE = "com.example.doubleactivity.extra.MESSAGE"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun launchSecond(view: View) {
        val intent = Intent(this, Activity2::class.java)
//        val message = mMessageEditText.getText().toString()
//        intent.putExtra(EXTRA_MESSAGE, message)
        startActivityForResult(intent, TEXT_REQUEST)
    }

}
