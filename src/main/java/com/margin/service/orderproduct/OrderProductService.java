package com.margin.service.orderproduct;

import com.margin.repository.orderproduct.OrderProductRepository;
import com.margin.repository.orderproduct.entity.OrderProductEntity;
import com.margin.service.orderproduct.converter.OrderProductEntityConverter;
import com.margin.service.orderproduct.model.OrderProductCreationModel;
import com.margin.service.orderproduct.model.OrderProductModel;
import com.margin.service.orderproduct.model.OrderProductUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProductService {

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Autowired
    private OrderProductEntityConverter orderProductEntityConverter;


    public OrderProductModel get(Long id) {
        OrderProductEntity orderProductEntity = orderProductRepository.getById(id);
        return orderProductEntityConverter.convert(orderProductEntity);
    }

    public OrderProductModel create(OrderProductCreationModel orderProductCreationModel) {
        OrderProductEntity orderProductEntity = orderProductEntityConverter.convert(orderProductCreationModel);
        //check product id from db
        OrderProductEntity orderProductCreated = orderProductRepository.save(orderProductEntity);
        return orderProductEntityConverter.convert(orderProductCreated);
    }

    public OrderProductModel update(OrderProductUpdateModel orderProductUpdateModel, Long id) {
        OrderProductEntity orderProductEntity = orderProductRepository.getById(id);
        OrderProductEntity orderEntity1 = orderProductEntityConverter.convert(orderProductUpdateModel, orderProductEntity);
        return orderProductEntityConverter.convert(orderEntity1);
    }

    public Boolean delete(Long id) {
        orderProductRepository.deleteById(id);
        return true;
    }
}
