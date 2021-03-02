package com.example.basiccalculatorkotlin

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCalculate  = button
        val textResult = result

        btCalculate.setOnClickListener {

            var firstGrade = (Integer.parseInt(first_grade.text.toString())).toDouble()
            var secondGrade = (Integer.parseInt(second_grade.text.toString())).toDouble()
            var totalAbsences = Integer.parseInt(absences.text.toString())
            if(firstGrade > 0 && firstGrade <= 10 && secondGrade > 0 && secondGrade <= 10) {
                var media = firstGrade.plus(secondGrade) / 2
                if (media >= 6 && totalAbsences < 10) {
                    textResult.setText("Status: Approved\nTotal grade: $media\nTotal absences: $totalAbsences")
                    textResult.setTextColor(Color.GREEN)
                } else {
                    textResult.setText("Status: Failed\nTotal grade: $media\nTotal absences: $totalAbsences")
                    textResult.setTextColor(Color.RED)
                }
            }
            else{
                textResult.setText("Error!\nIncorrect grade typed!")
            }
        }


    }
}