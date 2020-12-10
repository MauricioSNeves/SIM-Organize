package com.example.simmobile

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.simmobile.models.*
import com.example.simmobile.requests.QuatroDxAplication
import kotlinx.android.synthetic.main.activity_criar_dx.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CadastroMdTasks : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_md)
    }

    private fun backToPage(){
        val back = Intent(this, DX::class.java)
        startActivity(back);
    }

    private fun getIdDx(): Int {
        var preferencias: SharedPreferences = getSharedPreferences("quatroDx", Context.MODE_PRIVATE)

        val idDx = ClientRetrofit.criarCliente(preferencias.getString("idDx", "")!!)

        val value = idDx.toString()

        return value.toInt();
    }

    private fun getIdMdUm(): Int {
        var preferencias: SharedPreferences = getSharedPreferences("quatroDx", Context.MODE_PRIVATE)

        val mdDois = ClientRetrofit.criarCliente(preferencias.getString("idMdUm", "")!!)

        val value = mdDois.toString()

        return value.toInt();
    }

    private fun getIdMdDois(): Int {
        var preferencias: SharedPreferences = getSharedPreferences("quatroDx", Context.MODE_PRIVATE)

        val mdDois = ClientRetrofit.criarCliente(preferencias.getString("idMdDois", "")!!)

        val value = mdDois.toString()

        return value.toInt();
    }


    private fun createTaskMdUm(Component : View){
        val nomeTarefaMdUm =  input_one.text.toString();

        val result = resultBuildRetrofit()

        val newTaskUm = CriaMdUmTask(
            nomeTarefaMdUm
        )

        val mdUmCall = result.postTasksMdUm(getIdDx(), getIdMdUm(),newTaskUm );

        mdUmCall.enqueue(object: Callback<Void> {

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(applicationContext, "erro: $t ", Toast.LENGTH_SHORT).show();
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                registerTaskMdDois(getIdDx())
            }

        })
    }


    private fun registerTaskMdDois(id: Int?){

        val nomeTarefaMdDois =  input_two.text.toString();

        val result = resultBuildRetrofit()

        val newTaskDois = CriaMdDoisTasks(
            nomeTarefaMdDois
        )

        val mdDoisCall = result.postTasksMdDois(id,getIdMdDois(),newTaskDois);

        mdDoisCall.enqueue(object: Callback<Void> {

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(applicationContext, "erro: $t ", Toast.LENGTH_SHORT).show();
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                backToPage()
            }

        })
    }


    fun resultBuildRetrofit(): QuatroDxAplication {

        val retrofit = Retrofit.Builder()
            .baseUrl("http://localhost:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //var preferencias: SharedPreferences = getSharedPreferences("autenticacao", Context.MODE_PRIVATE)

        ///val retrofit = ClientRetrofit.criarCliente(preferencias.getString("usuario", "")!!)

        val result = retrofit.create(QuatroDxAplication::class.java);

        return result

    }







}