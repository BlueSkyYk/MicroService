package com.cuityk.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

/**
 * @author liyi
 * @date 2019/12/4 17:20
 */

@RestController
public class RibbonController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/getRibbonInfo")
    public String getRibbonInfo() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("providers");
        //负载均衡算法默认是轮询，轮询取得服务
        URI uri = URI.create(String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort()));
        return uri.toString();
    }
}
