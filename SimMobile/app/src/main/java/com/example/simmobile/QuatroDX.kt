package com.example.simmobile

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.marginRight
import com.example.simmobile.models.responses.AllDxResponse
import com.example.simmobile.requests.CheckListApi
import com.example.simmobile.requests.QuatroDxAplication
import kotlinx.android.synthetic.main.activity_checklist.*
import kotlinx.android.synthetic.main.activity_quatro_d_x.*
import kotlinx.android.synthetic.main.activity_quatro_d_x.bottomNavigation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuatroDX : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quatro_d_x)

        bottomNavigation.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.checklist -> goToChecklist();
                R.id.out -> goToLogin();
                else -> Toast.makeText(
                    applicationContext, " Já está no 4dx",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


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
                        newTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)

                        newTextView.setOnClickListener {

                            goToDx(it,dx.idMetodoDx);

                        }

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

    fun goToDx(component: View, id:Int) {
        val goToDx = Intent(this, DX::class.java);

        var preferencias: SharedPreferences = getSharedPreferences("quatroDx", Context.MODE_PRIVATE)
        val editor = preferencias.edit()
        editor.putString("idDx", id.toString())
        editor.commit()

        startActivity(goToDx);
    }

    fun goToChecklist() {
        val explain = Intent(this, ExplainDx::class.java)
        startActivity(explain);
    }

    private fun goToLogin(){
        val login = Intent(this, MainActivity::class.java)
        startActivity(login);
    }

}