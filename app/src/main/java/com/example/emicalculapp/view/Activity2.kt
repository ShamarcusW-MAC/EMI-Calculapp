package com.example.emicalculapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.emicalculapp.R

class Activity2 : AppCompatActivity() {

    val name_submit = "com.example.emicalculapp.name.SUBMIT"
    private var mNameEditText: EditText? = null
    val SUBMIT = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        mNameEditText = findViewById(R.id.name_editText)
    }

    fun launchThird(view: View) {
        val intent = Intent(this, Activity3::class.java)

        val name = mNameEditText?.getText().toString()
        intent.putExtra(name_submit, name)
        startActivityForResult(intent, SUBMIT)

    }
}
