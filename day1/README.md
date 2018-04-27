
### Java包 package

* 为了更好地组织类，Java 提供了包机制，用于区别类名的命名空间。

* 语法格式：package pkg1[．pkg2[．pkg3…]];

* java中的包java.lang-打包基础的类、java.io-包含输入输出功能的函数

* 包声明应该在源文件的第一行，每个源文件只能有一个包声明，这个文件中的每个类型都应用于它。

### import 关键字
> 为了能够使用某一个包的成员，我们需要在 Java 程序中明确导入该包。使用 "import" 语句可完成此功能。

> 在 java 源文件中 import 语句应位于 package 语句之后，所有类的定义之前，可以没有，也可以有多条，其语法格式为

``````javascript
  import package1[.package2…].(classname|*);
``````

* 如果在一个包中，一个类想要使用本包中的另一个类，那么该包名可以省略。
* 如果使用的类不在包中，有三种方法引入：

> 使用类全名描述: pk.classname;

> 使用 import 关键字引入，使用通配符 "*": import package.*;

> 使用 import 关键字引入类: import package.classname;

* 类名重命名：右键———>refactor重构——>rename

####打包
mvn package

####启动
mvn package && java -jar target/ypmei-1.0-SNAPSHOT.jar
mvn clean spring-boot:run


####清除包
mvn clean


####curl
git clone https://github.com/curl/curl.git

curl http://127.0.0.1:8080/

####根目录下安装依赖，去掉测试
mvn clean install -DskipITs -DskipTests
