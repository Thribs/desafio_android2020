package br.com.digitalhouse.desafio

class Course(val courseID: Int,
             val name: String,
             private val studentsLimit: Int) {
    private val studentsList: MutableList<Student> = mutableListOf()
    var titularInstructor: TitularInstructor? = null
    var auxiliaryInstructor: AuxiliaryInstructor? = null
    override fun toString(): String{
        return "Curso $courseID - $name. Limite de alunos: $studentsLimit"
    }
    override fun equals(other: Any?): Boolean {
        if (other is Course) return other.courseID == courseID
        return super.equals(other)
    }
    fun contains(studentID: Int): Boolean{
        for (student in studentsList) if (studentID == student.studentID) return true
        return false
    }
    // Retorna nulo se não encontrar um aluno na lista
    private fun searchStudent(studentID: Int): Student?{
        for (student in studentsList) {
            if (contains(studentID)) return student
        }
        return null
    }
    // Retorna falso se a lista de alunos estiver "cheia"
    fun newStudent(student: Student): Boolean{
        if (studentsList.size >= studentsLimit) {
            println("O curso já está no limite de alunos")
            return false
        }
        if (studentsList.contains(student)) {
            println("Esse aluno já está matriculado nesse curso")
            return false
        }
        studentsList.add(student)
        return true
    }
    // Retorna falso se não encontrado estudante com o código informado
    fun removeStudent(studentID: Int): Boolean{
        val student = searchStudent(studentID)
        studentsList.remove(student)
        return student != null
    }

    // Feito pela IDE
    override fun hashCode(): Int {
        return courseID
    }
}