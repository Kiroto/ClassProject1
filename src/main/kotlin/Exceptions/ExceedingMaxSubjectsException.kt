package Exceptions

import Model.Subject

class ExceedingMaxSubjectsException(val currentSubjects: ArrayList<Subject>, val maxSubjects: Int) : Exception()