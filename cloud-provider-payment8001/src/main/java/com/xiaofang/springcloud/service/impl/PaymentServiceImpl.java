package com.xiaofang.springcloud.service.impl;

import com.xiaofang.springcloud.dao.PaymentDao;
import com.xiaofang.springcloud.entities.Payment;
import com.xiaofang.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentServiceImpl implements PaymentService {

    PaymentDao paymentDao;

    @Autowired
    public void setPaymentDao(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public Payment queryById(Long id) {
        return paymentDao.queryById(id);
    }

    @Override
    public Payment insert(Payment payment) {
        paymentDao.insert(payment);
        return payment;
    }

}
