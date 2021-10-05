package com.margin.service.order.validator;

import com.margin.common.enums.PaymentType;
import com.margin.common.exception.order.OrderNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import com.margin.repository.address.AddressRepository;
import com.margin.repository.customer.CustomerRepository;
import com.margin.repository.shop.ShopRepository;
import com.margin.service.order.model.OrderCreationModel;
import com.margin.service.order.model.OrderUpdateModel;
import com.margin.service.orderproduct.validator.OrderProductValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class OrderValidator {

    private OrderProductValidator orderProductValidator;

    private AddressRepository addressRepository;

    private CustomerRepository customerRepository;

    private ShopRepository shopRepository;


    public void orderIsValid(OrderCreationModel orderModel) {
        hasAddress(orderModel.getAddressId());
        hasShop(orderModel.getShopId());
        orderHasCustomer(orderModel.getCustomerId());
        orderHasPaymentType(orderModel.getPaymentType());
        orderHasTotalPrice(orderModel.getTotalPrice());
        hasOriginalPrice(orderModel.getOriginalPrice());
        paidFromBonus(orderModel.getPaidFromBonus());
        hasOrderDiscount(orderModel.getOrderDiscount());
        orderModel.getOrderProducts().forEach(opm -> orderProductValidator.orderProductIsValid(opm));
    }

    public void orderIsValid(OrderUpdateModel orderModel) {
        hasAddress(orderModel.getAddressId());
        hasShop(orderModel.getShopId());
        orderHasCustomer(orderModel.getCustomerId());
        orderHasPaymentType(orderModel.getPaymentType());
        hasOriginalPrice(orderModel.getOriginalPrice());
        paidFromBonus(orderModel.getPaidFromBonus());
        orderHasTotalPrice(orderModel.getTotalPrice());
        hasOrderDiscount(orderModel.getOrderDiscount());
    }

    private void hasOrderDiscount(BigDecimal discount) {
        if (discount == null || discount.toString().isBlank()) {
            throw new OrderNotValidException("Provide order discount", ExceptionCode.UUTI_45);
        }
    }

    private void hasAddress(Long id) {
        if (id == null || id.toString().isBlank()) {
            throw new OrderNotValidException("Order address is mandatory", ExceptionCode.UUTI_45);
        }
        if (addressRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Address with this id does not exist");
        }

    }

    private void orderHasCustomer(Long id) {
        if (id == null || id.toString().isBlank()) {
            throw new OrderNotValidException("Customer's name is mandatory", ExceptionCode.UUTI_45);
        }
        if (customerRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Customer with this id does not exist");
        }
    }

    private void orderHasPaymentType(PaymentType paymentType) {
        if (paymentType == null || paymentType.toString().isBlank()) {
            throw new OrderNotValidException("Payment type is not valid", ExceptionCode.UUTI_45);
        }
    }

    private void hasShop(Long id) {
        if (id == null || id.toString().isBlank()) {
            throw new OrderNotValidException("Shop id is mandatory", ExceptionCode.UUTI_45);
        }
        if (!shopRepository.findById(id).isPresent()) {
            throw new EntityNotFoundException("Shop with such id does not exist");
        }

    }

    private void hasOriginalPrice(BigDecimal price) {
        if (price == null || price.toString().isBlank()) {
            throw new OrderNotValidException("Provide original price", ExceptionCode.UUTI_45);
        }
    }

    private void orderHasTotalPrice(BigDecimal price) {
        if (price == null || price.toString().isBlank()) {
            throw new OrderNotValidException("Order price is mandatory", ExceptionCode.UUTI_45);
        }
    }

    private void paidFromBonus(BigDecimal paidFromBonus) {
        if (paidFromBonus == null || paidFromBonus.toString().isBlank()) {
            throw new OrderNotValidException("Provide paid from bonus field", ExceptionCode.UUTI_45);
        }
    }
}

