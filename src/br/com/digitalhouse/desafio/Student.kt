package br.com.digitalhouse.desafio

class Student(val studentID: Int, val name: String, val surname: String) {
    override fun toString(): String {
        return "Aluno $studentID - $name $surname"
    }

    override fun equals(other: Any?): Boolean {
        if (other is Student) {
            return other.studentID == studentID
        }
        return super.equals(other)
    }

    // Feito pela IDE
    override fun hashCode(): Int {
        return studentID
    }
}