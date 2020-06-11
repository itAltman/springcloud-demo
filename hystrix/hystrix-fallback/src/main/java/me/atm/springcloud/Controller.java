package me.atm.springcloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Altman
 * @date 2020/06/06
 **/
@RestController
public class Controller {
    @Autowired
    private MyService myService;

    @GetMapping("/fallback")
    public String fallback(){
        return myService.error();
    }

    @GetMapping("/timeout")
    public String timeout(Integer t){
        return myService.retry(t);
    }


    // 这里需要确认全局超时时间是否有配置
    @HystrixCommand(
            fallbackMethod = "timeout2Fallback",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
            }
    )
    @GetMapping("/timeout2")
    public String timeout2(Integer t){
        return myService.retry(t);
    }

    public String timeout2Fallback(Integer t){
        return "timeout2Fallback";
    }
}
