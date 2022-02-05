package another_tasks.youtube_tasks.podlodka
/**
    https://www.youtube.com/watch?v=ou5hSWC82To
    Алгоритмическое собеседование в Android / Сергей Глотов (Авито)
    Задание 1
 */


fun main(){
    val list1 = listOf(1, 3, 1, 2)
    println(goodsPrices(list1)) // should 10

    val list2 = listOf(1, 3, 1, 2, 1, 1, 1, 2)
    println(goodsPrices(list2)) // should 18

    println("Их решение")
    println(foo(list1.toIntArray()))
    println(foo(list2.toIntArray()))
}

// мое решение
fun goodsPrices(pricesOfDays: List<Int>): Int{
    var maxCount = 10
    var sum = 0
    var index = 0
    while (index < pricesOfDays.size){
        val pair = getSumFromTo(index, pricesOfDays)
        index = pair.first + 1
        sum += pair.second
        maxCount--
    }
    return sum
}

fun getSumFromTo(index: Int, list: List<Int>): Pair<Int, Int>{
    var maxPrice = 0
    var maxPriceIndex = index
    var sum = 0
    var temp = 0

    for(i in index until list.size){
        temp = list[i]
        if (temp > maxPrice){
            maxPrice = temp
            maxPriceIndex = i
        }
    }

    sum = maxPrice * (maxPriceIndex - index + 1)
    return Pair(maxPriceIndex, sum)
}

// ИХ РЕШЕНИЕ

fun foo(arr: IntArray): Int{
    val n = arr.size
    var prevMax = 0
    var productsForSales = 0
    var res = 0

    for(i in n-1 downTo 0){
        if (arr[i] > prevMax){
            prevMax = arr[i]
        }
        res += prevMax
    }
    return res
}

