package com.notification.postretrofitexample.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.notification.postretrofitexample.R
import com.notification.postretrofitexample.api.RetrofitClient
import com.notification.postretrofitexample.models.DefaultResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSignup.setOnClickListener{

            val title =editTextTitle.text.toString().trim()
            val body =editTextBody.text.toString().trim()


            if(title.isEmpty())
            {
                editTextTitle.error="Title Required"
                editTextTitle.requestFocus()
                return@setOnClickListener
            }

            if(body.isEmpty())
            {
                editTextBody.error="Body Required"
                editTextBody.requestFocus()
                return@setOnClickListener
            }

            RetrofitClient.instance.createUser(title ,body).enqueue(object :Callback<DefaultResponse>
            {

                override fun onResponse(call: Call<DefaultResponse>, response: Response<DefaultResponse>)
                {
                    Toast.makeText(applicationContext, "data entered", Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<DefaultResponse>, t: Throwable)
                {
                    Toast.makeText(applicationContext,t.message, Toast.LENGTH_LONG).show()
                }

            })


        }

    }
}