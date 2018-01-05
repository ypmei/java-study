### Lombok

Lombok 是一种 Java™ 实用工具，可用来帮助开发人员消除 Java 的冗长，尤其是对于简单的 Java 对象（POJO）。它通过注解实现这一目的。

* 用处：有的时候使用这个对象,必须还要写一些getter和setter方法,可能还要写一个构造器、equals方法、或者hash方法.这些方法很冗长而且没有技术含量,我们叫它样板式代码.
lombok的主要作用是通过一些注解，消除样板式代码。

* 我的理解：就是一种装饰器，对类、方法进行一些包装，通过编译器编译使得类具有了一些常用的方法。

#### Lombok features
请参考地址：https://projectlombok.org/features/

> val
> @NonNull
> @Cleanup
> @Getter/@Setter
> @ToString
> @EqualsAndHashCode
> @NoArgsConstructor, @RequiredArgsConstructor and @AllArgsConstructor
> @Data
> @Value
> @Builder
> @SneakyThrows
> @Synchronized
> @Getter(lazy=true)
> @Log
> experimental


=================================================================
### Maven的pom.xml

什么是POM？

POM是项目对象模型(Project Object Model)的简称,它是Maven项目中的文件，使用XML表示，名称叫做pom.xml。在Maven中，当谈到Project的时候，不仅仅是一堆包含代码的文件。一个Project往往包含一个配置文件，包括了与开发者有关的，缺陷跟踪系统，组织与许可，项目的URL，项目依赖，以及其他。它包含了所有与这个项目相关的东西。事实上，在Maven世界中，project可以什么都没有，甚至没有代码，但是必须包含pom.xml文件。


`````javascript
<project xmlns="http://maven.apache.org/POM/4.0.0"  
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0  
                      http://maven.apache.org/maven-v4_0_0.xsd">  
  <modelVersion>4.0.0</modelVersion>  
  <groupId>org.codehaus.mojo</groupId>  
  <artifactId>my-project</artifactId>  
  <version>1.0</version>  
  <packaging>war</packaging>  
</project>  
`````
* groupId : 组织标识，例如：org.codehaus.mojo，在M2_REPO目录下，将是: org/codehaus/mojo目录。
* artifactId : 项目名称，例如：my-project，在M2_REPO目录下，将是：org/codehaus/mojo/my-project目录。
* version : 版本号，例如：1.0，在M2_REPO目录下，将是：org/codehaus/mojo/my-project/1.0目录。
* packaging : 打包的格式，可以为：pom , jar , maven-plugin , ejb , war , ear , rar , par

依赖关系：依赖关系列表（dependency list）是POM的重要部分
`````javascript
<dependencies>  
   <dependency>  
     <groupId>junit</groupId>  
     <artifactId>junit</artifactId>  
     <version>4.0</version>  
     <scope>test</scope>  
   </dependency>  
   …  
 </dependencies>  
`````
