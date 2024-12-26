package br.com.alura.forum.domain.service

import br.com.alura.forum.domain.model.Curso
import org.springframework.stereotype.Service

@Service
class CursoService(var cursos: List<Curso> = ArrayList()) {
    init {
        val curso = Curso(1, "Kotlin", "Programacao")
        cursos = cursos.plus(curso)
    }

    fun buscarPorId(id: Long): Curso {
        return cursos.filter {
            c -> c.id == id
        }[0]
    }
}