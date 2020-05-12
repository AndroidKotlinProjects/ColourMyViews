package com.example.android.colourmyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.android.colourmyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit private var binding: ActivityMainBinding
    lateinit private var selectedView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()

        selectedView = binding.boxOneText
    }

    private fun setListeners() {
        val colourableViews: List<View> =
            listOf(binding.boxOneText, binding.boxTwoText, binding.boxThreeText,
            binding.boxFourText, binding.boxFiveText)
        for (view in colourableViews) {
            view.setOnClickListener(this::setSelected)
        }
        val buttons: List<Button> = listOf(binding.redButton, binding.greenButton,
            binding.yellowButton)
        for (view in buttons) {
            view.setOnClickListener(this::makeColored)
        }
    }

    private fun setSelected(view: View) {

        when (view.id) {
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
        selectedView = when (view.id) {
            R.id.box_one_text, R.id.box_two_text, R.id.box_three_text,
                R.id.box_four_text, R.id.box_five_text -> view
            else -> selectedView
        }
    }

    fun makeColored(view: View) {
        when (view.id) {

            R.id.red_button -> selectedView.setBackgroundResource(R.color.button_red)
            R.id.yellow_button -> selectedView.setBackgroundResource(R.color.button_yellow)
            R.id.green_button -> selectedView.setBackgroundResource(R.color.button_green)

            else -> selectedView.setBackgroundColor(Color.LTGRAY)
        }
    }
}
