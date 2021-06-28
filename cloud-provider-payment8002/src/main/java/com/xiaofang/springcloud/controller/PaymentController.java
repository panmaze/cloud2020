package com.xiaofang.springcloud.controller;

import com.xiaofang.springcloud.entities.CommonResult;
import com.xiaofang.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.xiaofang.springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> selectOne(@PathVariable("id") Long id) {
        Payment payment = paymentService.queryById(id);
        return new CommonResult<>(200, "select success,serverPort:" + serverPort, payment);
    }

    @PostMapping("/payment")
    public  CommonResult<Payment>create(@RequestBody Payment payment){
        Payment resultPayment = paymentService.insert(payment);
        return new CommonResult<>(200,"insert success,serverPort:"+serverPort,resultPayment);
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
