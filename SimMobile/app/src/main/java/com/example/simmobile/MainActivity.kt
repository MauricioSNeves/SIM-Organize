package com.example.simmobile

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

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



    }

    fun goToRegister(component: View){
        val register = Intent(this, Register::class.java)
        startActivity(register);
    }
}