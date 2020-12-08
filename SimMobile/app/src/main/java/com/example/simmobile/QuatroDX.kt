package com.example.simmobile

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.simmobile.models.responses.AllDxResponse
import com.example.simmobile.requests.CheckListApi
import com.example.simmobile.requests.QuatroDxAplication
import kotlinx.android.synthetic.main.activity_quatro_d_x.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuatroDX : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quatro_d_x)



        getAllDx()
    }

    private fun getAllDx() {

        var preferencias: SharedPreferences = getSharedPreferences("autenticacao", Context.MODE_PRIVATE)
        val retrofit = ClientRetrofit.criarCliente(preferencias.getString("usuario", "")!!)
        val requests = retrofit.create(QuatroDxAplication::class.java)

        val allDx = requests.getDxs();

        allDx.enqueue(object: Callback<List<AllDxResponse>> {
            override fun onResponse(
                call: Call<List<AllDxResponse>>,
                response: Response<List<AllDxResponse>>
            ) {
                if(response.isSuccessful){

                    response.body()?.forEach { dx ->

                        val newTextView = TextView(baseContext)
                        newTextView.text = "${dx.nomeDx}"
                        newTextView.setBackgroundColor(resources.getColor(R.color.colorPrimary))
                        newTextView.setTextColor(resources.getColor(R.color.colorWhite))

                        list_dx.addView(newTextView)
                    }
                }
                else{
                    Toast.makeText(applicationContext, "Não foi possível carregar os Dxs : ${response.raw().code()}. ${response.raw().message()}",
                        Toast.LENGTH_SHORT).show()
                }

            }

            override fun onFailure(call: Call<List<AllDxResponse>>, t: Throwable) {
                Toast.makeText(applicationContext, "Não foi possível carregar os Dxs $t",
                    Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun createDx(component: View) {
        val dx = Intent(this, CriarDx::class.java)
        startActivity(dx);
    }
    fun explainDx(component: View) {
        val explain = Intent(this, ExplainDx::class.java)
        startActivity(explain);
    }

    fun goToDx(component: View) {
        val goToDx = Intent(this, DX::class.java);
        startActivity(goToDx);
    }

}