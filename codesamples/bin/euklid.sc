// Der Euklidische Algorithmus zur Berechnung des größten gemeinsamen Teilers zweier natürlicher Zahlen m, n (m ≥ 0, n > 0).

object euklid {

  def ggt(m: Int, n: Int): Int = {
    if (n == 0) m
    else ggt(n, m % n)
  }                                               //> ggt: (m: Int, n: Int)Int

  ggt(15, 25)                                     //> res0: Int = 5
  
  ggt(42, 256)                                    //> res1: Int = 2

}