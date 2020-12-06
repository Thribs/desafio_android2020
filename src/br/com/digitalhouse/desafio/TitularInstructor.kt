package br.com.digitalhouse.desafio

class TitularInstructor(instructorID: Int,
                        name: String,
                        surname: String,
                        lecturingYears: Int,
                        private val speciality: String
                        ) : Instructor(instructorID, name, surname, lecturingYears) {
    override fun toString(): String {
        return "Professor titular $instructorID - $name $surname." +
                " Anos de experiência: $lecturingYears; Especialidade: $speciality"
    }
}