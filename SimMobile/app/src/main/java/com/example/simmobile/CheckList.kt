package com.example.simmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simmobile.data.Tarefa
import com.example.simmobile.interfaces.CheckListApi
import kotlinx.android.synthetic.main.activity_checklist.*
import kotlinx.android.synthetic.main.criar_tarefa.*
import kotlinx.android.synthetic.main.criar_tarefa.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.ArrayList

class CheckList : AppCompatActivity() {

    lateinit var opcao: Spinner
    val list = ArrayList<Tarefa>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checklist)

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

        rv_tarefas.apply {
            layoutManager = LinearLayoutManager(this@CheckList)
            adapter = TarefasAdapter(tarefa)
        }

        fab_criarTarefa.setOnClickListener {



            val modalTarefa = LayoutInflater.from(this).inflate(R.layout.criar_tarefa, null)

            val buider = AlertDialog.Builder(this).setView(modalTarefa).setTitle("Crie sua tarefa")

            val modalDialog = buider.show()



            modalTarefa.bt_cria_TarefaModal.setOnClickListener {

            //criar tarefa aqui
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://23.20.3.87:8080")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                val requests = retrofit.create(CheckListApi::class.java)

                    val novaTarefa = Tarefa(
                    null,
                    et_tarefaModal.text.toString(),
                    ed_importancia.text.toString(),
                    true,
                    et_tarefaModal.text.toString()
                )

                val callCriarTarefa = requests.postTarefa(novaTarefa)

                callCriarTarefa.enqueue(object: Callback<Void> {
                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        Toast.makeText(baseContext, "Deu um problema: " +
                                "$t", Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        Toast.makeText(baseContext,
                            getString(R.string.pages_CheckListModal_txt_tarefa_cadastrada),
                            Toast.LENGTH_SHORT).show()
                    }
                })



                fun gerarList(size: Int): List<Tarefa>{



                    var tarefaModal = modalTarefa.et_tarefaModal.text.toString()
                    var importancia = modalTarefa.ed_importancia.text.toString()
                    val item = Tarefa(null,"${tarefaModal}","${importancia}",true,
                        "${tarefaModal}")
                    list += item

                    return list
                }
                val gerarTarefa = gerarList(size = 10)
                rv_tarefas.adapter = TarefasAdapter(gerarTarefa)
                rv_tarefas.layoutManager = LinearLayoutManager(this)
                rv_tarefas.setHasFixedSize(true)
                modalDialog.dismiss()

            }

            modalTarefa.bt_cancelaTarefaModal.setOnClickListener {
                modalDialog.dismiss()
            }
        }

        consumirApiTarefa()



    }

    fun consumirApiTarefa() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://23.20.3.87:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val requests = retrofit.create(CheckListApi::class.java)

        val callTarefas = requests.getTarefas()

        callTarefas.enqueue(object: Callback<List<Tarefa>> {
            override fun onFailure(call: Call<List<Tarefa>>, t: Throwable) {
                Toast.makeText(applicationContext, "Não foi possível carregar as tarefas $t",
                    Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Tarefa>>, response: Response<List<Tarefa>>) {
                ShowData(response.body()!!)
                }
        })

    }



    fun ShowData(tarefas: List<Tarefa>){
        rv_tarefas.apply {
            layoutManager = LinearLayoutManager(this@CheckList)
            adapter = TarefasAdapter(tarefas)
        }
    }



}