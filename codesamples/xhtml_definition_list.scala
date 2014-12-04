// create definition list from map

object xml_definition_list {

  def createDefinitionList(m: Map[String, String]) =
    <dl>{ for ((k, v) <- m) yield <dt>{ k }</dt><dd>{ v }</dd> }</dl>

  createDefinitionList(Map("A" -> "1", "B" -> "2"))

}

