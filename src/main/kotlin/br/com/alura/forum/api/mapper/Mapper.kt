package br.com.alura.forum.api.mapper

interface Mapper<T, U> {
    fun map(t: T): U
}