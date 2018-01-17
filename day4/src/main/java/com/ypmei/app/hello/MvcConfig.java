package hello;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("hello").setViewName("hello");
        registry.addViewController("login").setViewName("login");
        //该addViewControllers()方法（覆盖相同名称的方法WebMvcConfigurerAdapter）添加了四个视图控制器。
    }
}
