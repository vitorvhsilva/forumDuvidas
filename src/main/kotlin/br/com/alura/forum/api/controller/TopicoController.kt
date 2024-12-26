package br.com.alura.forum.api.controller

import br.com.alura.forum.api.dto.input.AtualizarTopicoDTO
import br.com.alura.forum.api.dto.input.CadastroTopicoDTO
import br.com.alura.forum.api.dto.output.ObterTopicoDTO
import br.com.alura.forum.domain.service.TopicoService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("topicos")
class TopicoController(private val topicoService: TopicoService) {

    @GetMapping
    fun listar(): List<ObterTopicoDTO> {
        return topicoService.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ObterTopicoDTO {
        return topicoService.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid dto: CadastroTopicoDTO): ResponseEntity<Void> {
        return topicoService.cadastrar(dto)
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid dto: AtualizarTopicoDTO): ResponseEntity<ObterTopicoDTO> {
        return topicoService.atualizar(dto)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long): ResponseEntity<Void>{
        return topicoService.deletar(id)
    }
}