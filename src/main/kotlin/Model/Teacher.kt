package Model

class Teacher(
    name: String,
    lastName: String,
    age: Int, val area: String
) : Person(name, lastName, age) {
}