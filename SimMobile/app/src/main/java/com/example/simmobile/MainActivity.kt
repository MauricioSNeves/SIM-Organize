package com.example.simmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.simmobile.data.LoginData
import com.example.simmobile.interfaces.OpenAplication
import kotlinx.android.synthetic.main.activity_main.alertEmail
import kotlinx.android.synthetic.main.activity_main.alertPassword
import kotlinx.android.synthetic.main.activity_main.ipt_email
import kotlinx.android.synthetic.main.activity_main.ipt_password
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(component:View){
        val email =  ipt_email.text;
        val password =  ipt_password.text;

        if(email.length < 3 || email.equals("") ){
            alertEmail.visibility = View.VISIBLE;
            alertEmail.text = "Digite um e-mail válido"
            return;
        }
        else{
            alertEmail.visibility = View.GONE;
        }
        if(password.length < 3 || password.equals("") ){
            alertPassword.visibility = View.VISIBLE;
            alertPassword.text = "Digite uma senha válido"
            return;
        }
        else{
            alertPassword.visibility = View.GONE;
        }

        login()

    }

    fun login(){
            val email =  ipt_email.text.toString();
            val senha =  ipt_password.text.toString();
            val retrofit = Retrofit.Builder()
                .baseUrl("http://localhost:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val result = retrofit.create(OpenAplication::class.java);

            val userLogin = LoginData(
                email,
                senha
            )

            val callTargetJobs = result.postUserLogin(userLogin);

            callTargetJobs.enqueue(object: Callback<Void> {

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext, "erro", Toast.LENGTH_SHORT);
                }

                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    goToAplication()
                }

            })

    }
    fun goToAplication(){
        val login = Intent(this, QuatroDX::class.java)
        startActivity(login);
    }


    fun goToRegister(component: View){
        val checkList = Intent(this, CheckList::class.java)
        startActivity(checkList);
    }
}