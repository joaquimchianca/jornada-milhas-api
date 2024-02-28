package br.joaquim.JornadaMilhas.dto

import br.joaquim.JornadaMilhas.model.Depoimento

data class DepoimentoDto(
    val id: Long?,
    val nome: String,
    val foto: String,
    val depoimento: String
) {
    fun mapeiaParaEntidade(): Depoimento {
        return Depoimento(id, nome, foto, depoimento)
    }
}