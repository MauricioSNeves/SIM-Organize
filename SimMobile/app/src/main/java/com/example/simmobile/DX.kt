package com.example.simmobile

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.simmobile.models.CriaMdDoisData
import com.example.simmobile.models.Tarefa
import com.example.simmobile.models.responses.QuatroDxResponse
import com.example.simmobile.requests.CheckListApi
import com.example.simmobile.requests.QuatroDxAplication
import kotlinx.android.synthetic.main.activity_criar_dx.*
import kotlinx.android.synthetic.main.activity_d_x.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DX : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d_x)


        getDxInformation()
    }

    private fun getDxInformation() {

        val retrofit = Retrofit.Builder()
            .baseUrl("http://localhost:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //var preferencias: SharedPreferences = getSharedPreferences("autenticacao", Context.MODE_PRIVATE)

        ///val retrofit = ClientRetrofit.criarCliente(preferencias.getString("usuario", "")!!)

        val result = retrofit.create(QuatroDxAplication::class.java);

        val procuraTarefa = result.getDxById(getIdDx())

        procuraTarefa.enqueue(object :Callback<QuatroDxResponse>{
            override fun onFailure(call: Call<QuatroDxResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "Não foi possível carregar o Dx $t",
                    Toast.LENGTH_SHORT).show()            }

            override fun onResponse(
                call: Call<QuatroDxResponse>,
                response: Response<QuatroDxResponse>
            ) {
                if(response.isSuccessful){
                    descMCI.text = "${response.body()?.nomeMci}"
                    descMd1.text = "${response.body()?.mdUm}"
                    descMd2.text = "${response.body()?.mdDois}"

                }else{
                    Toast.makeText(applicationContext, "Erro ao tentar realizar cadastro, status = ${response.raw().code()}. ${response.raw().message()}",
                        Toast.LENGTH_LONG).show()
                }
            }
        })

    }


    private fun getIdDx(): Int {
        var preferencias: SharedPreferences = getSharedPreferences("quatroDx", Context.MODE_PRIVATE)

        val idDx = ClientRetrofit.criarCliente(preferencias.getString("idDx", "")!!).toString().toInt();

        return idDx;
    }

    fun createTasks(view: View) {
        val createTasks =  Intent(this, CadastroMdTasks::class.java);
        startActivity(createTasks);

    }

}