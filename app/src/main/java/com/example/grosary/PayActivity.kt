package com.example.grosary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PayActivity : AppCompatActivity() {

    private lateinit var length:TextView
    private lateinit var name:TextView
    private lateinit var diameter:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)

        var n = intent.getStringExtra("name")
        var l = intent.getStringExtra("length")
        var d = intent.getStringExtra("diameter")

        length =  findViewById(R.id.txtlength)
        name = findViewById(R.id.txtname)
        diameter = findViewById(R.id.txtdiameter)

        name.text = "TREE: " + n.toString()
        length.text = "LENGTH: " + l.toString() + "meters"
        diameter.text = "DIAMETER: " + d.toString() + "meters"


    }
}