package com.margin.service.orderproduct;

import com.margin.entity.OrderProductEntity;
import com.margin.entity.ProductEntity;
import com.margin.repository.orderproduct.OrderProductRepository;
import com.margin.repository.product.ProductRepository;
import com.margin.service.orderproduct.converter.OrderProductEntityConverter;
import com.margin.service.orderproduct.converter.OrderProductModelConverter;
import com.margin.service.orderproduct.model.OrderProductCreationModel;
import com.margin.service.orderproduct.model.OrderProductModel;
import com.margin.service.orderproduct.model.OrderProductUpdateModel;
import com.margin.service.orderproduct.validator.OrderProductValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderProductService {

    private OrderProductRepository orderProductRepository;

    private OrderProductEntityConverter orderProductEntityConverter;

    private OrderProductModelConverter orderProductModelConverter;

    private ProductRepository productRepository;

    private OrderProductValidator orderProductValidator;


    public OrderProductModel get(Long id) {
        OrderProductEntity orderProductEntity = orderProductRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product with id " + id + " does not exist"));
        return orderProductEntityConverter.convert(orderProductEntity);
    }

    @Transactional
    public OrderProductModel create(OrderProductCreationModel orderProductCreationModel) {
        orderProductValidator.orderProductIsValid(orderProductCreationModel);
        OrderProductEntity orderProductEntity = orderProductModelConverter.convert(orderProductCreationModel);
        OrderProductEntity orderProductCreated = orderProductRepository.save(orderProductEntity);
        return orderProductEntityConverter.convert(orderProductCreated);
    }

    @Transactional
    public OrderProductModel update(OrderProductUpdateModel orderProductUpdateModel, Long id) {
        OrderProductEntity orderProductEntity = orderProductRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product with this id does not exist"));
        orderProductValidator.orderProductIsValid(orderProductUpdateModel);
        orderProductEntity = orderProductModelConverter.convert(orderProductUpdateModel, orderProductEntity);
        orderProductEntity = orderProductRepository.save(orderProductEntity);
        return orderProductEntityConverter.convert(orderProductEntity);
    }

    public Boolean delete(Long id) {
        orderProductRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order product does not exist"));
        orderProductRepository.updateDeleted(id);
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
                .forEach(op -> {
                    ProductEntity productEntity = productRepository.getById(op.getProductId());
                    op.setProductId(productEntity.getId());
                });
        entityList = orderProductRepository.saveAll(entityList);
        return orderProductEntityConverter.convert(entityList);
    }

    public List<OrderProductModel> getAll() {
        List<OrderProductEntity> orderProductEntities = orderProductRepository.findAllOrdered();
        return orderProductEntities
                .stream()
                .map(orderProductEntity -> orderProductEntityConverter.convert(orderProductEntity))
                .collect(Collectors.toList());
    }
}
