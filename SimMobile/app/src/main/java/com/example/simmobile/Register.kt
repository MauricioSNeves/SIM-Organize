package com.example.simmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.simmobile.data.RegisterData
import com.example.simmobile.interfaces.OpenAplication
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.alertEmail
import kotlinx.android.synthetic.main.activity_main.alertPassword
import kotlinx.android.synthetic.main.activity_main.ipt_email
import kotlinx.android.synthetic.main.activity_main.ipt_password
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun onClick(component: View){
        val email =  ipt_email.text;
        val userName =  ipt_userName.text;
        val password =  ipt_password.text;

        if(email.length < 3 || email.equals("") ){
            alertEmail.visibility = View.VISIBLE;
            alertEmail.text = "Digite um e-mail válido"
            return;
        }else{
            alertEmail.visibility = View.GONE;
        }

        if(userName.length < 3 || userName.equals("") ){
            alertUserName.visibility = View.VISIBLE;
            alertUserName.text = "Digite um user name válido"
            return;
        }
        else{
            alertUserName.visibility = View.GONE;
        }
        if(password.length < 3 || password.equals("") ){
            alertPassword.visibility = View.VISIBLE;
            alertPassword.text = "Digite uma senha válida"
            return;
        }
        else{
            alertPassword.visibility = View.GONE;
        }


        register()
    }

    fun register(){
        val email =  ipt_email.text.toString();
        val nomeUser =  ipt_userName.text.toString();
        val senha =  ipt_password.text.toString();
        val tipoAcesso = "free"
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.0.104:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val result = retrofit.create(OpenAplication::class.java);

        val newUser = RegisterData(
            email,
            senha,
            nomeUser
        )

        val callTargetJobs = result.postUser(newUser);

/*        callTargetJobs.enqueue(object: Callback<Void> {

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(applicationContext, "erro", Toast.LENGTH_SHORT);
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                goToLogin()
            }

        })
    */

        callTargetJobs.enqueue(object : Callback<Void> {
            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(applicationContext, "erro", Toast.LENGTH_SHORT);
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                goToLogin()
            }

        })
    }

    private fun goToLogin(){
        val login = Intent(this, MainActivity::class.java)
        startActivity(login);
    }
}