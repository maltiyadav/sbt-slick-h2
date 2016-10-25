package injecter

import com.google.inject.Guice

import scala.reflect.ClassTag

object Inject {
  lazy val injector = Guice.createInjector()

  def apply[T <: AnyRef](implicit m: ClassTag[T]): T =
    injector.getInstance(m.runtimeClass).asInstanceOf[T]
}
