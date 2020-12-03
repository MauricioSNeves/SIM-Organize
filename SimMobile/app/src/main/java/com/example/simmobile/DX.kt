package com.example.simmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class DX : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d_x)
    }

    fun createTasks(view: View) {
        val createTasks =  Intent(this, CadastroMd::class.java);
        startActivity(createTasks);

    }
}