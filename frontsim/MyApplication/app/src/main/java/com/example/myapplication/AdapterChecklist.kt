package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cheklist_layout.view.*

class AdapterChecklist(private val checklistList : List<ItemChecklist>) : RecyclerView.Adapter<AdapterChecklist.HolderView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderView {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cheklist_layout,
        parent, false)
        return HolderView(itemView)
    }

    override fun onBindViewHolder(holder: HolderView, position: Int) {
        val itemCorrente = checklistList[position]

        holder.tv_nomeTarefa.text = itemCorrente.nomeTarefa

    }

    override fun getItemCount() = checklistList.size


    class HolderView(itemView: View): RecyclerView.ViewHolder(itemView){
        val tv_nomeTarefa : TextView = itemView.tv_nomeTarefa


    }

}