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
        seedToSoil,
        soilToFertilizer,
        fertilizerToWater,
        waterToLight,
        lightToTemperature,
        temperatureToHumidity,
        humidityToLocation
    )

    val seeds = file[0].split("seeds: ")[1].split(" ").map { it.toLong() }

    val result = converter.fold(seeds) { acc, i -> getConverted(acc, i) }
    println(result.min())
}

private fun getConverted(seeds: List<Long>, data: List<List<Long>>): List<Long> {
    val map = seeds.map { seed ->
        val indexOfFirst = data.indexOfFirst { seed >= it[1] && seed <= (it[1] + it[2]) }
        when {
            indexOfFirst != -1 -> abs(data[indexOfFirst][1] - seed) + data[indexOfFirst][0]
            else -> seed
        }
    }
    return map
}

private fun getData(
    file: List<String>,
    index: Int
) =
    file.subList(
        index + 1,
        index + file.subList(index + 1, file.size).indexOfFirst { it == "" } + 1)
        .map{it.split(" ")}.map { it -> it.map { it.toLong() } }

