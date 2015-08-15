/**
 * 基础知识第一讲: First Knowledge。
 */
object FirstKnow {
   def main(args: Array[String]) {
      var msg = "";
      
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

      // val与var的区别就在于前者只能赋值一次，而后者可多次赋值。
      // =======================================================

      // 调用函数
      val three = addOne(2);
      println("函数：three=" + three);
      // 下面这个种用法是错误的
      // val tryOne = addOne;
      // var num01 = tryOne(2);

      // 不带参数的参数调用
      println("Result: " + threeFun() + ", " + threeFun);

      /**
       * 匿名函数
       * 注意，函数签名与函数体之间的连接符不是"="而是"=>"。
       */
      // 此处输出的是：函数对象，不是函数结果。
      println("匿名函数1：" + ((x: Int) => x + 1));
      
      // 我们可以传递匿名函数，或将其保存成不变量。
      val addOne2 = (x: Int) => x + 1;
      println("匿名函数2：" + addOne2(1));
      
      // 变量也可以接受匿名函数，
      var addOne3 = (x: Int) => x + 1;
      println("匿名函数3：" + addOne3(1));
   }

   /**
    * 使用def创建函数
    * 问题，此处即使写出返回值类型“: Int”，编译运行时也不会报错。那么什么情况下函数的返回值类型可以省略？什么情况下，必须写？
    */
   def addOne(m: Int): Int = m + 1;

   /** 
    * 不带参数的函数
    * 注意，这里不仅没有了参数，而且还没有返回值类型。
    */
   def threeFun() = 1 + 2;
}
