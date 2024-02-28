package br.joaquim.JornadaMilhas.service.impl

import br.joaquim.JornadaMilhas.dto.DepoimentoDto
import br.joaquim.JornadaMilhas.repository.DepoimentoRepository
import br.joaquim.JornadaMilhas.service.DepoimentoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class DepoimentoServiceImpl(
    private val repo: DepoimentoRepository
): DepoimentoService {

    override fun buscaTodos(pageable: Pageable): Page<DepoimentoDto> {
        val depoimentos = repo.findAll(pageable)

        // VALIDAR RESPOSTA DO REPOSITORY

        val depoimentosDto = depoimentos.map {
            depoimento -> depoimento.mapeiaParaDto()
        }

        return depoimentosDto
    }

    override fun buscaUmPorId(id: Long): DepoimentoDto {
        val depoimento = repo.getReferenceById(id)
        return depoimento.mapeiaParaDto()
    }

    override fun adicionaDepoimento(input: DepoimentoDto): DepoimentoDto {
        val depoimento = input.mapeiaParaEntidade()
        val novoDepoimento = repo.save(depoimento)
        return novoDepoimento.mapeiaParaDto()
    }

    override fun editaDepoimento(id: Long, input: DepoimentoDto): DepoimentoDto {
        val depoimento = repo.getReferenceById(id)
        depoimento.atualiza(input)
        return repo.save(depoimento).mapeiaParaDto()
    }

    override fun removeDepoimentoPorId(id: Long) {
        repo.deleteById(id)
    }

    override fun removeDepoimento(input: DepoimentoDto) {
        repo.delete(input.mapeiaParaEntidade())
    }

}