package com.margin.listener;

import com.margin.common.GenericResponseDTO;
import com.margin.common.enums.Country;
import com.margin.common.enums.PaymentType;
import com.margin.common.enums.Unit;
import com.margin.controller.address.AddressCRUDController;
import com.margin.controller.address.dto.AddressCreationDTO;
import com.margin.controller.address.dto.AddressDTO;
import com.margin.controller.customer.CustomerCRUDController;
import com.margin.controller.customer.dto.CustomerCreationDTO;
import com.margin.controller.customer.dto.CustomerDTO;
import com.margin.controller.customer.dto.CustomerUpdateDTO;
import com.margin.controller.order.OrderCRUDController;
import com.margin.controller.order.dto.OrderCreationDTO;
import com.margin.controller.order.dto.OrderDTO;
import com.margin.controller.orderproduct.dto.OrderProductCreationDTO;
import com.margin.controller.product.ProductCRUDController;
import com.margin.controller.product.dto.ProductCreationDTO;
import com.margin.controller.product.dto.ProductDTO;
import com.margin.controller.shop.ShopCRUDController;
import com.margin.controller.shop.dto.ShopCreationDTO;
import com.margin.controller.shop.dto.ShopDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicationEventListener {

    @Autowired
    private AddressCRUDController addressCRUDController;

    @Autowired
    private CustomerCRUDController customerCRUDController;

    @Autowired
    private OrderCRUDController orderCRUDController;

    @Autowired
    private ProductCRUDController productCRUDController;

    @Autowired
    private ShopCRUDController shopCRUDController;

    @EventListener(ContextRefreshedEvent.class)
    public void onContextRefreshedEvent() {

        GenericResponseDTO<ShopDTO> shop = createShop();
        GenericResponseDTO<ProductDTO> product = createProduct(shop.getBody());
        GenericResponseDTO<ProductDTO> product1 = createProduct(shop.getBody());
        GenericResponseDTO<AddressDTO> address = createAddress();
        GenericResponseDTO<CustomerDTO> customer = createCustomer(address.getBody().getId());
        GenericResponseDTO<CustomerDTO> customer1 = createCustomer(address.getBody().getId());
        GenericResponseDTO<CustomerDTO> updatedCustomer = updateCustomer(customer.getBody(), address.getBody());
        GenericResponseDTO<OrderDTO> order = createOrder(customer.getBody().getId(), address.getBody().getId(), shop.getBody().getId());
        System.out.println();
    }

    public GenericResponseDTO<ShopDTO> createShop() {
        ShopCreationDTO shopCreationDTO = new ShopCreationDTO(
                "OurShop",
                true,
                true);
        return shopCRUDController.post(shopCreationDTO);
    }

    public GenericResponseDTO<ProductDTO> createProduct(ShopDTO shopDTO) {
        ProductCreationDTO productCreationDTO = new ProductCreationDTO(
                "Bread",
                "White bread",
                true,
                true,
                BigDecimal.valueOf(56),
                Unit.PIECE,
                shopDTO.getId());
        return productCRUDController.post(productCreationDTO);
    }

    public GenericResponseDTO<CustomerDTO> createCustomer(Long id) {
        CustomerCreationDTO customerCreationDTO = new CustomerCreationDTO(
                "Asya",
                "093910595",
                null,
                BigDecimal.ZERO);
        return customerCRUDController.post(customerCreationDTO);
    }

    public GenericResponseDTO<AddressDTO> createAddress() {
        AddressCreationDTO addressCreationDTO = new AddressCreationDTO(
                Country.ARMENIA,
                "Yerevan",
                "Yerevan",
                "565656",
                "56444",
                "0097");
        return addressCRUDController.post(addressCreationDTO);
    }

    public GenericResponseDTO<CustomerDTO> updateCustomer(CustomerDTO customerDTO, AddressDTO addressDTO) {
        CustomerUpdateDTO customerUpdateDTO = new CustomerUpdateDTO(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getPhoneNumber(),
                addressDTO.getId(),
                customerDTO.getBonus());
        return customerCRUDController.put(customerUpdateDTO, customerUpdateDTO.getId());
    }

    public GenericResponseDTO<OrderDTO> createOrder(Long customerId, Long shopId, Long addressId) {
        OrderCreationDTO orderCreationDTO = new OrderCreationDTO(
                null,
                customerId,
                shopId,
                addressId,
                BigDecimal.valueOf(78),
                BigDecimal.valueOf(56),
                BigDecimal.valueOf(77),
                PaymentType.CARD,
                BigDecimal.valueOf(89));
        return orderCRUDController.post(orderCreationDTO);
    }

    public List<OrderProductCreationDTO> createOrderProducts() {
        OrderProductCreationDTO orderProductCreationDTO = new OrderProductCreationDTO(
                8L,
                5L,
                BigDecimal.valueOf(45),
                BigDecimal.valueOf(45),
                "HELLO",
                BigDecimal.valueOf(45),
                BigDecimal.valueOf(45));

        OrderProductCreationDTO orderProductCreationDTO1 = new OrderProductCreationDTO(
                5L,
                6L,
                BigDecimal.valueOf(89),
                BigDecimal.valueOf(89),
                "shh",
                BigDecimal.valueOf(89),
                BigDecimal.valueOf(89));

        List<OrderProductCreationDTO> orderProductCreationDTOS = new ArrayList<>();
        orderProductCreationDTOS.add(orderProductCreationDTO);
        orderProductCreationDTOS.add(orderProductCreationDTO1);
        return orderProductCreationDTOS;
    }
}
