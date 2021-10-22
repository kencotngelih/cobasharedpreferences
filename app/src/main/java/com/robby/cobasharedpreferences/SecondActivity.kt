package com.robby.cobasharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private val sharedPreferences: SharedPreferences by lazy {
        getSharedPreferences("simple_value", Context.MODE_PRIVATE)
    }

    private val tvResult: TextView by lazy {
        findViewById(R.id.tv_result)
    }

    private val btnResult: Button by lazy {
        findViewById(R.id.btn_result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        btnResult.setOnClickListener {
        val textResult = sharedPreferences.getString("value", "")
        tvResult.text = textResult
        }
    }
}