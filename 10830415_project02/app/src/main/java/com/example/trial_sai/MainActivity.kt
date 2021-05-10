package com.example.trial_sai

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.contentValuesOf
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            val helper = DB(applicationContext)


           /* if (rs.moveToNext())
                Toast.makeText(applicationContext, rs.getString( 1), Toast.LENGTH_SHORT).show()
                            var rs = db.rawQuery( "SELECT * FROM USERS", null)
                             var db = helper.readableDatabase
 */

        btnSign.setOnClickListener() {
            if (editTextTextPersonName.text.isNullOrBlank()||editTextTextEmailAddress.text.isNullOrBlank()||editTextTextPassword.text.isNullOrBlank()) {
                Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT).show()
            }
            else {
                val first = helper.checkUser(editTextTextPersonName.toString())
                if(first)
                {
                    Toast.makeText(this, "User already exists", Toast.LENGTH_SHORT).show()
                } else {

                    val res = helper.insertData(
                        editTextTextPersonName.toString(),
                        editTextTextEmailAddress.toString(),
                        editTextTextPassword.toString()
                    )
                    if (res) {
                        Toast.makeText(
                            this,
                            "${editTextTextPersonName.text} has successfully signed up",
                            Toast.LENGTH_SHORT
                        ).show()
                        val intent = Intent(this@MainActivity, LoginPlusActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(applicationContext, "Didn't work, sorry", Toast.LENGTH_SHORT)
                            .show()
                    }

                }


            }


            editTextTextPersonName.setText("")
            editTextTextPersonName2.setText("")
            editTextTextEmailAddress.setText("")
            editTextTextPassword.setText("")

            editTextTextPersonName.requestFocus()


                }


        btnSignIn.setOnClickListener{
            val intent = Intent(this@MainActivity, LoginPlusActivity::class.java)
            startActivity(intent)

        }

        }

    }

