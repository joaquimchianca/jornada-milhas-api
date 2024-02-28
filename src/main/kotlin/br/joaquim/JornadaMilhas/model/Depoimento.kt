package br.joaquim.JornadaMilhas.model

import br.joaquim.JornadaMilhas.dto.DepoimentoDto
import jakarta.persistence.*

@Entity(name = "tb_depoimento")
data class Depoimento(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null,
    @Column(name = "nome")
    private var nome: String = "",
    @Column(name = "foto")
    private var foto: String = "",
    @Column(name = "depoimento", columnDefinition = "TEXT")
    private var depoimento: String = ""
) {
    fun atualiza(input: DepoimentoDto) {
        when {
            input.foto != "" && input.foto != null -> foto = input.foto
            input.depoimento != "" && input.depoimento != null -> depoimento = input.depoimento
            input.nome != "" && input.nome != null -> nome = input.nome
        }
    }

    fun mapeiaParaDto(): DepoimentoDto {
        return DepoimentoDto(id, nome, foto, depoimento)
    }
}