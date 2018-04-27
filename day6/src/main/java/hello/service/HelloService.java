package hello.service;

import java.util.List;

import hello.bean.Hello;
import hello.mapper.HelloMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    @Autowired
    private HelloMapper helloMapper;

    public List<Hello> likeName(String name){
        return helloMapper.likeName(name);
    }

    public List<Hello> getNameById(long id){
        return helloMapper.getNameById(id);
    }

}
