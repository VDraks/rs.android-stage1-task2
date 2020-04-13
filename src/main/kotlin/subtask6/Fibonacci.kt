package subtask6

class Fibonacci {

    fun productFibonacciSequenceFor(n: Int): IntArray {
        var fN = 0
        var fNN = 1
        while (fN * fNN < n) {
            val oldFN = fN
            fN = fNN
            fNN += oldFN
        }
        return intArrayOf(fN, fNN, if (fN * fNN == n) 1 else 0)
    }
}
