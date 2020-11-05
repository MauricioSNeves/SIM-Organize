package com.example.simmobile.data

data class Tarefa (
    val idTarefa: Int?,
    val nomeTarefa: String,
    val nivelImportancia: String,
    val statusTarefa: Boolean,
    val descricaoTarefa: String
)