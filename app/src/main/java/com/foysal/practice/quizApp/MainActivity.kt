package com.foysal.practice.quizApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.makeText
import es.dmoral.toasty.Toasty

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //(fix it)window.decorView.systemUiVisibility = SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        val btnStart = findViewById<Button>(R.id.btn_start)
        var editText = findViewById<EditText>(R.id.editTxt)

        btnStart.setOnClickListener {
            if(editText.text.toString().isEmpty()){
                Toasty.warning(this,
                    "Please Enter Your Name", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, QuizQuestionActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

    }

    fun onClick(view: View){
        Toast.makeText(this, "Button Works", Toast.LENGTH_LONG).show()
    }
}