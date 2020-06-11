package me.atm.springcloud;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Altman
 * @date 2020/06/06
 **/
@FeignClient(name = "feign-springcloud-client",fallback = Fallback.class)
public interface MyService extends IService {


}
