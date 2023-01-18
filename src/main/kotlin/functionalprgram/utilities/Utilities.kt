package functionalprgram.utilities

fun toSentenceCase(inputString: String): String {
    return inputString[0].uppercase() + inputString.substring(1)
}

fun applySomeFunctionToString(input: String, action: (String) -> String): String = action(input)

fun someOtherFunctionTakesInOtherFunctionToPerformOnObject(action: (String) -> String) {
    val result = action("special string")
    println(result)
}


var toSen = {
        inputString: String -> inputString[0].uppercase() + inputString.substring(1)
}

fun String.printString() {
    println(this)
}

fun main() {
    println(applySomeFunctionToString("my name is sanskar", toSen))
    println(applySomeFunctionToString("my name is sanskar") { x -> x[0].uppercase() + x.substring(1) })

    someOtherFunctionTakesInOtherFunctionToPerformOnObject {  x: String ->
        val y = x.substring(4)
        println(x)
        y.uppercase()
    }

    val colors = listOf("red", "blue","green", "black")
    val uppercaseColors = colors.map {it.uppercase()}
    uppercaseColors.forEach { println(it) }

    colors.filter { it.startsWith('b') }.forEach { println(it) }

    colors.flatMap { if(it.startsWith('b')) listOf(it, it, it) else listOf(it) }.forEach { println(it) }

    println("=============================")
    colors.map { if(it.startsWith('b')) listOf(it, it, it) else it }.forEach { println(it) }
    println("=============================")

    colors.reduce{ res, value -> "$res, $value" }.printString()
    println("=============================")
    val numbers = colors.map { it.length }
    numbers.forEach{ println(it) }
    println(numbers.sum())
    println(numbers.average())
    println(numbers.max())
    println(numbers.count())
    println(numbers.sumOf { x -> 2 * x })
    println("=============================")

    println(numbers.fold(2) { res, value -> res + value})
    val numbers2 = mutableListOf<Int>()
    println(numbers2.fold(2) { res, value -> res + value})
    println("max number = " + numbers.fold(Int.MIN_VALUE) { res, value -> if (value > res) value else res})
    println("min number = " + numbers.fold(Int.MAX_VALUE) {res, value -> if (value < res) value else res})
    println("=============================")
    val myMap = mapOf(1 to "one", 2 to "two", 3 to "three")
    myMap.filter { it.value.startsWith('t') }.forEach { println("${it.key} and ${it.value}") }
    myMap.filter { (_, v) -> v.startsWith('t') }.forEach { println("${it.key} and ${it.value}") }
}