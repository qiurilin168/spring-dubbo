package com.kaikeba.consumer;

import com.kaikeba.common.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerRun {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-consumer.xml");
        UserService service = (UserService) ac.getBean("userService");
        // 对于有返回值的方法，其服务降级后的值为null
        String username = service.getUsernameById(5);
        System.out.println(username);
        // 对于无返回值的方法，其服务阶级后没有任何输出，但也不会报错
        service.addUser("张三");
    }
}
