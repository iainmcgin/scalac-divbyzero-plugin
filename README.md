[Scala Compiler Plugin Tutorial]: http://www.scala-lang.org/node/140
[SBT 0.10]: https://github.com/harrah/xsbt

# Scala Compiler Plugin DivByZero Example

The code contained in this repository is based upon Lex Spoon's 
[Scala Compiler Plugin Tutorial], built against all current
released versions 2.8.x and 2.9.x and the 2.10.0 nightly.

# How to build

Install [SBT 0.10] or greater, then run

	$ sbt package

When this completes, the packaged compiler plugin (for 2.9.0-1) can be found at 
`target/scala-2.9.0-1/scalac-divbyzero-plugin-2.9.0-1-1.0.jar`.
In order to test it, simply use the Scala REPL:

	$ scala -Xplugin:target/scala-2.9.0.1/scalac-divbyzero-plugin_2.9.0-1-1.0.jar

	Welcome to Scala version 2.9.0.1 (Java HotSpot(TM) 64-Bit Server VM, Java 1.6.0_24).
	Type in expressions to have them evaluated.
	Type :help for more information.

	scala> val x = 1 / 0
	<console>:7: error: definitely division by zero
       val x = 1 / 0
                 ^

Compare this to when the plugin is not used, where the code compiles
without warning and a runtime exception is thrown:

	scala> val x = 1 / 0
	java.lang.ArithmeticException: / by zero
		at .<init>(<console>:7)
	...

In order to build the plugin for all released versions of Scala 2.8.0 and greater,
run an sbt shell:

	$ sbt
	> + package
	Setting version to 2.8.0
	...
	[success] Total time: 1 s, completed Jul 19, 2011 5:52:33 PM
	Setting version to 2.8.1
	...
	[success] Total time: 0 s, completed Jul 19, 2011 5:52:34 PM
	...
	Setting version to 2.10.0-SNAPSHOT
	...
	[success] Total time: 0 s, completed Jul 19, 2011 5:52:36 PM
	>
