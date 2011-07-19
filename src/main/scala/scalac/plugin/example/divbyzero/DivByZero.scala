package scalac.plugin.example.divbyzero

import scala.tools.nsc
import nsc.Global
import nsc.Phase
import nsc.plugins.Plugin
import nsc.plugins.PluginComponent

/**
 * An example of a simple compiler plugin, which checks for obvious
 * cases of division by zero where the denominator in the division
 * expression is the constant zero:
 *
 * {{{
 * val x = y / 0
 * }}}
 *
 * For more information on how this plugin is implemented, see
 * [[http://www.scala-lang.org/node/140 Writing Scala Compiler Plugins]]
 * by Lex Spoon.
 */
class DivByZero(val global: Global) extends Plugin {
  val name = "divbyzero"
  val description = "checks for division by zero"
  val components = List[PluginComponent](new DivByZeroComponent(global))
}

class DivByZeroComponent(val global : Global) extends PluginComponent {
  import global._
  
  val runsAfter = List("refchecks","typer")
  override val runsBefore = List("tailcalls")

  val phaseName = "divbyzero"
  def newPhase(_prev: Phase) = new DivByZeroPhase(_prev)

  class DivByZeroPhase(prev: Phase) extends StdPhase(prev) {

    override def name = "divbyzero"
    def apply(unit: CompilationUnit) {
      for ( tree @ Apply(Select(rcvr, nme.DIV), List(Literal(Constant(0)))) <- unit.body;
           if rcvr.tpe <:< definitions.IntClass.tpe) 
        {
          unit.error(tree.pos, "definitely division by zero")
        }
    }
  }
}

