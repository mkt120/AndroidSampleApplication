package com.mkt120.sampleapplication.startactivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import com.mkt120.sampleapplication.R

class FirstActivity : AppCompatActivity() {

  private val activityResultLauncher = registerForActivityResult(StartActivityForResult()) { result ->
    if (result.resultCode != RESULT_OK) {
      // キャンセルされた
      return@registerForActivityResult
    }
    val data = result.data?.getStringExtra(NextActivity.EXTRA_RESULT_DATA)
    val textView = findViewById<TextView>(R.id.text_view_result)
    textView.text = "$data:がタップされました"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    findViewById<View>(R.id.button_start_activity).setOnClickListener {
      val intent = Intent(this@FirstActivity, NextActivity::class.java)
      startActivity(intent)
    }

    findViewById<View>(R.id.button_register_activity_for_result).setOnClickListener {
      val intent = Intent(this@FirstActivity, NextActivity::class.java)
      activityResultLauncher.launch(intent)
    }
  }
}