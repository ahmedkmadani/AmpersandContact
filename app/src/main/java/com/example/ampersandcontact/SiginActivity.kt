package com.example.ampersandcontact

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signin.*

class SiginActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        btn_signin.setOnClickListener {

            Sigin()
        }

    }

    private fun Sigin() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        val user_email = input_email.text
        val user_pass = input_password.text

        Toast.makeText(this@SiginActivity, user_email , Toast.LENGTH_LONG).show()

        val intentHome = Intent(this, HomeActivity::class.java)
        startActivity(intentHome)
    }
}