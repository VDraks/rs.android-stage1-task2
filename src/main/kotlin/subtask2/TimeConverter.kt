package subtask2

class TimeConverter {
    private val unitsArray = arrayOf(
        "zero", "one", "two", "three", "four", "five", "six",
        "seven", "eight", "nine", "ten", "eleven", "twelve",
        "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
        "eighteen", "nineteen"
    )
    private val tensArray = arrayOf(
        "zero", "ten", "twenty", "thirty", "forty", "fifty"
    )

    private fun minutesToText(minute: Int): String {
        return when (minute) {
            0 -> unitsArray[0]
            in 1..19 -> unitsArray[minute]
            else -> tensArray[minute / 10] + " " + unitsArray[minute % 10]
        }
    }

    fun toTextFormat(hour: String, minute: String): String {
        val hourInt = hour.toInt()
        val minuteInt = minute.toInt()

        val minuteText: () -> String = { minutesToText(minuteInt) }
        val hourText: () -> String = { unitsArray[hourInt] }
        val reverseMinuteText: () -> String = { minutesToText(60 - minuteInt) }
        val nextHourText: () -> String = { unitsArray[hourInt % 12 + 1] }

        return when (minuteInt) {
            0 -> hourText() + " o' clock"
            1 -> minuteText() + " minute past " + hourText()
            15 -> "quarter past " + hourText()
            30 -> "half past " + hourText()
            45 -> "quarter to " + nextHourText()
            59 -> reverseMinuteText() + " minute to " + nextHourText()
            in 1..30 -> minuteText() + " minutes past " + hourText()
            in 31..59 -> reverseMinuteText() + " minutes to " + nextHourText()
            else -> ""
        }
    }
}
