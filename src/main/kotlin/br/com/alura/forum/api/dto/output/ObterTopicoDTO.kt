package br.com.alura.forum.api.dto.output

import br.com.alura.forum.domain.model.Curso
import br.com.alura.forum.domain.model.Usuario
import java.time.LocalDateTime

data class ObterTopicoDTO(
    val id: Long?,
    val titulo: String,
    val mensagem: String,
    val curso: Curso,
    val autor: Usuario,
    val dataCriacao: LocalDateTime = LocalDateTime.now()
)
