package com.margin.service.orderproduct;


import com.margin.repository.orderproduct.OrderProductRepository;
import com.margin.repository.orderproduct.entity.OrderProductEntity;
import com.margin.service.orderproduct.converter.OrderProductEntityConverter;
import com.margin.service.orderproduct.model.OrderProductCreationModel;
import com.margin.service.orderproduct.model.OrderProductModel;
import com.margin.service.orderproduct.model.OrderProductUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class OrderProductService {

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Autowired
    private OrderProductEntityConverter orderProductEntityConverter;


    public OrderProductModel get(Long id) {
        try {
            OrderProductEntity orderProductEntity = orderProductRepository.getById(id);
            OrderProductModel orderProductModel = orderProductEntityConverter.convert(orderProductEntity);
            return orderProductModel;
        } catch (EntityNotFoundException exception) {
            System.out.println("No such element to retrieve");
        }

        return null;
    }

    public OrderProductModel create(OrderProductCreationModel orderProductCreationModel) {
        OrderProductEntity orderProductEntity = orderProductEntityConverter.convert(orderProductCreationModel);
        OrderProductEntity orderProductCreated = orderProductRepository.save(orderProductEntity);
        OrderProductModel orderProductModel = orderProductEntityConverter.convert(orderProductCreated);
        return orderProductModel;
    }

    public OrderProductModel update(OrderProductUpdateModel orderProductUpdateModel, Long id) {
        try {
            OrderProductEntity orderProductEntity = orderProductRepository.getById(id);
            OrderProductEntity orderEntity1 = orderProductEntityConverter.convert(orderProductUpdateModel, orderProductEntity);
            OrderProductModel orderProductModel = orderProductEntityConverter.convert(orderEntity1);
            return orderProductModel;

        } catch (EntityNotFoundException exception) {
            System.out.println("There is no such entity to update");
        }
        return null;
    }

    public Boolean delete(Long id) {
        try {
            orderProductRepository.deleteById(id);
            return true;

        } catch (EntityNotFoundException exception) {
            System.out.println("No such entity to delete");
        }
        return null;
    }

}
