import java.text.DecimalFormat
fun main() {
    println("Welcome to the EcoCalculator!")
    println("Type 1 if your car runs on Gasoline, type 2 if your car runs on Diesel and type 3 if your car is electric:")
    val carType = readlnOrNull()
    println("Please choose the distance you want to travel in Km:")
    val distanceKm = readln().toInt()
    println("Finally, what is the average consumption of your vehicle?")
    val averageConsumption = readln().toFloat()
    val df = DecimalFormat("#.##")
    if (carType == "1") {
        val gasPrice = 1.862
        val moneySaved = df.format( savings(gasPrice, distanceKm , averageConsumption))
        println("If you were using an electric car you could have saved $moneySaved €")
    } else if (carType == "2") {
        val gasPrice = 1.812
        val moneySaved= df.format(savings(gasPrice, distanceKm, averageConsumption))
        println("If you were using an electric car you could have saved $moneySaved €")

    } else if (carType == "3") {
        println("Good Job! You are already Eco-Friendly!")
        val electricPrice = df.format(distanceKm *0.0025 * 24)
        print("In that trip you spent a total of $electricPrice €")
    } else {
        print("Error, please choose one of the 3 options available")
    }
}
fun savings(gasPrice: Double, distanceKm: Int, averageConsumption: Float): Float {
    val fuelNeeded = (distanceKm*0.01)*averageConsumption
    val moneyNeeded = fuelNeeded * gasPrice
    val electricPrice = (distanceKm *0.0025)* 24
    val saved = (moneyNeeded - electricPrice).toFloat()
    return saved
}