package br.com.digitalhouse.desafio

class AuxiliaryInstructor(instructorID: Int,
                          name: String,
                          surname: String,
                          lecturingYears: Int,
                          val monitoringHours: Int
                       ): Instructor(instructorID, name, surname, lecturingYears)