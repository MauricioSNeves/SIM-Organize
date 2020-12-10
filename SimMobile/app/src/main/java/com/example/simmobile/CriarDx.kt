package com.example.simmobile

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.simmobile.models.CriaMdDoisData
import com.example.simmobile.models.CriaMdUmData

import com.example.simmobile.models.DxData
import com.example.simmobile.models.responses.QuatroDxResponse
import com.example.simmobile.requests.QuatroDxAplication

import kotlinx.android.synthetic.main.activity_criar_dx.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CriarDx : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_dx)
    }


    fun onClick(component: View){
        val nome =  input_one.text.toString();
        val mci =  input_two.text.toString();
        val data =  input_two.toString();
        val mdUm =  input_one.text.toString();
        val mdDois =  input_two.text.toString();


        if(nome.length < 3 || nome.equals("") ){
            return;
        }

        if(mci.length < 3 || mci.equals("") ){
            return;
        }
        if(mdDois.length < 3 || mdDois.equals("") ){
            return;
        }

        if(mdUm.length < 3 || mdUm.equals("") ){
            return;
        }

       registerDx()
    }

    fun registerDx(){
        val nomeDx =  input_one.text.toString();
        val nomeMci =  input_two.text.toString();
        val data =  input_two.text.toString();

        val result = resultBuildRetrofit()

        val newDx = DxData(
            nomeDx,
            nomeMci,
            data
        )

        val callTargetJobs = result.postDx(newDx);

        callTargetJobs.enqueue(object: Callback<QuatroDxResponse> {

            override fun onFailure(call: Call<QuatroDxResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "erro", Toast.LENGTH_SHORT);
            }

            override fun onResponse(call: Call<QuatroDxResponse>, response: Response<QuatroDxResponse>) {
                registerMds(response.body()?.idMetodoDx)
            }

        })
    }



    fun registerMds(id: Int?){
        val mdUm =  input_one.text.toString();

        val newMd = CriaMdUmData(
            mdUm
        )

        val result = resultBuildRetrofit()

        val callTargetJobs = result.postMdUm(id,newMd);


        callTargetJobs.enqueue(object: Callback<Void> {

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(applicationContext, "erro: $t ", Toast.LENGTH_SHORT).show();
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                registerMdDois(id)
            }

        })

    }

    private fun backToPage(){
        val back = Intent(this, QuatroDX::class.java)
        startActivity(back);
    }

    private fun registerMdDois(id: Int?){

        val mdDois =  input_two.text.toString();

        val result = resultBuildRetrofit()

        val newMdDois = CriaMdDoisData(
            mdDois
        )

        val callTargetJobs = result.postMdDois(id,newMdDois);

        callTargetJobs.enqueue(object: Callback<Void> {

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