package com.example.continuada2

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.continuada2.data.Jobs
import com.example.continuada2.interfaces.ApiTargets
import kotlinx.android.synthetic.main.activity_personal.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PersonalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal)
        getAllTargets()

    }

    fun goTo(component: View){
        val value = Intent(this, MainActivity::class.java)
        startActivity(value);
    }

     fun getAllTargets(){
       val retrofit = Retrofit.Builder()
           .baseUrl("https://5f98ae4350d84900163b7c55.mockapi.io/ap1/v1/")
           .addConverterFactory(GsonConverterFactory.create())
           .build()

       val result = retrofit.create(ApiTargets::class.java);

       val targetsJobs = result.getJobs();

       targetsJobs.enqueue(object: Callback<List<Jobs>> {
           override fun onFailure(call: Call<List<Jobs>>, t: Throwable) {
               Toast.makeText(applicationContext, "Não foi possivel carregar os seus alvos", Toast.LENGTH_SHORT);
           }

           override fun onResponse(call: Call<List<Jobs>>, response: Response<List<Jobs>>) {
               response.body()?.forEach{
                   val target = TextView(baseContext);

                   target.text = ("A ${it.enterprise} é onde quero trabalhar." +
                           "${it.description} " +
                           "A area que quero atuar é : ${it.job}" +
                           "a minha vontade é de: ${it.vontade}"
                           ).trimIndent()
                   target.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15f)
                   target.setTextColor(Color.parseColor("#090908"))
                   conteudo.addView(target)
               }
           }

       })
   }


}