package cn.bgenius.pconnect.runners;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import cn.bgenius.pconnect.Application;
import cn.bgenius.pconnect.mq.RbtmqReceiver;

///CommandLineRunner和ApplicationRunner，他们的执行时机为容器启动完成的时候。
///共同点：其一执行时机都是在容器启动完成的时候进行执行；其二这两个接口中都有一个run()方法；
///不同点：ApplicationRunner中run方法的参数为ApplicationArguments，而CommandLineRunner接口中run方法的参数为String数组。
///CommandLineRunner例子大体的思路是：编写一个class，然后实现CommandLineRunner接口，最后添加@Component注解
///ApplicationRunner例子大体的思路是：编写一个class，然后实现ApplicationRunner接口，最后添加@Component注解
@Component
@Order(value=2)
public class CmdRunnerRabbitMQ implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final RbtmqReceiver receiver;

    public CmdRunnerRabbitMQ(RbtmqReceiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
    	System.out.println("<<<<<<<<<<<<RabbitMQ CommandLineRunn接口>>>>>>>>>>>>>>");
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(Application.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ!");
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }

}