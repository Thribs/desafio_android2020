package br.com.digitalhouse.desafio

class AuxiliaryInstructor(instructorID: Int,
                          name: String,
                          surname: String,
                          lecturingYears: Int,
                          val monitoringHours: Int
                       ) : Instructor(instructorID, name, surname, lecturingYears) {
    init {
        println("Professor adjunto $instructorID - $name $surname." +
                " Anos de experiência: $lecturingYears; Horas de monitoria: $monitoringHours")
    }
}