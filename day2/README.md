###Lombok

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
