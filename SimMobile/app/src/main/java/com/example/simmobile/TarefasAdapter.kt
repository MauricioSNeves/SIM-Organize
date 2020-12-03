package com.example.simmobile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.RelativeLayout
import android.widget.TextView/*
<<<<<<< HEAD
import androidx.recyclerview.widget.RecyclerView
import com.example.simmobile.models.Tarefa
=======
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.simmobile.data.Tarefa
import kotlinx.android.synthetic.main.criar_tarefa.view.*
import kotlinx.android.synthetic.main.editar_tarefa.view.*
>>>>>>> 54775ae73f45a5fbda0dc785b1397c1127f717dd
import kotlinx.android.synthetic.main.tarefa_layout.view.*

class TarefasAdapter(val tarefas: List<Tarefa>) :
    RecyclerView.Adapter<TarefasAdapter.HolderView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderView {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.tarefa_layout,
            parent, false)
        return HolderView(itemView)
    }

    override fun onBindViewHolder(holder: HolderView, position: Int) {
        val itemCorrente = tarefas[position]
        if (itemCorrente.nivelImportancia == "Alta"){
            holder.rl_tarefa.setBackgroundResource(R.color.colorRed)
<<<<<<< HEAD
        }else if (itemCorrente.nivelImportancia == "Média"){
            holder.rl_tarefa.setBackgroundResource(R.color.colorYellow)
        }else{
            holder.rl_tarefa.setBackgroundResource(R.color.colorGreen)
        }



        holder.tv_nomeTarefa.text = itemCorrente.nomeTarefa
/*
       holder.ib_editar.setOnClickListener{
           val editarTarefa = LayoutInflater.from().inflate(R.layout.editar_tarefa, null)


           val buider = AlertDialog.Builder().setView(editarTarefa).setTitle("Crie sua tarefa")

           val modalDialog = buider.show()



           editarTarefa.bt_cria_TarefaModal.setOnClickListener {

               modalDialog.dismiss()

           }

           editarTarefa.bt_cancelaTarefaModal.setOnClickListener {
               modalDialog.dismiss()
           }
       }
*/

=======
            holder.ib_editar.setBackgroundResource(R.color.colorRed)
            holder.ib_concluir.setBackgroundResource(R.color.colorRed)
            holder.ib_excluir.setBackgroundResource(R.color.colorRed)
        }else if (itemCorrente.nivelImportancia == "Média"){
            holder.rl_tarefa.setBackgroundResource(R.color.colorYellow)
            holder.ib_editar.setBackgroundResource(R.color.colorYellow)
            holder.ib_concluir.setBackgroundResource(R.color.colorYellow)
            holder.ib_excluir.setBackgroundResource(R.color.colorYellow)
        }else{
            holder.rl_tarefa.setBackgroundResource(R.color.colorGreen)
            holder.ib_editar.setBackgroundResource(R.color.colorGreen)
            holder.ib_concluir.setBackgroundResource(R.color.colorGreen)
            holder.ib_excluir.setBackgroundResource(R.color.colorGreen)
        }
        holder.tv_nomeTarefa.text = itemCorrente.nomeTarefa


        holder.ib_editar.setOnClickListener{

            val context = holder.ib_editar.context;
            val editarTarefa = LayoutInflater.from(context).inflate(R.layout.editar_tarefa, null)


            val buider = AlertDialog.Builder(context).setView(editarTarefa).setTitle("Edite sua tarefa")

            val modalDialog = buider.show()



            editarTarefa.bt_edit_TarefaModal.setOnClickListener() {

                modalDialog.dismiss()

            }

            editarTarefa.bt_cancela_edit_TarefaModal.setOnClickListener() {
                modalDialog.dismiss()
            }
        }
>>>>>>> 54775ae73f45a5fbda0dc785b1397c1127f717dd

    }

    override fun getItemCount() = tarefas.size


    class HolderView(itemView: View): RecyclerView.ViewHolder(itemView){
        val tv_nomeTarefa : TextView = itemView.tv_nomeTarefa
        val rl_tarefa : RelativeLayout = itemView.rl_tarefa
        val ib_concluir : ImageButton = itemView.ib_concluir
        val ib_editar : ImageButton = itemView.ib_editar
        val ib_excluir : ImageButton = itemView.ib_excluir
    }


}
*/
