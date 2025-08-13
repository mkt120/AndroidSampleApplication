package com.mkt120.sampleapplication.bitmap

import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.mkt120.sampleapplication.R
import java.net.URL

class BitmapActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_bitmap)
    val imageView = findViewById<ImageView>(R.id.image_view)
    val imageUrl = "https://placehold.jp/300x300.png"

    val handler = Handler(Looper.getMainLooper())
    Thread {
      val bitmap = URL(imageUrl).openStream().use {
        BitmapFactory.decodeStream(it)
      }
      handler.post {
        imageView.setImageBitmap(bitmap)
      }
    }.start()
    imageView.setBackgroundColor(0xfff)
  }
}