package com.example.ampersandcontact

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_register.*
import org.json.JSONObject

val url_register = "https://ampersand-contact-exchange-api.herokuapp.com/api/v1/register"

class RegisterActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register.setOnClickListener {
            register()
        }
    }

    private fun register() {

        val JsonObj = JSONObject()

        val input_name = input_name.text
        val input_email = input_email.text
        val input_password = input_password.text
        val input_phone = input_phone.text
        val input_role = input_role.text
        val input_twitter = input_twitter.text
        val input_linkidn = input_linkedln.text

        JsonObj.put("email", input_email)
        JsonObj.put("password", input_password)
        JsonObj.put("firstName", input_name)
        JsonObj.put("lastName", input_name)
        JsonObj.put("twitter", input_twitter)
        JsonObj.put("website", input_role)

        val que = Volley.newRequestQueue(this@RegisterActivity)
        val req = JsonObjectRequest(Request.Method.POST, url_register, JsonObj, Response.Listener {

            Toast.makeText(this@RegisterActivity, "Register Successfully", Toast.LENGTH_LONG).show()

        }, Response.ErrorListener {

            Toast.makeText(this@RegisterActivity, "Register Failed" , Toast.LENGTH_LONG).show()

        })

        que.add(req)
    }
}