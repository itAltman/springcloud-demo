package me.atm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Altman
 * @date 2020/06/02
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
// ribbon 负载均衡策略，由默认轮训改为随机
@RibbonClient(name = "feign-springcloud-client", configuration = com.netflix.loadbalancer.RandomRule.class)
public class FeignConApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignConApplication.class, args);
    }
}
