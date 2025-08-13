package com.mkt120.sampleapplication.startactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mkt120.sampleapplication.R

class NextActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_RESULT_DATA = "extra_result_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startactivity_next)

        val button1 = findViewById<Button>(R.id.button_1)
        button1.setOnClickListener {
            // 処理結果をintentに設定してActivityを終了する
            val data = Intent().apply {
                putExtra(EXTRA_RESULT_DATA, button1.text.toString())
            }
            setResult(RESULT_OK, data)
            finish()
        }
        val button2 = findViewById<Button>(R.id.button_2)
        button2.setOnClickListener {
            // 処理結果をintentに設定してActivityを終了する
            val data = Intent().apply {
                putExtra(EXTRA_RESULT_DATA, button2.text.toString())
            }
            setResult(RESULT_OK, data)
            finish()
        }
    }
}