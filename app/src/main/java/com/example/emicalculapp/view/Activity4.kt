package com.example.emicalculapp.view

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.SeekBar.OnSeekBarChangeListener
import com.example.emicalculapp.R
import com.example.emicalculapp.util.Constantly
import kotlinx.android.synthetic.main.activity_4.*

class Activity4 : AppCompatActivity() {


    lateinit var seek_bar: SeekBar
    lateinit var text_view: TextView

    lateinit var tenure_bar: SeekBar
    lateinit var tenure_view: TextView

    lateinit var interest_bar: SeekBar
    lateinit var interest_view: TextView

    lateinit var answer_view: TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4)
        seek_bar = findViewById(R.id.amount_seekBar) as SeekBar
        text_view = findViewById(R.id.amount_textView) as TextView

        tenure_bar = findViewById(R.id.tenure_seekBar) as SeekBar
        tenure_view = findViewById(R.id.tenure_textView) as TextView

        interest_bar = findViewById(R.id.interest_seekBar) as SeekBar
        interest_view = findViewById(R.id.interest_textView) as TextView

        answer_view = findViewById<TextView>(R.id.answer_textView) as TextView

        seek_bar.max = 100
        tenure_bar.max = 100
        interest_bar.max = 100

        seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                text_view.text = "Amount : " + progress.toString() + " / " + seek_bar.max
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                text_view.text = "Amount : " + seekBar.progress + " / " + seek_bar.max

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                text_view.text = "Amount : " + seekBar.progress + " / " + seek_bar.max

            }

        })



        tenure_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tenure_view.text = "Tenure : " + progress.toString() + " / " + tenure_bar.max
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                tenure_view.text = "Tenure : " + seekBar.progress + " / " + tenure_bar.max

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                tenure_view.text = "Tenure : " + seekBar.progress + " / " + tenure_bar.max

            }

        })


        interest_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                interest_view.text = "Interest : " + progress.toString() + "% / " + interest_bar.max + "%"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                interest_view.text = "Interest : " + seekBar.progress + "% / " + interest_bar.max + "%"

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                interest_view.text = "Interest : " + seekBar.progress + "% / " + interest_bar.max + "%"

            }

        })

//        EMI = [P x R x (1+R)^N]/[(1+R)^ (N-1)],
        val cal_button = findViewById<Button>(R.id.calculate_button) as Button

        cal_button.setOnClickListener {
            val interest_bar_value : Double = interest_bar.getProgress() / 100.0
            val emi1 = seek_bar.getProgress() * interest_bar_value *
                    Math.pow((1.0 + interest_bar_value), (1.0 * tenure_bar.getProgress()))

            val emi2 = Math.pow((1.0 + interest_bar_value), (tenure_bar.getProgress() - 1.0))

            val emi = emi1 / emi2

            answer_view.setText("EMI : "+ emi.toFloat())

            Toast.makeText(this, "Yeah baby!", Toast.LENGTH_LONG).show()
        }

    }

}
