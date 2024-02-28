package br.joaquim.JornadaMilhas.service

import br.joaquim.JornadaMilhas.dto.DepoimentoDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface DepoimentoService {
    fun buscaTodos(pageable: Pageable): Page<DepoimentoDto>

    fun buscaUmPorId(id: Long): DepoimentoDto

    fun adicionaDepoimento(input: DepoimentoDto): DepoimentoDto

    fun editaDepoimento(id: Long, input: DepoimentoDto): DepoimentoDto

    fun removeDepoimentoPorId(id: Long)

    fun removeDepoimento(input: DepoimentoDto)

}