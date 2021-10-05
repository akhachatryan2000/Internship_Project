package com.margin.service.orderproduct.validator;

import com.margin.common.exception.orderproduct.OrderProductNotValidException;
import com.margin.common.exception.product.ProductNotValidException;
import com.margin.common.exception.response.ExceptionCode;
import com.margin.repository.order.OrderRepository;
import com.margin.repository.product.ProductRepository;
import com.margin.service.orderproduct.model.OrderProductCreationModel;
import com.margin.service.orderproduct.model.OrderProductUpdateModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class OrderProductValidator {

    private OrderRepository orderRepository;

    private ProductRepository productRepository;

    public void orderProductIsValid(OrderProductCreationModel orderProductModel) {
        orderProductHasOrderId(orderProductModel.getOrderId());
        orderProductHasProductId(orderProductModel.getProductId());
        hasTotalPrice(orderProductModel.getTotalPrice());
        hasOriginalPrice(orderProductModel.getOriginalPrice());
        hasDiscount(orderProductModel.getDiscount());
    }

    public void orderProductIsValid(OrderProductUpdateModel orderProductModel) {
        orderProductHasOrderId(orderProductModel.getOrderId());
        orderProductHasProductId(orderProductModel.getProductId());
        hasTotalPrice(orderProductModel.getTotalPrice());
        hasOriginalPrice(orderProductModel.getOriginalPrice());
        hasDiscount(orderProductModel.getDiscount());
    }

    private void hasDiscount(BigDecimal discount) {
        if (discount == null || discount.toString().isBlank()) {
            throw new OrderProductNotValidException("Provide discount field", ExceptionCode.UUTI_45);
        }
    }

    private void orderProductHasOrderId(Long id) {
        if (id == null) {
            throw new OrderProductNotValidException("Order product must have order id", ExceptionCode.UUTI_45);
        }
        if (orderRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Such order does not exist");
        }
    }

    private void orderProductHasProductId(Long id) {
        if (id == null || id.toString().isBlank()) {
            throw new OrderProductNotValidException("Order product must have product id", ExceptionCode.UUTI_45);
        }
        if (productRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Product with this id does not exist");
        }
    }

    private void hasTotalPrice(BigDecimal totalPrice) {
        if (totalPrice == null || totalPrice.toString().isBlank()) {
            throw new ProductNotValidException("Product must have total price", ExceptionCode.UUTI_45);
        }
    }

    private void hasOriginalPrice(BigDecimal originalPrice) {
        if (originalPrice == null || originalPrice.toString().isBlank()) {
            throw new ProductNotValidException("Product must contain original price", ExceptionCode.UUTI_45);
        }
    }
}
