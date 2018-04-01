package edu.rvc.student.week11inclass

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val et1 = findViewById<EditText>(R.id.txtEmail) as EditText

        val preferences = getSharedPreferences ("data", Context.MODE_PRIVATE)

        et1.setText (preferences.getString ("mail", ""))

        val button1 = findViewById <Button>(R.id.btnSubmit) as Button

        button1.setOnClickListener {
            val editor = preferences.edit()
            editor.putString ("mail", txtEmail.text.toString())
            editor.commit()

            finish()
        }
    }
}
