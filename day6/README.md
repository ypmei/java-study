```javascript

####Java提供了三种内建注解。
1. @Override——当我们想要复写父类中的方法时，我们需要使用该注解去告知编译器我们想要复写这个方法。这样一来当父类中的方法移除或者发生更改时编译器将提示错误信息。
2. @Deprecated——当我们希望编译器知道某一方法不建议使用时，我们应该使用这个注解。Java在javadoc 中推荐使用该注解，我们应该提供为什么该方法不推荐使用以及替代的方法。
3. @SuppressWarnings——这个仅仅是告诉编译器忽略特定的警告信息，例如在泛型中使用原生数据类型。它的保留策略是SOURCE（译者注：在源文件中有效）并且被编译器丢弃。


####创建自定义注解和创建一个接口相似，但是注解的interface关键字需要以@符号开头。我们可以为注解声明方法。

@Autowired的用法和作用
https://blog.csdn.net/mack415858775/article/details/47721909
一、@Autowired

作为一个Spring开发者对@Autowired注解必定是非常了解了, 顾名思义自动装配，应该是Spring会自动将我们标记为@Autowired的元素装配好，与其猜测不如看看它的定义：
@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD,  
                         ElementType.ANNOTATION_TYPE})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented  
public @interface Autowired {  
    boolean required() default true;  
}  

 上面是AutowiredAnnotationBeanPostProcessor类的描述文档摘要，大致意思是：这是BeanPostProcessor接口的一个实现，用来自动装配注解的变量域，setter方法和任意的config方法。这些被注入的元素是通过检测Java 5的注解完成的：默认情况下是@Autowired和@Value注解。同样也支持JSR-330的@Inject注解。并且，<context:annotation-config/>和<context:component-scan/>XML标签可以默认注册AutowiredAnnotationBeanPostProcessor到bean工厂中。最后，注解注入会在XML注入之前执行；因此后面的配置会覆盖前面已经装配好的元素。

@Bean是一个方法级别上的注解，主要用在@Configuration注解的类里，也可以用在@Component注解的类里。添加的bean的id为方法名

@Configuration
public class AppConfig {
    @Bean
    public TransferService transferService() {
        return new TransferServiceImpl();
    }
    @Bean(name = "myFoo") 默认情况下bean的名称和方法名称相同，你也可以使用name属性来指定
    @Bean(name = { "dataSource", "subsystemA-dataSource", "subsystemB-dataSource" }) bean的命名支持别名
    有时候提供bean的详细信息也是很有用的，bean的描述可以使用 @Description来提供
    @Bean
    @Description("Provides a basic example of a bean")
}

默认情况下bean的名称和方法名称相同，你也可以使用name属性来指定.

要深入学习注解，我们就必须能定义自己的注解，并使用注解，在定义自己的注解之前，我们就必须要了解Java为我们提供的元注解和相关定义注解的语法。

元注解的作用就是负责注解其他注解。Java5.0定义了4个标准的meta-annotation类型，它们被用来提供对其它 annotation类型作说明。Java5.0定义的元注解：
　　　　1.@Target,
　　　　2.@Retention,
　　　　3.@Documented,
　　　　4.@Inherited
　　这些类型和它们所支持的类在java.lang.annotation包中可以找到。下面我们看一下每个元注解的作用和相应分参数的使用说明。
>
@Target说明了Annotation所修饰的对象范围：Annotation可被用于 packages、types（类、接口、枚举、Annotation类型）、类型成员（方法、构造方法、成员变量、枚举值）、方法参数和本地变量（如循环变量、catch参数）。在Annotation类型的声明中使用了target可更加明晰其修饰的目标。

作用：用于描述注解的使用范围（即：被描述的注解可以用在什么地方）

　　取值(ElementType)有：

　　　　1.CONSTRUCTOR:用于描述构造器
　　　　2.FIELD:用于描述域
　　　　3.LOCAL_VARIABLE:用于描述局部变量
　　　　4.METHOD:用于描述方法
　　　　5.PACKAGE:用于描述包
　　　　6.PARAMETER:用于描述参数
　　　　7.TYPE:用于描述类、接口(包括注解类型) 或enum声明


@Retention定义了该Annotation被保留的时间长短：某些Annotation仅出现在源代码中，而被编译器丢弃；而另一些却被编译在class文件中；编译在class文件中的Annotation可能会被虚拟机忽略，而另一些在class被装载时将被读取（请注意并不影响class的执行，因为Annotation与class在使用上是被分离的）。使用这个meta-Annotation可以对 Annotation的“生命周期”限制。

　　作用：表示需要在什么级别保存该注释信息，用于描述注解的生命周期（即：被描述的注解在什么范围内有效）


取值（RetentionPoicy）有：
　　　　1.SOURCE:在源文件中有效（即源文件保留）
　　　　2.CLASS:在class文件中有效（即class保留）
　　　　3.RUNTIME:在运行时有效（即运行时保留）

　　Retention meta-annotation类型有唯一的value作为成员，它的取值来自java.lang.annotation.RetentionPolicy的枚举类型值。

@Documented:

@Documented用于描述其它类型的annotation应该被作为被标注的程序成员的公共API，因此可以被例如javadoc此类的工具文档化。Documented是一个标记注解，没有成员。


@Inherited：

　　@Inherited 元注解是一个标记注解，@Inherited阐述了某个被标注的类型是被继承的。如果一个使用了@Inherited修饰的annotation类型被用于一个class，则这个annotation将被用于该class的子类。

　　注意：@Inherited annotation类型是被标注过的class的子类所继承。类并不从它所实现的接口继承annotation，方法并不从它所重载的方法继承annotation。

　　当@Inherited annotation类型标注的annotation的Retention是RetentionPolicy.RUNTIME，则反射API增强了这种继承性。如果我们使用java.lang.reflect去查询一个@Inherited annotation类型的annotation时，反射代码检查将展开工作：检查class和其父类，直到发现指定的annotation类型被发现，或者到达类继承结构的顶层。


自定义注解：

　　使用@interface自定义注解时，自动继承了java.lang.annotation.Annotation接口，由编译程序自动完成其他细节。在定义注解时，不能继承其他的注解或接口。@interface用来声明一个注解，其中的每一个方法实际上是声明了一个配置参数。方法的名称就是参数的名称，返回值类型就是参数的类型（返回值类型只能是基本类型、Class、String、enum）。可以通过default来声明参数的默认值。

　　定义注解格式：
　　public @interface 注解名 {定义体}

　　注解参数的可支持数据类型：

　　　　1.所有基本数据类型（int,float,boolean,byte,double,char,long,short)
　　　　2.String类型
　　　　3.Class类型
　　　　4.enum类型
　　　　5.Annotation类型
　　　　6.以上所有类型的数组

　　Annotation类型里面的参数该怎么设定:
　　第一,只能用public或默认(default)这两个访问权修饰.例如,String value();这里把方法设为defaul默认类型；　 　
　　第二,参数成员只能用基本类型byte,short,char,int,long,float,double,boolean八种基本数据类型和 String,Enum,Class,annotations等数据类型,以及这一些类型的数组.例如,String value();这里的参数成员就为String;　　

```
