package br.joaquim.JornadaMilhas.controller

import br.joaquim.JornadaMilhas.model.Depoimento
import br.joaquim.JornadaMilhas.service.DepoimentoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/depoimentos")
class DepoimentoController(
    private val svc: DepoimentoService
) {

    @PostMapping
    fun create(
        @RequestBody input: Depoimento
    ): ResponseEntity<Depoimento> {
        return ResponseEntity<Depoimento>(svc.adicionaDepoimento(input), HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun readOne(
        @PathVariable id: Long
    ): ResponseEntity<Depoimento> {
        return ResponseEntity.ok(svc.buscaUmPorId(id))
    }

    @GetMapping
    fun readAll(): ResponseEntity<List<Depoimento>> {
        return ResponseEntity.ok(svc.buscaTodos())
    }

}