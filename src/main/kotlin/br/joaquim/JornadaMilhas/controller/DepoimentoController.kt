package br.joaquim.JornadaMilhas.controller

import br.joaquim.JornadaMilhas.dto.DepoimentoDto
import br.joaquim.JornadaMilhas.model.Depoimento
import br.joaquim.JornadaMilhas.service.DepoimentoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/depoimentos")
class DepoimentoController(
    private val svc: DepoimentoService
) {

    @PostMapping
    fun create(
        @RequestBody input: DepoimentoDto
    ): ResponseEntity<DepoimentoDto> {
        return ResponseEntity(svc.adicionaDepoimento(input), HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun readOne(
        @PathVariable id: Long
    ): ResponseEntity<DepoimentoDto> {
        return ResponseEntity.ok(svc.buscaUmPorId(id))
    }

    @GetMapping
    fun readAll(
        @PageableDefault(sort = ["id"], direction = Sort.Direction.ASC) pageable: Pageable
    ): ResponseEntity<Page<DepoimentoDto>> {
        return ResponseEntity.ok(svc.buscaTodos(pageable))
    }

    @PutMapping("/{id}")
    fun put(
        @PathVariable id: Long,
        @RequestBody input: DepoimentoDto
    ): ResponseEntity<DepoimentoDto> {
        return ResponseEntity.ok(svc.editaDepoimento(id, input))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(
        @PathVariable id: Long
    ) {
        svc.removeDepoimentoPorId(id)
    }

}