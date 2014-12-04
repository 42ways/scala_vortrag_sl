// Der Euklidische Algorithmus zur Berechnung des größten gemeinsamen Teilers zweier natürlicher Zahlen m, n (m ≥ 0, n > 0).

object euklid {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(222); 

  def ggt(m: Int, n: Int): Int = {
    if (n == 0) m
    else ggt(n, m % n)
  };System.out.println("""ggt: (m: Int, n: Int)Int""");$skip(15); val res$0 = 

  ggt(15, 25);System.out.println("""res0: Int = """ + $show(res$0));$skip(18); val res$1 = 
  
  ggt(42, 256);System.out.println("""res1: Int = """ + $show(res$1))}

}
