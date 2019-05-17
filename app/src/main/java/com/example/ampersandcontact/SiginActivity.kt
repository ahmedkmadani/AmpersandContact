package com.example.ampersandcontact

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.RequestFuture
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_signin.*
import org.json.JSONObject

val url_sigin = "https://ampersand-contact-exchange-api.herokuapp.com/api/v1/login"

class SiginActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        btn_signin.setOnClickListener {
            Sigin()
        }
    }

    private fun Sigin() {

        if (!validate()) {
            return
        }

        val progressDialog = ProgressDialog(this@SiginActivity,com.example.ampersandcontact.R.style.AppTheme)
        progressDialog.isIndeterminate = true
        progressDialog.setMessage("Login...")
        progressDialog.show()

        val user_email = input_email!!.text.toString()
        val user_pass = input_password!!.text.toString()

        val JsonObj = JSONObject()
        JsonObj.put("email", user_email)
        JsonObj.put("password", user_pass)

        val que = Volley.newRequestQueue(this@SiginActivity)
        val req = JsonObjectRequest(Request.Method.POST, url_sigin, JsonObj, Response.Listener <JSONObject> {response ->


            // code insert into database and create login session here

            Log.d("Response", response.toString())

            onSiginSuccess()
            progressDialog.dismiss()


        }, Response.ErrorListener {

            progressDialog.dismiss()
            onSiginFailed()

        })

        que.add(req)
    }


    fun validate(): Boolean {
        var valid = true

        val email = input_email!!.text.toString()
        val password = input_password!!.text.toString()

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            input_email!!.error = "enter a valid email address"
            valid = false
        } else {
            input_email!!.error = null
        }

        if (password.isEmpty() || password.length < 2 || password.length > 10) {
            input_password!!.error = "between 4 and 10 alphanumeric characters"
            valid = false
        } else {
            input_password!!.error = null
        }

        return valid
    }

    fun onSiginSuccess(){

        Toast.makeText(this@SiginActivity, "login Successfully", Toast.LENGTH_LONG).show()
        startActivity(Intent(this, HomeActivity::class.java))
    }

    fun onSiginFailed(){

        Toast.makeText(this@SiginActivity, "login Failed", Toast.LENGTH_LONG).show()
    }

}
