package com.example.testui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import com.example.testui.databinding.ActivitySpinnerBinding

class SpinnerActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySpinnerBinding

    val data2 = listOf(Title("title 1","1"),Title("title 3","3"),Title("title 4","4"))

    val data = listOf(
        mapOf(
            KEY_TITLE to "title1",
            KEY_VALUE to "1"

        ),
        mapOf(
            KEY_TITLE to "title2",
            KEY_VALUE to "2"
        ),
        mapOf(
            KEY_TITLE to "title3",
            KEY_VALUE to "3"
        )
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySpinnerBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            android.R.id.text1,
            data2
        )
        val adapterSimple = SimpleAdapter (
            this,
            data,
            android.R.layout.simple_spinner_item,
            arrayOf(KEY_TITLE),
            intArrayOf(android.R.id.text1)


        )
        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener= object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                binding.textView2.text = data2[position].value
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


    }

    companion object {

        @JvmStatic
        val KEY_TITLE = "title"
        @JvmStatic val KEY_VALUE = "value"
    }

    data class Title(
        val name: String,
        val value: String
    ){
        override fun toString(): String {
            return name
        }
    }
}

