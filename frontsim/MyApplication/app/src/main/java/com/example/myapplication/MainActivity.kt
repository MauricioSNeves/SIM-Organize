package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cheklist_layout.*
import kotlinx.android.synthetic.main.criar_tarefa.*
import kotlinx.android.synthetic.main.criar_tarefa.view.*
import java.util.ArrayList


class MainActivity : AppCompatActivity() {

    lateinit var opcao: Spinner
    val list = ArrayList<ItemChecklist>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



            opcao = findViewById(R.id.sp_filtroChecklist) as Spinner

            val filtrosChecklist = arrayOf("Criação","Ascendente", "Descendente", "Importância")

            opcao.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, filtrosChecklist)


            opcao.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }


            }

            fab_criarTarefa.setOnClickListener {



            val modalTarefa = LayoutInflater.from(this).inflate(R.layout.criar_tarefa, null)

            val buider = AlertDialog.Builder(this).setView(modalTarefa).setTitle("Crie sua tarefa")

            val modalDialog = buider.show()



                modalTarefa.bt_cria_TarefaModal.setOnClickListener {


                fun gerarList(size: Int): List<ItemChecklist>{

                  

                        var tarefaModal = modalTarefa.et_tarefaModal.text.toString()

                        val item = ItemChecklist("${tarefaModal}")
                        list+= item

                    return list
                }
                    val gerarTarefa = gerarList(size = 10)
                    rv_tarefas.adapter = AdapterChecklist(gerarTarefa)
                    rv_tarefas.layoutManager = LinearLayoutManager(this)
                    rv_tarefas.setHasFixedSize(true)

                modalDialog.dismiss()

            }

            modalTarefa.bt_cancelaTarefaModal.setOnClickListener {
                modalDialog.dismiss()
            }

        }

        }


}
