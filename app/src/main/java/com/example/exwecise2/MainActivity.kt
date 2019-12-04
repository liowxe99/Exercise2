package com.example.exwecise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.buttonCalculate).setOnClickListener{
            calculateBMI(it)
        }
        findViewById<Button>(R.id.buttonReset).setOnClickListener{
            clearScreen(it)
        }
    }

    private fun calculateBMI(view: View){
        val weight = findViewById<EditText>(R.id.editTextWeight)
        val height = findViewById<EditText>(R.id.editTextHeight)
        val resultBMI = findViewById<ImageView>(R.id.imageViewProfile)

        val result:Double = weight.text.toString().toDouble() / (height.text.toString().toDouble()/100*height.text.toString().toDouble()/100)
        val text = findViewById<TextView>(R.id.textViewBMIresult)
        text.text = result.toString()
        when{
            result<18.5 ->resultBMI.setBackgroundResource(R.drawable.under)
            result>24.9->resultBMI.setBackgroundResource(R.drawable.over)
            else -> resultBMI.setBackgroundResource(R.drawable.normal)
        }
    }
    private fun clearScreen(view: View){

        findViewById<EditText>(R.id.editTextWeight).setText("")
        findViewById<EditText>(R.id.editTextHeight).setText("")
        findViewById<ImageView>(R.id.imageViewProfile).setBackgroundResource(R.drawable.empty)
        findViewById<TextView>(R.id.textViewBMIresult).setText("")

    }
}
