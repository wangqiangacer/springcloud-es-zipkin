package cn.jacken.springcloud.Client;


import cn.jacken.springcloud.Entity.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author wangqiang
 * @version V1.0
 * @date 2019/6/8 16:10
 */
@Component
public class UserClientHystrixFallbackFactory implements FallbackFactory<UserClient> {//对哪一个接口托底处理
    public UserClient create(Throwable throwable) {
        return new UserClient() {
            public User getUser(Long id) {
                return new User(id,"出异常了！！！！");
            }
        };
    }
}
