package com.example.simmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CadastroMd : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_md)
    }

    private fun backToPage(Component : View){
        val back = Intent(this, QuatroDX::class.java)
        startActivity(back);
    }
}