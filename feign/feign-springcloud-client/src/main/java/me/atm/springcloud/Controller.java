package me.atm.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Altman
 * @date 2020/06/04
 **/
@RestController
@Slf4j
public class Controller implements IService {
    @Value("${server.port}")
    private String port;

    @Override
    public String sayHi() {
        return "This is " + port;
    }

    @Override
    public Friend sayHiPost(@RequestBody Friend friend) {
        log.info("You are " + friend.getName());
        friend.setPort(port);
        return friend;
    }

    @Override
    public String retry(@RequestParam(name = "timeout") int timeout) {
        while (--timeout >= 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        log.info("retry " + port);
        return port;
    }

}
