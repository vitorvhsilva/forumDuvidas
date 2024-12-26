package br.com.alura.forum.domain.model

import java.time.LocalDateTime
import java.util.ArrayList

data class Topico(
    var id: Long? = null,
    val titulo: String,
    val mensagem: String,
    val curso: Curso,
    val autor: Usuario,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
    val respostas: List<Resposta> = ArrayList()
)