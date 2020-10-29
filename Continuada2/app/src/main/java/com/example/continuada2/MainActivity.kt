package com.example.continuada2

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.marginTop
import com.example.continuada2.data.Jobs
import com.example.continuada2.interfaces.ApiTargets
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //getAllTargets()
    }

    fun goTo(component: View){
        val value = Intent(this, PersonalActivity::class.java)
        startActivity(value);
    }


    fun onHandleClick(component: View) {
        val enterprise = input_one.text;
        val description = input_two.text;
        val job = input_three.text;
        val vontade: Int? = input_four.text.toString().toInt();
        name.visibility = View.VISIBLE;

        if (description.length < 3 || description.equals("")) {
            name.text = "Digite um pequena descrição, vamos lá"
            return;
        }

        if (enterprise.length < 3 || enterprise.equals("")) {
            name.text = "Nome da empresa inválida, deve conter pelo menos 3 digitos"
            return;
        }

        if (job.length < 3 || job.equals("")) {
            name.text = "Nome da area inválida, deve conter pelo menos 3 digitos"
            return;
        }

        if (vontade != null) {
            if (vontade < 0 || vontade > 100) {
                name.text = "Digite sua vontade, de 0 a 100"
                return;
            }
        }

        register();
    }



    fun register(){
        val enterprise = input_one.text;
        val description = input_two.text;
        val job = input_three.text;
        val vontade: Int? = input_four.text.toString().toInt();

        val retrofit = Retrofit.Builder()
            .baseUrl("https://5f98ae4350d84900163b7c55.mockapi.io/ap1/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val result = retrofit.create(ApiTargets::class.java);

        val newTarget = Jobs(
            null,
            enterprise.toString(),
            description.toString(),
            job.toString(),
            vontade
        )

        val callTargetJobs = result.postJobs(newTarget);

        callTargetJobs.enqueue(object: Callback<Void> {

            override fun onFailure(call: Call<Void>, t: Throwable) {
                name.text = "Não foi possivel cadastrar seu alvo";
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                name.text = "Alvo cadastrado com sucesso";
            }

        })
    }

}