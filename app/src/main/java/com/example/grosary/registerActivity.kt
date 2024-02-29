package com.example.grosary

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase





class registerActivity : AppCompatActivity() {

    private lateinit var registerbt: Button
    private lateinit var edtemail: EditText
    private lateinit var edtpass: EditText
    private lateinit var logintxt: TextView
    private lateinit var regtxt: TextView
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerbt = findViewById(R.id.buttonreg)
        logintxt = findViewById(R.id.txtlg)
        regtxt = findViewById(R.id.txtreg)
        edtemail = findViewById(R.id.edt_emailreg)
        edtpass = findViewById(R.id.edt_passreg)

        auth = FirebaseAuth.getInstance()

        val change = Typeface.createFromAsset(assets, "Copyduck.otf")
        regtxt.typeface = change

        registerbt.setOnClickListener {
            reg()
        }
        logintxt.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun reg() {
        val email = edtemail.text.toString()
        val pass = edtpass.text.toString()

        if (email.isBlank() || pass.isBlank()) {
            Toast.makeText(this, "Please enter the credentials", Toast.LENGTH_SHORT).show()
        } else {
            auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Successfully registered", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Failed to register", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
