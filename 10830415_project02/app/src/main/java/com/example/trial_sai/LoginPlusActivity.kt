package com.example.trial_sai

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_loginplus.*

class LoginPlusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginplus)

        val db = DB(applicationContext)

        login.setOnClickListener {
            if (editTextTextPersonName3.text.isNullOrBlank() || editTextTextPassword2.text.isNullOrBlank()) {
                Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT).show()
            } else {
                val holUp = db.checkUser(editTextTextPersonName3.toString())
                if(holUp)
                {
                    Toast.makeText(
                        this,
                        "At least we know you!",
                        Toast.LENGTH_SHORT
                    ).show()
                    val check = db.checkUserPassword(editTextTextPersonName3.toString(), editTextTextPassword2.toString())
                    if(check){
                        Toast.makeText(
                            this,
                            "${editTextTextPersonName3.text} has logged in!",
                            Toast.LENGTH_SHORT
                        ).show()
                        val intent = Intent(this@LoginPlusActivity, MainActivity3::class.java)
                        startActivity(intent)
                    } else
                    {
                        Toast.makeText(
                            this,
                            "New phone, who dis?!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                } else
                {
                    Toast.makeText(
                        this,
                        "Sign up first?!",
                        Toast.LENGTH_SHORT
                    ).show()


                }

            }


        }

    }
}