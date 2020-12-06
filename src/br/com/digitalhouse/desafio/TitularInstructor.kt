package br.com.digitalhouse.desafio

class TitularInstructor(instructorID: Int,
                        name: String,
                        surname: String,
                        lecturingYears: Int,
                        val speciality: String
                        ) : Instructor(instructorID, name, surname, lecturingYears) {
    init {
        println("Professor titular $instructorID - $name $surname." +
                " Anos de experiência: $lecturingYears; Especialidade: $speciality")
    }
}