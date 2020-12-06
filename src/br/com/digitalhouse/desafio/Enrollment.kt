package br.com.digitalhouse.desafio

class Enrollment(val student: Student, val course: Course, private val enrollmentDate: Date) {
    override fun equals(other: Any?): Boolean {
        if (other is Enrollment) {
            return student.studentID == other.student.studentID && course.courseID == other.course.courseID
        }
        return super.equals(other)
    }

    override fun toString(): String {
        return "Matrícula: ${student}; ${course}; Data de matrícula: $enrollmentDate"
    }

    // Feito pela IDE
    override fun hashCode(): Int {
        var result = student.hashCode()
        result = 31 * result + course.hashCode()
        return result
    }
}