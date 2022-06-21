package com.kicsit.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var num1EdTxt: EditText? = null
    private var num2EdTxt: EditText? = null
    private var resTxtVw: TextView? = null
    private var errTxtVw: TextView? = null

    private var num1:Int = 0
    private var num2:Int = 0

    private fun validateNums(): Boolean{
        errTxtVw?.text = ""

        val num1Txt = num1EdTxt?.text.toString()
        val num2Txt = num2EdTxt?.text.toString()

        if(num1Txt == "" || num1Txt.equals(null) || num2Txt == "" || num1Txt.equals(null)){
            errTxtVw?.text = "Please check your nums"
            return false;
        }

        num1 = Integer.parseInt(num1Txt)
        num2 = Integer.parseInt(num2Txt)
        return true;
    }

    private fun calculateSum(){
        if(validateNums()){
            resTxtVw?.setText((num1 + num2).toString())
        }
    }

    private fun calculateSub(){
        if(validateNums()){
            resTxtVw?.setText((num1 - num2).toString())
        }
    }

    private fun calculateMul(){
        if(validateNums()){
            resTxtVw?.setText((num1 * num2).toString())
        }
    }

    private fun calculatePow(){
        if(validateNums()){
            var pwr_res = 1
            for(i in 1..num2){
                pwr_res *= num1
            }
            resTxtVw?.setText(pwr_res.toString())
        }
    }

    private fun calculateDiv(){
        if(validateNums()){
            resTxtVw?.setText((num1 / num2).toString())
        }
    }

    private fun calculateRem(){
        if(validateNums()){
            resTxtVw?.setText((num1 % num2).toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        num1EdTxt = findViewById(R.id.num1EdTxt)
        num2EdTxt = findViewById(R.id.num2EdTxt)
        resTxtVw = findViewById(R.id.resTxtVw)
        errTxtVw = findViewById(R.id.errTxtVw)

        findViewById<Button>(R.id.addBtn).setOnClickListener{calculateSum()}
        findViewById<Button>(R.id.subBtn).setOnClickListener{calculateSub()}
        findViewById<Button>(R.id.mulBtn).setOnClickListener{calculateMul()}
        findViewById<Button>(R.id.powBtn).setOnClickListener{calculatePow()}
        findViewById<Button>(R.id.divBtn).setOnClickListener{calculateDiv()}
        findViewById<Button>(R.id.remBtn).setOnClickListener{calculateRem()}
    }
}