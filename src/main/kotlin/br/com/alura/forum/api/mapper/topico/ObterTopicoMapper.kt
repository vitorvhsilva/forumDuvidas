package br.com.alura.forum.api.mapper.topico

import br.com.alura.forum.api.dto.output.ObterTopicoDTO
import br.com.alura.forum.api.mapper.Mapper
import br.com.alura.forum.domain.model.Topico
import org.springframework.stereotype.Component

@Component
class ObterTopicoMapper: Mapper<Topico, ObterTopicoDTO> {
    override fun map(t: Topico): ObterTopicoDTO {
        return ObterTopicoDTO(t.id, t.titulo, t.mensagem, t.curso, t.autor, t.dataCriacao)
    }
}