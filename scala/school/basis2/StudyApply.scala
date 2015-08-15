/**
 * apply 方法
 * 当类或者对象有一个主要用户的时候，applay方法为你提供了一个很好的语法糖
 * 
 */
object StudyApply {
   //因为这段代码，当系统调用到StudyApply()时，会直接调用Foo();
   //如果没有这段代码，编译时，会在main方法中的StudyApply()处报错。为什么？
   def apply() = new Foo;

   println("this is not printed");
   
   def main(args: Array[String]) {
      println(StudyApply());
      val bar = new Bar;
      println("bar: " + bar());
      //Bar()与bar()的区别？
   }
}

class Foo {
   println("there is Foo");
}

class Bar {
   def apply() = 0;
}
