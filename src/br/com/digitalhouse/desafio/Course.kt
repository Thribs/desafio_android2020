package br.com.digitalhouse.desafio

class Course(val courseID: Int,
             val name: String,
             val studentsLimit: Int,
             val studentsList: MutableList<Student> = mutableListOf<Student>(),
             var titularInstructor: TitularInstructor? = null,
             var auxiliaryInstructor: AuxiliaryInstructor? = null) {
    fun equals(course: Course): Boolean{
        return courseID == course.courseID
    }
    fun contains(studentID: Int): Boolean{
        for (student in studentsList) if (studentID == student.studentID) return true
        return false
    }
    // Retorna nulo se não encontrar um aluno na lista
    fun searchStudent(studentID: Int): Student?{
        for (student in studentsList) {
            if (contains(studentID)) return student
        }
        return null
    }
    // Retorna falso se a lista de alunos estiver "cheia"
    fun newStudent(student: Student): Boolean{
        if (studentsList.size >= studentsLimit) return false
        studentsList.add(student)
        return true
    }
    // Retorna falso se não encontrado estudante com o código informado-
    fun removeStudent(studentID: Int): Boolean{
        val student = searchStudent(studentID)
        studentsList.remove(student)
        return student != null
    }
}