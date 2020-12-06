package br.com.digitalhouse.desafio

fun main() {
    val manager = DigitalHouseManager()

    manager.addCourse(20001, "Full Stack", 3)
    manager.addCourse(20002, "Android", 2)
    manager.addAuxiliaryInstructor(1001, "Mayk", "Brito", 1, 0)
    manager.addTitularInstructor(2001, "Diego", "Fernandes", 4, "Web")
    manager.addAuxiliaryInstructor(1002, "João", "Camargo", 2, 0)
    manager.addTitularInstructor(2002, "José", "Santos", 4, "Java")
    val dateToday = Date(6, 12, 2020)

    manager.addStudent(1001, "Thiago", "Ribeiro Silva")
    manager.addStudent(1002, "Daniele", "Nazaré Tavares")
    manager.addStudent(1003, "Monique", "Azevedo")
    manager.addStudent(1004, "Gabriel", "Ramos")

    manager.allocateInstructors(20001, 1001, 2001)
    manager.allocateInstructors(20002, 1002, 2002)

    // Alunos Full Stack
    manager.enrollStudent(1001, 20001, dateToday)
    manager.enrollStudent(1002, 20001, dateToday)
    // Alunos Android
    manager.enrollStudent(1001, 20002, dateToday)
    manager.enrollStudent(1003, 20002, dateToday)
    manager.enrollStudent(1004, 20002, dateToday)
    manager.expelStudent(1001, 20002, "Abir espaço")
    manager.enrollStudent(1004, 20002, dateToday)

    println("----------Testes----------")
    manager.addTitularInstructor(1, "Teste", "", 0, "" )
    manager.addAuxiliaryInstructor(0, "Teste", "", 0, 0)
    manager.addAuxiliaryInstructor(0, "Teste", "", 0, 0)
    manager.addStudent(0, "Teste", "")
    manager.addStudent(0, "Teste", "")
    manager.addCourse(0,"Teste", 10)
    manager.addCourse(0,"Teste", 10)
    manager.enrollStudent(0, 0, dateToday)
    manager.enrollStudent(0, 0, dateToday)
    manager.allocateInstructors(0,0,1)
    manager.removeInstructor(0)
    manager.removeStudent(0)
    manager.removeCourse(0)
    manager.removeInstructor(0)
    manager.removeStudent(0)
    manager.removeCourse(0)

    println(manager)





}