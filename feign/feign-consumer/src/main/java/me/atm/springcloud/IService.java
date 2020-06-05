package me.atm.springcloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Altman
 * @date 2020/06/02
 **/
@FeignClient("eureka-client")
public interface IService {
    @GetMapping("/sayHi")
    String sayHi();
}
