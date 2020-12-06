package br.com.digitalhouse.desafio

class Student(val studentID: Int, val name: String, val surname: String) {
    init {
        println("Aluno $studentID - $name $surname")
    }
    //TODO: usar uma interface para equals e contains
    fun equals(student: Student): Boolean {
        return studentID == student.studentID
    }
}