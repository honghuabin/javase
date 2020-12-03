package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 指定在RUNTIME场景下执行
@Target({ElementType.TYPE, ElementType.METHOD}) // 描述类和方法
public @interface MyAnnotation {
    String name() default "我的注解";       // 定义注解里面的属性，并设定默认值
    int age() default 12;

}
