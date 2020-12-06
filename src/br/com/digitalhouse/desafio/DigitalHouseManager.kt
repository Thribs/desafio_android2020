package br.com.digitalhouse.desafio

class DigitalHouseManager(private val studentsList: MutableList<Student> = mutableListOf(),
                          private val coursesList: MutableList<Course> = mutableListOf(),
                          private val enrollmentsList: MutableList<Enrollment> = mutableListOf(),
                          private val instructorsList: MutableList<Instructor?> = mutableListOf()
                          ) {
    // Retorna falso se já houve um aluno com o mesmo ID na lista
    fun addStudent(studentID: Int,
                   studentName: String,
                   studentSurname: String
    ):Boolean{
        val student = Student(studentID, studentName, studentSurname)
        for (s in studentsList) if (s == student) {
            println("Aluno já existente na instituição")
            return false
        }
        println("$student cadastrado")
        studentsList.add(student)
        return true
    }
    // Retorna falso se já houver um curso com o mesmo ID na lista
    fun addCourse(
            courseID: Int,
            courseName: String,
            studentsLimit: Int
            ):Boolean{
        val course = Course(courseID, courseName, studentsLimit)
        for (c in coursesList) if (c == course) {
            println("Curso já existente na instituição")
            return false
        }
        println("$course cadastrado")
        coursesList.add(course)
        return true
    }
    fun addAuxiliaryInstructor(
            instructorID: Int,
            instructorName: String,
            instructorSurname: String,
            lecturingHours: Int,
            monitoringHours: Int): Boolean{
        for (i in instructorsList) {
            if (i == null) {
                println("Professor não encontrado")
                return false
            }
            if (i.instructorID == instructorID) {
                println("Professor já cadastrado na instituição")
                return false
            }
        }
        val instructor = AuxiliaryInstructor(
                instructorID,
                instructorName,
                instructorSurname,
                lecturingHours,
                monitoringHours)
        println("$instructor cadastrado")
        instructorsList.add(instructor)
        return true
    }
    fun addTitularInstructor(
            instructorID: Int,
            instructorName: String,
            instructorSurname: String,
            lecturingHours: Int,
            speciality: String): Boolean{
        for (i in instructorsList) {
            if (i == null) {
                println("Professor não encontrado")
                return false
            }
            if (i.instructorID == instructorID) {
                println("Professor já cadastrado")
                return false
            }
        }
        val instructor = TitularInstructor(
                instructorID,
                instructorName,
                instructorSurname,
                lecturingHours,
                speciality)
        println("$instructor cadastrado")
        instructorsList.add(instructor)
        return true
    }
    fun removeStudent(studentID: Int): Boolean{
        for (s in studentsList) if (s.studentID == studentID) {
            studentsList.remove(s)

            println("Aluno $studentID removido da instituição")
            return true
        }
        println("Aluno não encontrado")
        return false
    }
    fun removeCourse(courseID: Int): Boolean{
        for (course in coursesList) if (course.courseID == courseID){
            coursesList.remove(course)
            println("Curso $courseID removido da instituição")
            return true
        }
        println("Curso não encontrado")
        return false
    }
    fun removeInstructor(instructorID: Int): Boolean{
        for (instructor in instructorsList) if (instructor?.instructorID == instructorID) {
            instructorsList.remove(instructor)
            println("Professor $instructorID removido da instituição")
            return true
        }
        println("Professor não encontrado")
        return false
    }
    // Obs: O aviso de curso já no limite de alunos é entregue pelo método newStudent() da classe Curso
    fun enrollStudent(studentID: Int, courseID: Int, date: Date): Boolean{
        for (course in coursesList) if (course.courseID == courseID) {
            for (student in studentsList) if (student.studentID == studentID) {
                if (course.newStudent(student)) {
                    val enrollment = Enrollment(student, course, date)
                    // Retorna falso se a matrícula já existir
                    for (e in enrollmentsList) if (e == enrollment) {
                        println("O aluno ${student.name} ${student.surname} já está matriculado no curso ${course.name}")
                    }
                    enrollmentsList.add(enrollment)
                    println("Aluno $studentID - ${student.name} ${student.surname} matriculado no curso $courseID - ${course.name}")
                    return true
                }
            }
        }
        println("Curso não encontrado")
        return false
    }
    fun expelStudent(studentID: Int, courseID: Int, reason: String): Boolean {
        for (e in enrollmentsList) if (e.student.studentID == studentID && e.course.courseID == courseID) {
            enrollmentsList.remove(e)
            e.course.removeStudent(studentID)
            println("Aluno $studentID - ${e.student.name} ${e.student.surname}  removido do curso $courseID - ${e.course.name}. Motivo: $reason")
            return true
        }
        println("Matrícula não encontrada")
        return false
    }
    fun allocateInstructors(courseID: Int, auxiliaryInstructorID: Int, titularInstructorID: Int): Boolean {
        for (course in coursesList) if (course.courseID == courseID) {
            for (instructor in instructorsList) if (instructor?.instructorID == auxiliaryInstructorID) {
                course.auxiliaryInstructor = instructor as AuxiliaryInstructor
            }
            for (instructor in instructorsList) if (instructor?.instructorID == titularInstructorID) {
                course.titularInstructor = instructor as TitularInstructor
                return true
            }
        }
        return false
    }
}