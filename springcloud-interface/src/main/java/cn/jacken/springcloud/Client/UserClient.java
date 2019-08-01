package cn.jacken.springcloud.Client;


import cn.jacken.springcloud.Entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "USER-PROVIDER",fallbackFactory = UserClientHystrixFallbackFactory.class)
@RequestMapping("/provider")
public interface UserClient {
    @RequestMapping("/user/{id}")
    User getUser(@PathVariable("id") Long id);
}
