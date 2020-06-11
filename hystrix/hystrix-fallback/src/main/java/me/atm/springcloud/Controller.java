package me.atm.springcloud;

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
}
