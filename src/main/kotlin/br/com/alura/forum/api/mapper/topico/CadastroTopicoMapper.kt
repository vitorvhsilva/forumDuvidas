package br.com.alura.forum.api.mapper.topico

import br.com.alura.forum.api.dto.input.CadastroTopicoDTO
import br.com.alura.forum.api.mapper.Mapper
import br.com.alura.forum.domain.model.Topico
import br.com.alura.forum.domain.service.CursoService
import br.com.alura.forum.domain.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class CadastroTopicoMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService,
): Mapper<CadastroTopicoDTO, Topico> {
    override fun map(t: CadastroTopicoDTO): Topico {
        return Topico(titulo = t.titulo, mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso), autor = usuarioService.buscarPorId(t.idAutor))
    }

}