package com.example.simmobile

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simmobile.models.Tarefa
import com.example.simmobile.requests.CheckListApi
import kotlinx.android.synthetic.main.activity_checklist.*
import kotlinx.android.synthetic.main.criar_tarefa.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CheckList  : AppCompatActivity() {

    lateinit var opcao: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checklist)


        bottomNavigation.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.main -> goToMain();
                R.id.out -> goToLogin();
                else -> Toast.makeText(applicationContext, " Já está na Checklist",
                    Toast.LENGTH_SHORT).show()
            }
        }



        var preferencias: SharedPreferences = getSharedPreferences("autenticacao", Context.MODE_PRIVATE)
        val retrofit = ClientRetrofit.criarCliente(preferencias.getString("usuario", "")!!)
        val requests = retrofit.create(CheckListApi::class.java)
        val procuraTarefa = requests.listarTarefas()
        procuraTarefa.enqueue(object: Callback<List<Tarefa>> {
            override fun onFailure(call: Call<List<Tarefa>>, t: Throwable) {
                Toast.makeText(applicationContext, "Não foi possível carregar as tarefas $t",
                    Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<List<Tarefa>>, response: Response<List<Tarefa>>) {
                if (response.isSuccessful) {
                    ShowData(response.body()!!)
                } else {
                    Toast.makeText(this@CheckList, "erro", Toast.LENGTH_SHORT).show()
                }
            }
        })

        opcao = findViewById(R.id.sp_filtroChecklist) as Spinner

                val filtrosChecklist = arrayOf("Nenhum","Ascendente", "Descendente", "Importância")

                opcao.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                    filtrosChecklist)


                opcao.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int,
                                                id: Long) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }


        }

        var tarefa = mutableListOf<Tarefa>()

        fab_criarTarefa.setOnClickListener {



            val modalTarefa = LayoutInflater.from(this).inflate(R.layout.criar_tarefa, null)

            val buider = AlertDialog.Builder(this).setView(modalTarefa).setTitle("Crie sua tarefa")

            val modalDialog = buider.show()

            var preferencias: SharedPreferences = getSharedPreferences("autenticacao", Context.MODE_PRIVATE)

            val retrofit = ClientRetrofit.criarCliente(preferencias.getString("usuario", "")!!)
            modalTarefa.bt_criaTarefaModal.setOnClickListener {
                val nomeTarefa =  "geovanna"  //et_tarefaModal.text.toString()
                val nivelImportancia = "Alta"  //ed_importancia.text.toString()
                val statusTarefa = false;
                val descricaoTarefa ="teste"   //et_tarefaModal.text.toString()




                val requests = retrofit.create(CheckListApi::class.java)



                val novaTarefa = Tarefa(
                    nomeTarefa,
                    nivelImportancia,
                    statusTarefa,
                    descricaoTarefa
                )

                val callCriarTarefa = requests.cadastrarTarefas(novaTarefa)

               callCriarTarefa.enqueue(object: Callback<Void> {
                    override fun onFailure(call: Call<Void>?, t: Throwable?) {
                        Toast.makeText(baseContext, "Deu um problema: " +
                                "$t", Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                        if (response?.isSuccessful!!) {
                            Toast.makeText(this@CheckList, "cadastrado", Toast.LENGTH_SHORT).show()
                            modalDialog.dismiss()
                        } else {
                            Toast.makeText(this@CheckList, "erro", Toast.LENGTH_SHORT).show()
                            val a= "test"
                            modalDialog.dismiss()
                        }
                    }
                })

            }


            modalTarefa.bt_cancelaTarefaModal.setOnClickListener {
                modalDialog.dismiss()
            }
        }

    }

    private fun goToMain() {
        TODO("Not yet implemented")
    }


    fun ShowData(tarefas: List<Tarefa>){
        rv_tarefas.apply {
            layoutManager = LinearLayoutManager(this@CheckList)
            adapter = TarefaAdapter(tarefas)
        }
    }


    private fun goToLogin(){
        val login = Intent(this, MainActivity::class.java)
        startActivity(login);
    }


}