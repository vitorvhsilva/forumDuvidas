package br.com.alura.forum.domain.service

import br.com.alura.forum.domain.model.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioService(var usuarios: List<Usuario> = ArrayList()) {

    init {
        val usuario = Usuario(1, "Vitor", "vitor@email.com")
        usuarios = usuarios.plus(usuario)
    }

    fun buscarPorId(id: Long): Usuario {
        return usuarios.filter {
            u -> u.id == id
        }[0]
    }

}