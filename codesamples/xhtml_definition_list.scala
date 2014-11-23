// create definition list from map

def createDefinitionList(m: Map[String, String]) =
    <dl>{for ((k, v) <- m) yield <dt>{k}</dt><dd>{v}</dd>}</dl>

createDefinitionList(Map("A" -> "1", "B" -> "2"))
