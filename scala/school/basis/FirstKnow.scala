/**
 * 基础知识第一讲: First Knowledge。
 */
object FirstKnow {
   def main(args: Array[String]) {
      // Scala中几乎一切都是表达式。
      println(1 + 1);

      // val不可变量
      val two = 1 + 1;
      println("val: " + two);
      // two = 3;   // this is a error.

      // var 变量
      var name = "steve";
      name = "marius";
      println("var - the result if steve or marius : " + name);
      //some
   }
}
