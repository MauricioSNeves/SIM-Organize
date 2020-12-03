package com.example.simmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class QuatroDX : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quatro_d_x)
    }

    fun createDx(view: View) {
        val dx = Intent(this, CriarDx::class.java)
        startActivity(dx);
    }
    fun explainDx(view: View) {
        val explain = Intent(this, ExplicaDx::class.java)
        startActivity(explain);
    }

    fun goToDx(view: View) {
        val goToDx = Intent(this, DX::class.java);
        startActivity(goToDx);
    }


}