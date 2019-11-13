package ru.nortti.numbercheck

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {


    companion object {
        const val TAG = "MainActivity"

        val RUS = Regex("^[АВЕКМНОРСТУХ][\\d]{3}[АВЕКМНОРСТУХ]{2}")
        val TAXI = Regex("^[АВЕКМНОРСТУХ]{2}[\\d]{3}")
        val POLICE = Regex("^[АВЕКМНОРСТУХ][\\d]{4}")

        var lastChar = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberET.addTextChangedListener(object : TextWatcher{
            var space = 0

            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                numberET.requestFocus()
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var color = 0
                var icon = 0
                when {
                    POLICE.containsMatchIn(s.toString()) -> {
                        space = 5
                        color = Color.BLUE
                        icon = R.drawable.police
                    }
                    RUS.containsMatchIn(s.toString()) -> {
                        space = 5
                        color = Color.GREEN
                        icon = R.drawable.plate
                    }
                    TAXI.containsMatchIn(s.toString()) -> {
                        space = 5
                        color = Color.rgb(255, 204,0)
                        icon = R.drawable.taxi
                    }
                    else -> {
                        color = Color.BLACK
                    }
                }

                numberET.setTextColor(color)
                iconIV.setImageResource(icon)
                }

        })



    }
}
