package Model

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

class StudentTest {
    companion object {
        val creditlessSubject = Subject(0, "English 101", 0)
        val bigSubject = Subject(1, "Discrete Maths", 5)
        val smallSubject = Subject(2, "Writing", 3)
        val studentName = "Pitel"
        val studentLastName = "Pitelson"
        val studentAge = 19
        val studentCareer = "Medicine"
    }

    @Test
    fun inscribeSubject() {
        val sut = Student(studentName, studentLastName, studentAge, studentCareer, 7)
        assertDoesNotThrow {
            sut.inscribeSubject(creditlessSubject)
        }
    }
}