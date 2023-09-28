package com.example.app_do_hugo_desafio5

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sharedPreferences = getSharedPreferences("mypref", Context.MODE_PRIVATE)

        var value: Int = sharedPreferences.getInt("num",0)


        var editor = sharedPreferences.edit()

        var textCont: TextView = findViewById(R.id.textView)

        var button: Button = findViewById(R.id.button3)

        textCont.setText(value.toString())

        var addButton: Button = findViewById(R.id.button2)
        var subButton: Button = findViewById(R.id.button)

        subButton.setOnClickListener{
            value = value - 1
            editor.putInt("num",value)
            editor.apply()
            textCont.setText(value.toString())
        }

        addButton.setOnClickListener {
            value = value + 1
            editor.putInt("num",value)
            editor.apply()
            textCont.setText(value.toString())
        }

        button.setOnClickListener {
            var intent: Intent = Intent(this,SecondActivity::class.java)

            startActivity(intent)
        }


    }
}