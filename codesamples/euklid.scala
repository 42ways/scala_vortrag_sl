// Der Euklidische Algorithmus zur Berechnung des größten gemeinsamen Teilers zweier natürlicher Zahlen m, n (m ≥ 0, n > 0).

def ggt(m: Int, n: Int): Int = {
    if (n == 0) m
    else ggt(n, m % n)
}

ggt(15, 25)
ggt(42, 256)
