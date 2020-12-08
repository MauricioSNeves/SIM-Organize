package com.example.simmobile.models.responses

data class tarefaCheckListResponse (
    val idTarefa:Int,
    val nomeTarefa: String,
    val nivelImportancia: String,
    val statusTarefa: Boolean,
    val descricaoTarefa: String
)