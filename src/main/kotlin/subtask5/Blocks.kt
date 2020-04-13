package subtask5

import java.lang.Exception
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<Any>, blockB: KClass<*>): Any {
        var intRes: Int = 0
        var stringRes: String = ""
        var dateRes: LocalDate = LocalDate.MIN
        blockA.forEach {
            when (it) {
                is Int -> intRes += it
                is String -> stringRes += it
                is LocalDate -> dateRes = maxOf(dateRes, it)
            }
        }

        when (blockB) {
            Int::class -> return intRes
            String::class -> return stringRes
            LocalDate::class -> return dateRes.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
            else -> throw Exception()
        }
    }
}
