package br.com.alura.forum.api.exception

import java.lang.RuntimeException

class NotFoundException(message: String?) : RuntimeException(message) {
}