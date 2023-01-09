package Model

import Exceptions.ExceedingMaxCreditsException
import Exceptions.ExceedingMaxSubjectsException
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StudentTest {
    companion object {
        val creditlessSubject = Subject(0, "English 101", 0)
        val bigSubject = Subject(1, "Discrete Maths", 5)
        val smallSubject = Subject(2, "Writing", 3)
        val randomSubject = Subject(2, "Science 101", 2)
        val otherSubject = Subject(2, "Maths 102", 4)
        val anotherSubject = Subject(2, "Programming Lab 101", 1)
        val studentName = "Pitel"
        val studentLastName = "Pitelson"
        val studentAge = 19
        val studentCareer = "Medicine"
        val maxCredits = 7

        fun generateSut(): Student {
            return Student(studentName, studentLastName, studentAge, studentCareer, maxCredits)
        }
    }

    @Test
    fun inscribeSubject() {
        val sut = generateSut()
        assertDoesNotThrow {
            sut.inscribeSubject(creditlessSubject)
        }
        assert(sut.currentCredits == 0)
        assert(sut.remainingCredits == maxCredits)
    }

    @Test
    fun inscribeSubjectEnoughCredits() {
        val sut = generateSut()
        assertDoesNotThrow {
            sut.inscribeSubject(bigSubject)
        }
        assert(sut.currentCredits == bigSubject.credits)
        assert(sut.remainingCredits == maxCredits - bigSubject.credits )
    }

    @Test
    fun inscribeSubjectNotEnoughCredits() {
        val sut = generateSut()
        assertDoesNotThrow{
            sut.inscribeSubject(bigSubject)
        }
        assertThrows<ExceedingMaxCreditsException> {
            sut.inscribeSubject(smallSubject)
        }
        assert(sut.currentCredits == bigSubject.credits)
        assert(sut.remainingCredits == maxCredits - bigSubject.credits )
    }
    @Test
    fun inscribeMoreThanFourSubjects() {
        val sut = generateSut()
        assertThrows<ExceedingMaxSubjectsException>{
            sut.inscribeSubject(creditlessSubject)
        }
        assert(sut.currentCredits == bigSubject.credits)
        assert(sut.remainingCredits == maxCredits - bigSubject.credits)
    }



}