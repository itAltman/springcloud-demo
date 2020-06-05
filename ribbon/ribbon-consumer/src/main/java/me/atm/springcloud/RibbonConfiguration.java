package me.atm.springcloud;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * 负载均衡策略配置
 *
 * @author Altman
 * @date 2020/06/02
 **/
@Configuration
// 局部配置（优先级：局部>全局，注解>配置文件）
@RibbonClient(name = "eureka-client", configuration = com.netflix.loadbalancer.RandomRule.class)
public class RibbonConfiguration {
    // 全局配置
//    @Bean
//    public IRule rule(){
//        // 随机策略
//        return new RandomRule();
//    }
}
