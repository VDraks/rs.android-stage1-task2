package subtask1

import java.lang.Exception
import java.util.Locale
import java.util.Calendar

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        val locale = Locale("ru")
        val c = Calendar.getInstance()
        c.isLenient = false
        try {
            c.set(year.toInt(), month.toInt() - 1, day.toInt())
            val monthText = c.getDisplayName(Calendar.MONTH, Calendar.LONG, locale)
            val dayOfTheWeekText = c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, locale)
            return day + " " + monthText + ", " + dayOfTheWeekText
        } catch (e: Exception) {
            return "Такого дня не существует"
        }
    }
}
