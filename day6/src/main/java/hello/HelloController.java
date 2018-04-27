package hello;

import com.github.pagehelper.PageHelper;
import hello.bean.Hello;
import hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/")
    public String index(){
        return "Hello Spring boot";
    }

    @RequestMapping("/likeName")
    public List<Hello> likeName(String name){
        PageHelper.startPage(1,1);
        return helloService.likeName(name);
    }

    @RequestMapping("/list")
    public List<Hello> getNameById(long id){
        return helloService.getNameById(id);
    }
}
