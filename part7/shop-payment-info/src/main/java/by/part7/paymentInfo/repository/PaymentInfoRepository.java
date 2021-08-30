package by.part7.paymentInfo.repository;

import by.part7.paymentInfo.model.PaymentInfo;

import java.util.List;

public interface PaymentInfoRepository {

    List<PaymentInfo> findAll();

    PaymentInfo findById(int id);
}
