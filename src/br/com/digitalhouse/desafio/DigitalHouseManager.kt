package br.com.digitalhouse.desafio

class DigitalHouseManager(private val studentsList: MutableList<Student> = mutableListOf(),
                          private val coursesList: MutableList<Course> = mutableListOf(),
                          private val enrollmentsList: MutableList<Enrollment> = mutableListOf(),
                          private val instructorsList: MutableList<Instructor?> = mutableListOf()
                          ) {
    private fun containsStudent(studentID: Int): Boolean {
        for (student in studentsList) if (studentID == student.studentID) return true
        return false
    }
    private fun containsCourse(courseID: Int): Boolean {
        for (course in coursesList) if (courseID == course.courseID) return true
        return false
    }
    private fun containsInstructor(instructorID: Int): Boolean {
        for (instructor in instructorsList) if (instructorID == instructor?.instructorID) return true
        return false
    }
    fun containsEnrollment(otherEnrollment: Enrollment): Boolean {
        for (enrollment in enrollmentsList) if (otherEnrollment == enrollment) return true
        return false
    }
    // Retorna falso se já houve um aluno com o mesmo ID na lista
    fun addStudent(studentID: Int,
                   studentName: String,
                   studentSurname: String
    ):Boolean{
        val student = Student(studentID, studentName, studentSurname)
        if (containsStudent(studentID)) return false
        studentsList.add(student)
        return true
    }
    // Retorna falso se já houver um curso com o mesmo ID na lista
    fun addCourse(
            courseID: Int,
            courseName: String,
            studentsLimit: Int
            ):Boolean{
        if (containsCourse(courseID)) return false
        val course = Course(courseID, courseName, studentsLimit)
        coursesList.add(course)
        return true
    }
    fun addAuxiliaryInstructor(
            instructorID: Int,
            instructorName: String,
            instructorSurname: String,
            lecturingHours: Int,
            monitoringHours: Int): Boolean{
        if (containsInstructor(instructorID)) return false
        val instructor = AuxiliaryInstructor(
                instructorID,
                instructorName,
                instructorSurname,
                lecturingHours,
                monitoringHours)
        instructorsList.add(instructor)
        return true
    }
    fun addTitularInstructor(
            instructorID: Int,
            instructorName: String,
            instructorSurname: String,
            lecturingHours: Int,
            speciality: String): Boolean{
        if (containsInstructor(instructorID)) return false
        val instructor = TitularInstructor(
                instructorID,
                instructorName,
                instructorSurname,
                lecturingHours,
                speciality)
        instructorsList.add(instructor)
        return true
    }
    fun removeStudent(studentID: Int): Boolean{
        for (student in studentsList) if (student.studentID == studentID) {
                studentsList.remove(student)
                return true
            }

        return false
    }
    fun removeCourse(courseID: Int): Boolean{
        for (course in coursesList) if (course.courseID == courseID){
            coursesList.remove(course)
            return true
        }
        return false
    }
    fun removeInstructor(instructorID: Int): Boolean{
        for (instructor in instructorsList) if (instructor?.instructorID == instructorID) {
            instructorsList.remove(instructor)
            return true
        }
        return false
    }
    fun enrollStudent(studentID: Int, courseID: Int): Boolean{
        for (course in coursesList) if (course.courseID == courseID) {
            for (student in studentsList) if (student.studentID == studentID) {
                course.newStudent(student)
                return true
            }
        }
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