package com.margin.listener;

import com.margin.common.GenericResponseDTO;
import com.margin.common.enums.Country;
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
import com.margin.controller.orderproduct.OrderProductCRUDController;
import com.margin.controller.product.ProductCRUDController;
import com.margin.controller.product.dto.ProductCreationDTO;
import com.margin.controller.shop.ShopCRUDController;
import com.margin.controller.shop.dto.ShopCreationDTO;
import com.margin.controller.shop.dto.ShopDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ApplicationEventListener {

    @Autowired
    private AddressCRUDController addressCRUDController;

    @Autowired
    private CustomerCRUDController customerCRUDController;

    @Autowired
    private OrderCRUDController orderCRUDController;

    @Autowired
    private OrderProductCRUDController orderProductCRUDController;

    @Autowired
    private ProductCRUDController productCRUDController;

    @Autowired
    private ShopCRUDController shopCRUDController;

    @EventListener(ContextRefreshedEvent.class)
    public void onContextRefreshedEvent() {
        // 1.create shop

        ShopCreationDTO shopCreationDTO = new ShopCreationDTO("OurShop", true, true);
        GenericResponseDTO<ShopDTO> shopDTO = shopCRUDController.post(shopCreationDTO);

        // 2.create product
        ProductCreationDTO productCreationDTO = new ProductCreationDTO("Bread", "White bread", true,
                true, BigDecimal.ONE, Unit.PIECE, 4L);
        productCRUDController.post(productCreationDTO);

        //  3.create customer

        CustomerCreationDTO customerCreationDTO = new CustomerCreationDTO("Asya", "093910595", 5L,
                BigDecimal.ZERO, null);
        GenericResponseDTO<CustomerDTO> customerDT = customerCRUDController.post(customerCreationDTO);

        //  4.create address

        AddressCreationDTO addressCreationDTO = new AddressCreationDTO(Country.ARMENIA, "Yerevan", "Yerevan", "565656",
                "56444", "0097");
        GenericResponseDTO<AddressDTO> addressDTO = addressCRUDController.post(addressCreationDTO);

        //  5.update customer with address
        CustomerUpdateDTO customerUpdateDTO = new CustomerUpdateDTO(customerDT.getBody().getId(), "Asya", "093910595",
                addressDTO.getBody().getId(), BigDecimal.ZERO, null);
        customerCRUDController.put(customerUpdateDTO, customerDT.getBody().getId());

        //  6.create order
        OrderCreationDTO orderCreationDTO = new OrderCreationDTO();
        GenericResponseDTO<OrderDTO> orderDTO = orderCRUDController.post(orderCreationDTO);

    }

    //change dto and model object ref to long id **

    //replace converter from repository layer**

    //delete unused methods from that converters

    //fix services

}
