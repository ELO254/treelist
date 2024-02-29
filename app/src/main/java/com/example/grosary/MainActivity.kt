package com.example.grosary

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text:TextView = findViewById(R.id.textView)


        val change = Typeface.createFromAsset(assets,"Copyduck.otf")
        text.typeface = change

        Handler().postDelayed({
            val mainIntent = Intent(this, registerActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, 3000L)
    }
}