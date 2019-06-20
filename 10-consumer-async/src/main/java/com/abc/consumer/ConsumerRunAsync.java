package com.abc.consumer;

import com.abc.service.OtherService;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ConsumerRunAsync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-consumer.xml");
        OtherService service = (OtherService) ac.getBean("otherService");

        // 记录异步调用开始时间
        long asyncStart = System.currentTimeMillis();

        // 异步调用
        // long syncInvokeTime = System.currentTimeMillis() - asyncStart;
        // System.out.println("两个异步调用共计用时（毫秒）：" + syncInvokeTime);

        String doThird = service.doThird();
        System.out.println("doThird：" + doThird);
        Future<String> thirdFuture = RpcContext.getContext().getFuture();
        String thirdFutureResult = thirdFuture.get();
        System.out.println("异步，通过Future获取到返回值：" + thirdFutureResult);

        String doFourth = service.doFourth();
        System.out.println("doFourth" + doFourth);
        Future<String> fourthFuture = RpcContext.getContext().getFuture();
        String fourthFutureResult = fourthFuture.get();
        System.out.println("异步，通过Future获取到返回值：" + fourthFutureResult);

        long getResultTime = System.currentTimeMillis() - asyncStart;
        System.out.println("获取到两个异步调用结果共计用时（毫秒）：" + getResultTime);

    }
}
