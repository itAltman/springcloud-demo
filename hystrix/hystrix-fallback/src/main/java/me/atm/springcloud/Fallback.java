package me.atm.springcloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Altman
 * @date 2020/06/06
 **/
@Slf4j
@Component
public class Fallback implements MyService {
    @HystrixCommand(fallbackMethod = "error2")
    @Override
    public String error() {
        log.info("{}","I'm not black sheep any more!");
        throw new RuntimeException("first fallback");
    }

    public String error2() {
        log.info("{}","2222 I'm not black sheep any more!");
        return "2222 I'm not black sheep any more!";
    }

    @Override
    public String sayHi() {
        return null;
    }

    @Override
    public Friend sayHiPost(Friend friend) {
        return null;
    }

    @Override
    public String retry(@RequestParam(name = "timeout") int timeout) {
        return "you are late";
    }
}
