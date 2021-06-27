package com.xiaofang.springcloud.service;

import com.xiaofang.springcloud.entities.Payment;

public interface PaymentService {

    Payment queryById(Long id);

    Payment insert(Payment payment);
}
