package com.example.simmobile

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.simmobile.models.RegisterData
import com.example.simmobile.requests.OpenAplication
import kotlinx.android.synthetic.main.activity_main.alertEmail
import kotlinx.android.synthetic.main.activity_main.alertPassword
import kotlinx.android.synthetic.main.activity_main.ipt_email
import kotlinx.android.synthetic.main.activity_main.ipt_password
import kotlinx.android.synthetic.main.activity_register.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


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

        val okHttpClient = OkHttpClient().newBuilder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.15.2:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        val result = retrofit.create(OpenAplication::class.java);

        val newUser = RegisterData(
            email,
            senha,
            nomeUser,
            tipoAcesso
        )

        val user = result.postUser(newUser);

        user.enqueue(object : Callback<Void> {
            override fun onFailure(call: Call<Void>, t: Throwable) {
                alertPassword.visibility = View.VISIBLE;
                alertPassword.text = "Falha: $t"

            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if(response.isSuccessful){
                    goToLogin()
                }else{
                    alertPassword.visibility = View.VISIBLE;
                    alertPassword.text = "Erro ao tentar realizar cadastro, status = ${response.raw().code()}. ${response.raw().message()}"
                }


            }
        })
    }

    private fun goToLogin(){
        val login = Intent(this, MainActivity::class.java)
        startActivity(login);
    }
}