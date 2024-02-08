package br.joaquim.JornadaMilhas.repository

import br.joaquim.JornadaMilhas.model.Depoimento
import org.springframework.data.jpa.repository.JpaRepository


interface DepoimentoRepository: JpaRepository<Depoimento, Long>{
}