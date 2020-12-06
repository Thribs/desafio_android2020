package br.com.digitalhouse.desafio

class AuxiliaryInstructor(instructorID: Int,
                          name: String,
                          surname: String,
                          lecturingYears: Int,
                          private val monitoringHours: Int
                       ) : Instructor(instructorID, name, surname, lecturingYears) {
    override fun toString(): String {
        return "Professor adjunto $instructorID - $name $surname." +
                " Anos de experiência: $lecturingYears; Horas de monitoria: $monitoringHours"
    }
}