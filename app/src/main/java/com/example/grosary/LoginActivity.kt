package com.example.grosary

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase





class LoginActivity : AppCompatActivity() {

    private lateinit var emailt: EditText
    private lateinit var passt: EditText
    private lateinit var login: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val text: TextView = findViewById(R.id.txtlog)
        val but: Button = findViewById(R.id.buttonLG)
        emailt = findViewById(R.id.edt_emailLG)
        passt = findViewById(R.id.edt_passLG)

        login = FirebaseAuth.getInstance()

        val change = Typeface.createFromAsset(assets, "Copyduck.otf")
        text.typeface = change

        but.setOnClickListener {

            login()
        }
    }

    private fun login() {
        val email = emailt.text.toString().trim()
        val pass = passt.text.toString().trim()

        if (email.isBlank() || pass.isBlank()) {
            Toast.makeText(this, "Please complete the fields", Toast.LENGTH_SHORT).show()
        } else {
            login.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Logged in successfully", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, TreeActivity2::class.java)
                    intent.putExtra("name",email)
                    startActivity(intent)
                     // Finish the current activity after starting the TreeActivity
                } else {
                    Toast.makeText(this, "Failed to log in", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
