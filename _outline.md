Presentation Outline
====================

- (short) history of functional languages
	- LISP / ML / Scheme
	- Haskell
	- Erlang
	- Scala

- characteristics of functional languages
	- first class functions
	- recursion
	- strict / lazy evaluation
	- type systems

- why should we use functional languages (imperative vs. functional)?
	- avoid side effects
	- referential transparency
		- verify
		- optimize
		- parallelize

- Scala

	- invented 2003
	- twitter backbone
	- ??? others ?
	- based on JVM
	- compatible with Java
	- quite complex
	- influences Java (e.g. lambdas in J8)
	- RegExp, XML etc. in the language

- Scala by example

	- concise coding
		- class definition (with fields); person

	- recursion
		- fac / fib / ... ?
		- quicksort

	- case classes / functional data structures
		- lists
		- trees

	- control abstraction / reduce code duplication
		- recschema

	- for expressions
		- generators, definitions, filters
		- n queeens problem

    - map / reduce

	- lazy evaluation / infinite data structures
		- sieve of eratosthenes
		- minimum free number

	- higher order functions
		- composition
		- currying (Beispiel: Sterbetafel mit mehreren Parametern -> Sterbetafel nur von Alter abhängig)

	- example from insurance mathematics

