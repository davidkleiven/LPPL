package lppl

fun getEnvironmentVariable(name: String): String {
    return System.getenv(name) ?: throw NullPointerException("$name must be set")
}
data class Config (val url: String = "https://api.polygon.io/v2/aggs/ticker/I:DJI/range/1/day") {
    val apiKey: String
        get() = getEnvironmentVariable("API_KEY")
}