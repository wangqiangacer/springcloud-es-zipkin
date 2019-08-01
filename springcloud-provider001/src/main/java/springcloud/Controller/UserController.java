package springcloud.Controller;

import cn.jacken.springcloud.Client.UserClient;
import cn.jacken.springcloud.Entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/provider")
@RestController
public class UserController implements UserClient {
    @HystrixCommand(fallbackMethod = "getUserFailBack")
    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable("id")Long id) {
        if(id==2){
            throw  new RuntimeException("用户不存在！！！");
        }
        return  new User(id,"wangqiang2222");
    }

    public  User getUserFailBack(Long id){
        return  new User(id,"出异常了，请联系管理员！！！！");
    }
}
