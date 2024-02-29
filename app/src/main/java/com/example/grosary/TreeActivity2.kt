package com.example.grosary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView



class TreeActivity2 : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etLength: EditText
    private lateinit var etDiameter: EditText
    private lateinit var btnSubmit: Button
    private lateinit var tvp: TextView
    private lateinit var nametv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tree2)

        etName = findViewById(R.id.etName)
        etLength = findViewById(R.id.etLength)
        etDiameter = findViewById(R.id.etDiameter)
        btnSubmit = findViewById(R.id.btntree)
        tvp = findViewById(R.id.tv_price)
        nametv = findViewById(R.id.txtnamef)

        fast()

        btnSubmit.setOnClickListener {
            value()
        }
    }

    private fun value() {
        val lengthStr = etLength.text.toString()
        val diameterStr = etDiameter.text.toString()

        if (lengthStr.isNotEmpty() && diameterStr.isNotEmpty()) {
            val length = lengthStr.toDouble()
            val diameter = diameterStr.toDouble()

            if (diameter != 0.0 && length != 0.0) {
                val r = 3.14 * (diameter / 2)
                val f = r * length
                val unit = 10
                val ff = f * unit
                tvp.text = ff.toString()
                btnSubmit.text = "pay"

                val name2 = etName.text.toString().trim()
                val intent = Intent(this, PayActivity::class.java)
                intent.putExtra("name", name2)
                intent.putExtra("length", lengthStr)
                intent.putExtra("diameter", diameterStr)
                startActivity(intent)
            } else {
                // Handle division by zero or invalid input
                tvp.text = "Invalid input"
            }
        } else {
            // Handle empty input fields
            tvp.text = "Please enter values"
        }
    }

    private fun fast() {
        val start = intent.getStringExtra("name").toString()
        if (start.isNotEmpty()) {
            val first = start.substring(0, start.length - 10)
            nametv.text = first.toString()
        } else {
            nametv.text = "No name"
        }
    }
}
