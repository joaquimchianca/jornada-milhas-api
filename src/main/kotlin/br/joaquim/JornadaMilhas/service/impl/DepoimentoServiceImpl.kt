package br.joaquim.JornadaMilhas.service.impl

import br.joaquim.JornadaMilhas.model.Depoimento
import br.joaquim.JornadaMilhas.repository.DepoimentoRepository
import br.joaquim.JornadaMilhas.service.DepoimentoService
import org.springframework.stereotype.Service

@Service
class DepoimentoServiceImpl(
    private val repo: DepoimentoRepository
): DepoimentoService {

    override fun buscaTodos(): List<Depoimento> {
        return repo.findAll().toList()
    }

    override fun buscaUmPorId(id: Long): Depoimento {
        return repo.getReferenceById(id)
    }

    override fun adicionaDepoimento(input: Depoimento): Depoimento {
        return repo.save(input)
    }

    override fun editaDepoimento(id: Long, input: Depoimento): Depoimento {
        val depoimento = repo.getReferenceById(id)

        depoimento.atualiza(input)
        return repo.save(depoimento)
    }

    override fun removeDepoimento(id: Long) {
        repo.deleteById(id)
    }

}