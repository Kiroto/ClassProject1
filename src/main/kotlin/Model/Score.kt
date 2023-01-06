package Model

class Score(val score: Int, val subject: Subject) {
    companion object {
        const val passingGrade = 70
        const val maxGrade = 100
        const val minGrade = 0
    }


    val isApproved: Boolean
        get() {
            return score >= passingGrade;
        }
}