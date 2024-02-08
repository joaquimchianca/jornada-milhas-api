package br.joaquim.JornadaMilhas.model

import jakarta.persistence.*

@Entity(name = "tb_depoimento")
data class Depoimento(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     val id: Long? = null,
    @Column(name = "foto")
     var foto: String = "",
    @Column(name = "nome")
     var nome: String = "",
    @Column(name = "depoimento", columnDefinition = "TEXT")
     var depoimento: String = ""
) {
    fun atualiza(input: Depoimento) {
        when {
            input.foto != "" || input.foto != null -> this.foto = input.foto
            input.depoimento != "" || input.depoimento != null ->
                this.depoimento = input.depoimento
            input.nome != "" || input.nome != null -> this.nome = input.nome
        }
    }
}