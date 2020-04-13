package subtask4

import java.util.*
import java.util.regex.Pattern
import kotlin.collections.HashSet

class Pangram {

    private val alphabetStart = 97
    private val alphabetEnd = 122

    private fun isLetter(char: Char): Boolean {
        return char.toLowerCase().toInt() in alphabetStart..alphabetEnd
    }

    fun getResult(inputString: String): String {

        val alphabet = HashSet<Char>()
        for (i in alphabetStart until alphabetEnd + 1) {
            alphabet.add(i.toChar())
        }
        inputString.forEach { c -> alphabet.remove(c.toLowerCase()) }

        val isPangram = alphabet.isEmpty()

        val vowels = HashSet<Char>()
        vowels.addAll(arrayOf('a', 'e', 'i', 'o', 'u', 'y'))

        val charIsTarget: (Char) -> Boolean = { c ->
            val lowerC = c.toLowerCase()
            if (isPangram) {
                vowels.contains(lowerC)
            } else {
                !vowels.contains(lowerC) && isLetter(lowerC)
            }
        }

        val words = inputString.split(Pattern.compile("\\s+")).filter { s -> s.isNotEmpty() }

        val sortedMap = TreeMap<Int, MutableList<String>>()

        words.forEach { word ->
            val count = word.count { c -> charIsTarget(c) }
            val convertedWord = word.map { c -> if (charIsTarget(c)) c.toUpperCase() else c }.joinToString("")
            val finalWord = count.toString() + convertedWord
            if (sortedMap[count] == null) sortedMap[count] = mutableListOf(finalWord)
            else sortedMap[count]?.add(finalWord)
        }

        val result = sortedMap.toList().joinToString(separator = " ", transform = { pair -> pair.second.joinToString(" ") })
        return result
    }
}
