import java.time.LocalDate
data class Date(val year: Int, val month: Int, val day: Int ): Comparable<Date>{
    constructor(): this(
            LocalDate.now().year,
            LocalDate.now().monthValue,
            LocalDate.now().dayOfMonth)
    override fun compareTo(other: Date): Int {
        if (this.year != other.year) {
            return this.year - other.year
        }
        if (this.month != other.month) {
            return this.month - other.month
        }
        return this.day - other.day
    }
}
