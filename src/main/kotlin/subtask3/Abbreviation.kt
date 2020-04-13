package subtask3

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        var aiPrev = 0;
        for (bi in b.indices) {
            if (aiPrev >= a.length) return "NO"
            for (ai in aiPrev until a.length) {
                if (b[bi] != a[ai] && a[ai].isUpperCase()) return "NO"
                val aUpper = a[ai].toUpperCase()
                if (b[bi] == aUpper) {
                    aiPrev = ai + 1
                    break
                }
                if (ai >= a.length - 1) return "NO"
            }
        }

        return "YES"
    }
}
