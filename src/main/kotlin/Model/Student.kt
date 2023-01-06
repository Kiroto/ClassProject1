package Model

class Student(
    name: String,
    lastName: String,
    age: Int,
    var career: String,
    var scores: List<Score>,
    var currentSubjects: List<Subject>,
    var maxCredits: Int
) : Person(name, lastName, age) {

    fun inscribeSubject(subject: Subject) {

    }
}