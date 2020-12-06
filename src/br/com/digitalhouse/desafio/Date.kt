package br.com.digitalhouse.desafio

class Date(private val day: Int, private val month: Int, private val year: Int) {
    init {
        if (day<10) println("0$day/$month/$year")
        else println("$day/$month/$year")
    }

    override fun toString(): String {
        if (day<10) return "0$day/$month/$year"
        return "$day/$month/$year"
    }
}