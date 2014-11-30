Presentation Outline
====================

- (short) history of functional languages
	- LISP / ML / Scheme
	- Haskell
	- Erlang
	- Scala

- why should we use functional languages (imperative vs. functional)?
	- avoid side effects
	- referential transparency
		- verify
		- optimize
		- parallelize

- characteristics of functional languages
	- functions are first class citizens
	- strict / lazy evaluation
	- recursion
	- type systems
	- higher order functions

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

	- control abstraction / reduce code duplication
		- recschema

	- case classes / functional data structures
		- lists
		- trees

	- for expressions
		- generators, definitions, filters
		- n queeens problem

    - map / reduce

	- lazy evaluation / infinite data structures
		- sieve of eratosthenes
		- minimum free number

	- higher order functions
		- composition
		- currying
		- extensions / DSLs

	- example from insurance mathematics
		- Beispiel: (Mehrere) Sterbetafel(n) mit mehreren Parametern -> qx nur von Alter abhängig


