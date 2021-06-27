package com.xiaofang.springcloud.controller;


import com.xiaofang.springcloud.entities.CommonResult;
import com.xiaofang.springcloud.entities.Payment;
import com.xiaofang.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Resource
    DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/{id}")
    public CommonResult<Payment> selectOne(@PathVariable("id") Long id) {
        Payment payment = paymentService.queryById(id);
        return new CommonResult<>(200, "select success,serverPort:" + serverPort, payment);
    }

    @PostMapping
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        Payment resultPayment = paymentService.insert(payment);
        return new CommonResult<>(200, "insert success,serverPort:" + serverPort, resultPayment);
    }

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(System.out::println);

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(instance -> {
            System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort());
        });
        return this.discoveryClient;
    }
}
