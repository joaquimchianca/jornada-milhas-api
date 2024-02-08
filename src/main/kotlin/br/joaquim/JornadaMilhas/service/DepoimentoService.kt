package br.joaquim.JornadaMilhas.service

import br.joaquim.JornadaMilhas.model.Depoimento

interface DepoimentoService {
    fun buscaTodos(): List<Depoimento>

    fun buscaUmPorId(id: Long): Depoimento

    fun adicionaDepoimento(input: Depoimento): Depoimento

    fun editaDepoimento(id: Long, input: Depoimento): Depoimento

    fun removeDepoimento(id: Long)
}