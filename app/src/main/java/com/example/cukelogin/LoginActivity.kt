package com.example.cukelogin
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var loginBtn: Button
    private lateinit var errorText: TextView

    companion object {
        private const val VALID_USER = "user"
        private const val VALID_PASS = "pass1234"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        username = findViewById(R.id.usernameField)
        password = findViewById(R.id.passwordField)
        loginBtn  = findViewById(R.id.loginButton)
        errorText = findViewById(R.id.errorText)

        loginBtn.setOnClickListener {
            errorText.text = ""
            val u = username.text.toString().trim()
            val p = password.text.toString()

            if (u.isEmpty()) { errorText.text = "Enter username"; return@setOnClickListener }
            if (p.isEmpty()) { errorText.text = "Enter password"; return@setOnClickListener }
            if (p.length < 6) { errorText.text = "Password too short"; return@setOnClickListener }

            if (u == VALID_USER && p == VALID_PASS) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                errorText.text = "Invalid credentials"
            }
        }
    }
}
