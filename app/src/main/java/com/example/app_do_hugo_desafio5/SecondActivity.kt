package com.example.app_do_hugo_desafio5

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        var button:Button = findViewById(R.id.button4)
        var salvar:Button = findViewById(R.id.button6)

        var sharedPreferences2 = getSharedPreferences("mypref", Context.MODE_PRIVATE)
        var editor = sharedPreferences2.edit()

        var txt1: TextView = findViewById(R.id.textView4)
        var txt2: TextView = findViewById(R.id.textView5)
        var txt3: TextView = findViewById(R.id.textView6)
        var txt4: TextView = findViewById(R.id.textView7)

        txt1.setText(sharedPreferences2.getString("name", "Huguin"))
        txt2.setText(sharedPreferences2.getString("date","01/01/2023"))
        txt3.setText(sharedPreferences2.getString("address","Rua dos Bobos"))
        txt4.setText("Convidados: ${sharedPreferences2.getInt("qnt",0)}")

        var tt1: EditText = findViewById(R.id.editTextText)
        var tt2: EditText = findViewById(R.id.editTextText2)
        var tt3: EditText = findViewById(R.id.editTextText3)
        var tt4: EditText = findViewById(R.id.editTextText4)

        salvar.setOnClickListener {
            editor.putString("name",tt1.text.toString())
            editor.putString("date",tt2.text.toString())
            editor.putString("address",tt3.text.toString())
            editor.putInt("qnt",tt4.text.toString().toInt())

            editor.apply()

            txt1.setText("Nome do Evento: ${sharedPreferences2.getString("name","Huguin")}")
            txt2.setText("Data do Evento: ${sharedPreferences2.getString("date","01/01/2023")}")
            txt3.setText("Enrereço: ${sharedPreferences2.getString("address","Rua dos Bobos")}")
            txt4.setText("Convidados: ${sharedPreferences2.getInt("qnt",0)}")

        }

        button.setOnClickListener {
            finish()
        }
    }
}
