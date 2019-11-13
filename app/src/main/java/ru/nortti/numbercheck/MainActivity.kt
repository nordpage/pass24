package ru.nortti.numbercheck

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {


    companion object {
        const val TAG = "MainActivity"

        val RUS = Regex("^[АВЕКМНОРСТУХ]{1}[\\d]{3}[АВЕКМНОРСТУХ]{2}[\\d]{2}")
        val TAXI = Regex("^[АВЕКМНОРСТУХ+]{2}[\\d]{5,6}")
        val POLICE = Regex("^[АВЕКМНОРСТУХ]{1}[\\d]{6,7}")

        var lastChar = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        numberET.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {



            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                numberET.setBackgroundColor(Color.TRANSPARENT)
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var name = ""
                var space = 0
                 if (POLICE.containsMatchIn(s.toString())) {
                    space = 5
                     if (count == space) numberET.append(" ")
                     numberET.setBackgroundColor(Color.BLUE)
                } else if(RUS.containsMatchIn(s.toString())) {
                    space = 6
                     if (count == space) numberET.append(" ")
                     numberET.setBackgroundColor(Color.TRANSPARENT)
                } else if (TAXI.containsMatchIn(s.toString())) {
                     numberET.setBackgroundColor(Color.YELLOW)
                     space = 5
                     if (count == space) numberET.append(" ")
                }

                }

        })



    }
}
