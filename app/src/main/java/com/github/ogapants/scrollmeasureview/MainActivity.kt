package com.github.ogapants.scrollmeasureview

import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.ScrollView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textview)
//        textView.translationY = -20.0F
//        textView.translationX = -20.0F
        textView.offsetTopAndBottom(50)
        textView.offsetLeftAndRight(20)

        val scrollView = findViewById<ScrollView>(R.id.scrollView)
        scrollView.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            Log.v("MainActivity", "scroll:19 ***  y: ${getLocationY(textview)} , b:${getLocationRect(textView)}")
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause:19 ***  y: ${getLocationY(textview)} , b:${getLocationRect(textView)}")
    }

    private fun getLocationRect(v: View): Int {
        val rect = Rect()
        v.getLocalVisibleRect(rect)
        Log.i("MainActivity", "getLocationRect:29 ***  $rect")
        val bottom = rect.bottom
        return bottom
    }

    private fun getLocationY(v: View): Int {
        val anchorPos = IntArray(2)
        v.getLocationInWindow(anchorPos)
        Log.w("MainActivity", "getLocationY:35 ***  ${anchorPos[0]},${anchorPos[1]}")
        val i = anchorPos[1]
        return i
    }
}
