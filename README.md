[Scala Compiler Plugin Tutorial]: http://www.scala-lang.org/node/140
[sbt runner]: https://github.com/paulp/sbt-extras

# Scala Compiler Plugin DivByZero Example

The code contained in this repository is based upon Lex Spoon's 
[Scala Compiler Plugin Tutorial], built against scala 2.9.1 and
snapshots of unreleased scala 2.10.0.

# How to build

Download the sbt-extras [sbt runner] and run

	  $ sbt package

When this completes, the packaged compiler plugin (for 2.9.1-1) can be found at
`target/scala-2.9.1/scalac-divbyzero-plugin_2.9.1-1.0.jar`.  Test it in the Scala REPL:

    $ scala -Xplugin:target/scala-2.9.1/scalac-divbyzero-plugin_2.9.1-1.0.jar

    Welcome to Scala version 2.9.1-1 (Java HotSpot(TM) 64-Bit Server VM, Java 1.6.0_29).
    Type in expressions to have them evaluated.
    Type :help for more information.

    scala> def f = 1 / 0
    <console>:7: error: definitely division by zero
           def f = 1 / 0
                     ^

Compare this to when the plugin is not used, where the code compiles
without warning and throws an exception when run:

    scala> def f = 1 / 0
    f: Int

    scala> f
    java.lang.ArithmeticException: / by zero
  	at .f(<console>:7)	...

In order to build the plugin for all supported versions of scala, run

  	$ sbt +package
