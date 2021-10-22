package com.robby.cobasharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val sharedPreferences: SharedPreferences by lazy {
        getSharedPreferences("simple_value", Context.MODE_PRIVATE)
    }

    private val etValue: EditText by lazy {
        findViewById(R.id.et_value)
    }

    private val btnValue: Button by lazy {
        findViewById(R.id.btn_value)
    }

    private val tvResult: TextView by lazy {
        findViewById(R.id.tv_result)
    }

    private val btnResult: Button by lazy {
        findViewById(R.id.btn_result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preferencesEditor = sharedPreferences.edit()

        btnValue.setOnClickListener {
            val textValue = etValue.text.toString()
            preferencesEditor.putString("value", textValue)
            preferencesEditor.apply()
        }

        btnResult.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
            finish()
        }

    }
}