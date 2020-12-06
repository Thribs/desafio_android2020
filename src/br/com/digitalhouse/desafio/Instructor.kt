package br.com.digitalhouse.desafio

abstract class Instructor(val instructorID: Int,
                      val name: String,
                      val surname: String,
                      val lecturingYears: Int) {
    fun equals(instructor: Instructor): Boolean{
        return instructorID == instructor.instructorID
    }
}
