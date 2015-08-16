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
      println("无参的函数调用，可省括号: " + threeFun() + ", " + threeFun);

      // 带参数却没有返回值类型的函数调用
      println("带参无类型的函数调用: " + threeFun2(3));

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

      // 调用使用{}格式化后的方法
      println("timesTwo: " + timesTwo(2));

      // 匿名函数也可以这样定义。
      // 这是匿名函数的第二种定义形式。
      val anonymityFun = { i: Int =>
         println("the anonymity fuction");
         i * 2
      }
      println("anonymityFun: " + anonymityFun(3));

      // 匿名函数定义的推导形式的第一次尝试。
      // val anonymityFun2 = i: Int => i * 3;
      // println("anonymityFun: " + anonymityFun2(3));
      // 尝试失败，错误如下：
      // error: identifier expected but integer literal found.
      //     val anonymityFun2 = i: Int => i * 3;
      //                                       ^

      // 为什么匿名函数定义中，必须被{}包起来，才能将参数列表外的括号省去。

      // 匿名函数定义的推导形式的第一次尝试。
      val anonymityFun3 = { (i: Int) =>
         println("匿名函数定义的推导形式的第一次尝试");
         i * 2
      }
      println("尝试成功: " + anonymityFun3(4));

      // 调用“部分应用”的实例
      println("部分应用：" + add2(3));

      // 柯里化函数的应用
      // 这与调用用multiply时，参数是分开的
      println("正常的调用被柯里化的函数multiply：" + multiply(2)(3));
      // 我肯可以填上第一个参数并且部分应用第二个参数
      val timesTwo2 = multiply(2) _;
      println("部分应用柯里化函数multiply：" + timesTwo2(3));

      // 我们可以对任意多参数函数进行函数柯里化。
      // 注意多参函数的柯里化的写法！
      // 问题：
      //    adder被柯里化之后，变成什么样子了？
      val adder_curried = (adder _).curried;
      // val adder_normal = adder; // 这种写法是错误的，等号后面不能只跟函数名。那么我又没有办法将函数adder赋予不变量adder_normal呢？注释是函数，不是函数的返回值。
      // println("被柯里化之前的adder: " + adder_normal);
      println("被柯里化之后的adder: " + adder_curried);

      // 这个的输出怎么解释？
      println("实验：" + adder_curried(3));
      // 输出结果：
      //    实验：<function1>

      /**问题：
       * 柯里化方法与正常的多参数函数部分应用，似乎没有什么却别。那为什么要设计出一个柯里化函数呢？
       */
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

   /**
    * 带参数却省略掉返回值类型的函数
    */
   def threeFun2(i: Int) = i + 3;

   /**
    * 使用{}来格式化代码，使之易读。
    */
   def timesTwo(i: Int): Int = {
      println("the TimesTwo");
      i * 2;
   }

   def adder(m: Int, n: Int) = m + n;

   /**
    * 部分应用
    * 我们可以使用下划线（_）部分应用一个函数，结果将得到另一个函数。
    * 我们可以将下划线认为是一个没有命名的神奇通配符。
    * 在{ _ + 2 }的上下文中，它代表一个匿名参数。
    */
   def add2 = adder(2, _: Int);

   /**
    * 柯里化参数
    * 有时会有这样的需求：允许别人一会再你的函数上应用一些参数，然后有应用另外一些参数。
    * 例如乘法，在一个场景中需要选择乘数，而另外一个场景需要选择被乘数。
    * 问题：
    *   柯里化参数与正规的“部分应用”有什么不同吗？
    *   柯里化函数声明时，必须每个参数一个括号吗？答：似乎是的！
    */
   def multiply(m: Int)(n: Int): Int = m * n;
}
