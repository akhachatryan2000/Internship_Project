package com.margin.service.orderproduct;

import com.margin.repository.orderproduct.OrderProductRepository;
import com.margin.repository.orderproduct.entity.OrderProductEntity;
import com.margin.repository.product.ProductRepository;
import com.margin.repository.product.entity.ProductEntity;
import com.margin.service.orderproduct.converter.OrderProductEntityConverter;
import com.margin.service.orderproduct.converter.OrderProductModelConverter;
import com.margin.service.orderproduct.model.OrderProductCreationModel;
import com.margin.service.orderproduct.model.OrderProductModel;
import com.margin.service.orderproduct.model.OrderProductUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class OrderProductService {

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Autowired
    private OrderProductEntityConverter orderProductEntityConverter;

    @Autowired
    private OrderProductModelConverter orderProductModelConverter;

    @Autowired
    private ProductRepository productRepository;


    public OrderProductModel get(Long id) {
        OrderProductEntity orderProductEntity = orderProductRepository.getById(id);
        return orderProductEntityConverter.convert(orderProductEntity);
    }

    @Transactional
    public OrderProductModel create(OrderProductCreationModel orderProductCreationModel) {
        OrderProductEntity orderProductEntity = orderProductModelConverter.convert(orderProductCreationModel);
        OrderProductEntity orderProductCreated = orderProductRepository.save(orderProductEntity);
        return orderProductEntityConverter.convert(orderProductCreated);
    }

    @Transactional
    public OrderProductModel update(OrderProductUpdateModel orderProductUpdateModel, Long id) {
        OrderProductEntity orderProductEntity = orderProductRepository.getById(id);
        orderProductEntity = orderProductModelConverter.convert(orderProductUpdateModel, orderProductEntity);
        orderProductEntity = orderProductRepository.save(orderProductEntity);
        return orderProductEntityConverter.convert(orderProductEntity);
    }

    public Boolean delete(Long id) {
        orderProductRepository.deleteById(id);
        return true;
    }

    public List<OrderProductModel> saveAll(List<OrderProductCreationModel> creationModels) {
        if (creationModels == null) {
            return null;
        }
        List<OrderProductEntity> entityList = orderProductModelConverter.convert(creationModels);
        entityList
                .stream()
                .filter(Objects::nonNull)
                .forEach(opcm -> {
                    ProductEntity productEntity = productRepository.getById(opcm.getProductId());
                    opcm.setProductId(productEntity.getId());
                });
        entityList = orderProductRepository.saveAll(entityList);
        return orderProductEntityConverter.convert(entityList);
    }
}
