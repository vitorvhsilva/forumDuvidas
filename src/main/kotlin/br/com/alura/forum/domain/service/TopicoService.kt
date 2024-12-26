package br.com.alura.forum.domain.service

import br.com.alura.forum.api.dto.input.AtualizarTopicoDTO
import br.com.alura.forum.api.dto.input.CadastroTopicoDTO
import br.com.alura.forum.api.dto.output.ObterTopicoDTO
import br.com.alura.forum.api.exception.NotFoundException
import br.com.alura.forum.api.mapper.topico.CadastroTopicoMapper
import br.com.alura.forum.api.mapper.topico.ObterTopicoMapper
import br.com.alura.forum.domain.model.Topico
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val obterTopicoMapper: ObterTopicoMapper,
    private val cadastroTopicoMapper: CadastroTopicoMapper,
) {

    fun listar(): List<ObterTopicoDTO>{
        return topicos.map{
            t -> obterTopicoMapper.map(t)
        }
    }

    fun buscarPorId(id: Long): ObterTopicoDTO {
        return topicos.filter {
            t ->  t.id == id
        }.map {
            t -> obterTopicoMapper.map(t)
        }.getOrElse(0) {
            throw NotFoundException("Tópico não encontrado!")
        }
    }

    fun cadastrar(dto: CadastroTopicoDTO): ResponseEntity<Void> {
        val topico: Topico = cadastroTopicoMapper.map(dto)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)

        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    fun atualizar(dto: AtualizarTopicoDTO): ResponseEntity<ObterTopicoDTO> {
        val topico = topicos.filter {
            t -> t.id == dto.id
        }.getOrElse(0) {
            throw NotFoundException("Tópico não encontrado!")
        }

        val topicoAtualizado = Topico(
            id = dto.id,
            titulo = dto.titulo,
            mensagem = dto.mensagem,
            autor = topico.autor,
            curso = topico.curso,
            respostas = topico.respostas,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        )

        topicos = topicos.minus(topico).plus(topicoAtualizado)

        return ResponseEntity.ok(
            ObterTopicoDTO(
            id = topicoAtualizado.id,
            titulo = topicoAtualizado.titulo,
            mensagem = topicoAtualizado.mensagem,
            autor = topicoAtualizado.autor,
            curso = topicoAtualizado.curso,
            dataCriacao = topicoAtualizado.dataCriacao
        )
        )
    }

    fun deletar(id: Long): ResponseEntity<Void>{
        val topico = topicos.filter {
                t -> t.id == id
        }.getOrElse(0) {
            throw NotFoundException("Tópico não encontrado!")
        }
        topicos = topicos.minus(topico)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }

}