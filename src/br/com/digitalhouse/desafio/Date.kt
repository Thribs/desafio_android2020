package br.com.digitalhouse.desafio

class Date(val day: Int, val month: Int, val year: Int) {
    init {
        if (day<10) println("0$day/$month/$year")
        else println("$day/$month/$year")
    }
}