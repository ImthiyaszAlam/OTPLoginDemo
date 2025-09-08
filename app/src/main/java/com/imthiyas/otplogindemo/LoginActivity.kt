package com.imthiyas.otplogindemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.ActionCodeSettings
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var sendOtpButton: Button
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailEditText = findViewById(R.id.etEmail)
        sendOtpButton = findViewById(R.id.btnSendOtp)

        sendOtpButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            if (email.isEmpty()) {
                Toast.makeText(this, "Enter email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val actionCodeSettings = ActionCodeSettings.newBuilder()
                .setUrl("https://otplogin-b03ab.web.app/login") // full URL on allowed domain
                .setHandleCodeInApp(true)
                .setAndroidPackageName(packageName, true, null)
                .build()


            auth.sendSignInLinkToEmail(email, actionCodeSettings)
                .addOnSuccessListener {
                    Toast.makeText(this, "OTP sent to $email", Toast.LENGTH_SHORT).show()
                    getSharedPreferences("auth", MODE_PRIVATE).edit()
                        .putString("email", email).apply()
                }
                .addOnFailureListener {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
        }

        // Check if link is clicked
        if (intent?.data != null) {
            handleSignInLink(intent.data.toString())
        }
    }

    private fun handleSignInLink(link: String) {
        val email = getSharedPreferences("auth", MODE_PRIVATE).getString("email", null)
        if (!email.isNullOrEmpty() && auth.isSignInWithEmailLink(link)) {
            auth.signInWithEmailLink(email, link)
                .addOnSuccessListener {
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, DashboardActivity::class.java))
                    finish()
                }
                .addOnFailureListener {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
        }
    }
}
