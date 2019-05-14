package com.example.ampersandcontact

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.RequestFuture
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_signin.*
import org.json.JSONObject

val url = "https://ampersand-contact-exchange-api.herokuapp.com/api/v1/login"

class SiginActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        btn_signin.setOnClickListener {
            Sigin()
        }
    }

    private fun Sigin() {

        val JsonObj = JSONObject()

        val user_email = input_email.text
        val user_pass = input_password.text

        JsonObj.put("email", user_email)
        JsonObj.put("password", user_pass)

        val que = Volley.newRequestQueue(this@SiginActivity)
        val req = JsonObjectRequest(Request.Method.POST, url, JsonObj, Response.Listener {

            Toast.makeText(this@SiginActivity, "login Successfully", Toast.LENGTH_LONG).show()

        }, Response.ErrorListener {

            Toast.makeText(this@SiginActivity, "login Failed", Toast.LENGTH_LONG).show()

        })

        que.add(req)
    }

}
