package com.margin.service.order.validator;

import com.margin.common.enums.PaymentType;
import com.margin.common.exception.order.OrderNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import org.springframework.stereotype.Component;

@Component
public class OrderHasPaymentType {

    public void orderHasPaymentType(PaymentType paymentType) {
        if (paymentType == null) {
            throw new OrderNotValidException("Payment type is not valid", ExceptionCode.UUTI_45);
        }
    }
}
