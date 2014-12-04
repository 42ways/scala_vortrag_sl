
object filter_map_recuce {

  val itemPrices = Vector(10.00, 58.20, 8.99, 36.75, 47.90, 7.50)
                                                  //> itemPrices  : scala.collection.immutable.Vector[Double] = Vector(10.0, 58.2, 
                                                  //| 8.99, 36.75, 47.9, 7.5)

	Vector(10.00, 58.20, 8.99, 36.75, 47.90, 7.50) filter (price => price >= 20.0)
                                                  //> res0: scala.collection.immutable.Vector[Double] = Vector(58.2, 36.75, 47.9)

	Vector(58.2, 36.75, 47.9) map (price => price * 0.10)
                                                  //> res1: scala.collection.immutable.Vector[Double] = Vector(5.82, 3.67500000000
                                                  //| 00003, 4.79)

	Vector(5.82, 3.675, 4.79) reduce ((total, price) => total + price)
                                                  //> res2: Double = 14.285

  def calculateDiscount(prices: Seq[Double]): Double = {
    prices filter (price => price >= 20.0) map
      (price => price * 0.10) reduce
      ((total, price) => total + price)
  }                                               //> calculateDiscount: (prices: Seq[Double])Double

	calculateDiscount(itemPrices)             //> res3: Double = 14.285

  def calculateDiscount2(prices: Seq[Double]): Double = {
    prices filter (_ >= 20.0) map
      (_  * 0.10) reduce
      (_ + _)
  }                                               //> calculateDiscount2: (prices: Seq[Double])Double

	calculateDiscount2(itemPrices)            //> res4: Double = 14.285

}