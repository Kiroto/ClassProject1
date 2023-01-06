package Exceptions

class ExceedingMaxCreditsException(val currentCredits: Int, val maxCredits: Int, val addingCredits: Int) : Exception()