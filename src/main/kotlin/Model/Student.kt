package Model

import Exceptions.ExceedingMaxCreditsException

class Student : Person {
    companion object {
        const val maxSubjects = 4
    }
    var career: String
    private var scores: ArrayList<Score>
    private var currentSubjects: ArrayList<Subject>
    var maxCredits: Int

    val currentCredits : Int get() = currentSubjects.sumOf { it.credits }
    val remainingCredits : Int get() = maxCredits - currentCredits

    constructor(
        name: String,
        lastName: String,
        age: Int,
        career: String,
        scores: ArrayList<Score>,
        currentSubjects: ArrayList<Subject>,
        maxCredits: Int
    ) : super(name, lastName, age) {
        this.career = career
        this.scores = scores
        this.currentSubjects = currentSubjects
        this.maxCredits = maxCredits
    }

    constructor(
        name: String,
        lastName: String,
        age: Int,
        career: String,
        maxCredits: Int
    ) : super(name, lastName, age) {
        this.career = career
        this.scores = arrayListOf()
        this.currentSubjects = arrayListOf()
        this.maxCredits = maxCredits
    }
    fun inscribeSubject(subject: Subject) {
        if (currentCredits + subject.credits <= maxCredits)
            currentSubjects.add(subject)
        else {
            throw ExceedingMaxCreditsException(currentCredits, maxCredits, subject.credits)
        }
    }
}