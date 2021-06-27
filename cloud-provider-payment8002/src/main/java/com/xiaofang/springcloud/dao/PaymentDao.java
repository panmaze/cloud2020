package com.xiaofang.springcloud.dao;


import com.xiaofang.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {

    Payment queryById(Long id);

    int insert(Payment payment);
}
