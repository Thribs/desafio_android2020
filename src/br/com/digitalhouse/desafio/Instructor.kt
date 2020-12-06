package br.com.digitalhouse.desafio

abstract class Instructor(val instructorID: Int,
                      val name: String,
                      val surname: String,
                      val lecturingYears: Int) {
    override fun equals(other: Any?): Boolean {
        if (other is Instructor) {
            return other.instructorID == instructorID
        }
        return super.equals(other)
    }
    // Feito pela IDE
    override fun hashCode(): Int {
        return instructorID
    }
}
