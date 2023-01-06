package Model

import org.junit.jupiter.api.Test

class ScoreTest {
    companion object {
        val mockSubject = Subject(1, "MockingSubject", 5)
    }

    @Test
    fun isApprovedPassingAtLimit() {
        val sut = Score(Score.passingGrade, mockSubject)
        assert(sut.isApproved)
    }

    @Test
    fun isApprovedPassingAtMax() {
        val sut = Score(Score.maxGrade, mockSubject)
        assert(sut.isApproved)
    }

    @Test
    fun isNotApprovedAtMin() {
        val sut = Score(Score.minGrade, mockSubject)
        assert(!sut.isApproved)
    }

    @Test
    fun isNotApprovedAtLowerThanLimit() {
        val sut = Score(Score.passingGrade -1, mockSubject)
        assert(!sut.isApproved)
    }

    @Test
    fun getScore() {
        val testingValue = 5
        val sut = Score(testingValue, mockSubject)
        assert(sut.score == testingValue)
    }

    @Test
    fun getSubject() {
        val sut = Score(Score.maxGrade, mockSubject)
        assert(sut.subject == mockSubject)
    }
}