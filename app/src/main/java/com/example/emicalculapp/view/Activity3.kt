package com.example.emicalculapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.TextView
import android.content.Intent
import android.graphics.Bitmap
import android.view.View
import android.widget.EditText
import com.example.emicalculapp.R
import com.example.emicalculapp.util.Constantly
import com.example.emicalculapp.util.Constantly.name_submit
import kotlinx.android.synthetic.main.activity_3.*

class Activity3 : AppCompatActivity() {
//    private var mNameText: EditText? = null


    val CAPTURE = 3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

//        mNameText = findViewById(R.id.name_textView)


        val intent = intent

        val message = intent?.getStringExtra(Constantly.name_submit)


        val textView = findViewById<TextView>(R.id.name_textView)

        textView.text = message

        photo_button.setOnClickListener {
            var i= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(i, 123)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==123)
        {
            var bmp = data?.extras?.get("data") as Bitmap
            profilepicture_imageview.setImageBitmap(bmp)
        }
    }

    fun launchFourth(view: View) {
        val intent = Intent(this, Activity4::class.java)
//        val name = mNameText?.getText().toString()
//        intent.putExtra(name_submit, name)
        startActivityForResult(intent, CAPTURE)


    }
}
