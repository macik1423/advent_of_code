package day5

import _2023.day1.readFileAsLinesUsingBufferedReader
import kotlin.math.abs

fun main() {
    val file = readFileAsLinesUsingBufferedReader("src/main/kotlin/day5/input.txt")

    val indexSeedToSoil = file.indexOf("seed-to-soil map:")
    val seedToSoil = getData(file, indexSeedToSoil)

    val indexSoilToFertilizer = file.indexOf("soil-to-fertilizer map:")
    val soilToFertilizer = getData(file, indexSoilToFertilizer)

    val indexFertilizerToWater = file.indexOf("fertilizer-to-water map:")
    val fertilizerToWater = getData(file, indexFertilizerToWater)

    val indexWaterToLight = file.indexOf("water-to-light map:")
    val waterToLight = getData(file, indexWaterToLight)

    val indexLightToTemperature = file.indexOf("light-to-temperature map:")
    val lightToTemperature = getData(file, indexLightToTemperature)

    val indexTemperatureToHumidity = file.indexOf("temperature-to-humidity map:")
    val temperatureToHumidity = getData(file, indexTemperatureToHumidity)

    val indexHumidityToLocation = file.indexOf("humidity-to-location map:")
    val humidityToLocation = file.subList(indexHumidityToLocation + 1, file.size).map { it.split(" ") }.map { it -> it.map { it.toLong() } }

    val converter = arrayOf(
        humidityToLocation,
        temperatureToHumidity,
        lightToTemperature,
        waterToLight,
        fertilizerToWater,
        soilToFertilizer,
        seedToSoil,
    )

    val seeds = file[0]
        .split("seeds: ")[1]
        .split(" ")
        .map { it.toLong() }
        .zipWithNext()
        .filterIndexed{ index, _ -> index % 2 == 0 }

    var locationIterator = 0L
    while (locationIterator < Long.MAX_VALUE) {
        val toConvert = locationIterator
        val fold = converter.fold(toConvert) { acc, it ->
            getConv(acc, it)
        }
        if (areSeedsContains(seeds, fold)) {
            println("$locationIterator $fold")
            return
        }
        locationIterator++
    }
}

private fun areSeedsContains(seeds: List<Pair<Long, Long>>, number: Long): Boolean {
    return seeds.any { it.first + it.second >= number && number >= it.first}
}

private fun getConv(number: Long, data: List<List<Long>>): Long {
    val indexOfFirst = data.indexOfFirst { number >= it[0] && number <= (it[0] + it[2]) }
    return when {
        indexOfFirst != -1 -> data[indexOfFirst][1] + abs(number - data[indexOfFirst][0])
        else -> number
    }
}

private fun getData(
    file: List<String>,
    index: Int
) =
    file.subList(
        index + 1,
        index + file.subList(index + 1, file.size).indexOfFirst { it == "" } + 1)
        .map{it.split(" ")}.map { it -> it.map { it.toLong() } }
