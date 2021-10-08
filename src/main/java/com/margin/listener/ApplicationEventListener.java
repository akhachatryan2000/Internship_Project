package com.margin.listener;

import com.margin.common.enums.Country;
import com.margin.common.enums.PaymentType;
import com.margin.common.enums.Unit;
import com.margin.common.enums.UserRole;
import com.margin.common.exception.response.GenericResponse;
import com.margin.controller.address.AddressCRUDController;
import com.margin.controller.address.dto.AddressCreationDTO;
import com.margin.controller.address.dto.AddressDTO;
import com.margin.controller.admin.AdminCRUDController;
import com.margin.controller.customer.CustomerCRUDController;
import com.margin.controller.customer.dto.CustomerCreationDTO;
import com.margin.controller.customer.dto.CustomerDTO;
import com.margin.controller.customer.dto.CustomerUpdateDTO;
import com.margin.controller.order.OrderCRUDController;
import com.margin.controller.order.dto.OrderCreationDTO;
import com.margin.controller.order.dto.OrderDTO;
import com.margin.controller.orderproduct.OrderProductCRUDController;
import com.margin.controller.orderproduct.dto.OrderProductCreationDTO;
import com.margin.controller.orderproduct.dto.OrderProductDTO;
import com.margin.controller.product.ProductCRUDController;
import com.margin.controller.product.dto.ProductCreationDTO;
import com.margin.controller.product.dto.ProductDTO;
import com.margin.controller.shop.ShopCRUDController;
import com.margin.controller.shop.dto.ShopCreationDTO;
import com.margin.controller.shop.dto.ShopDTO;
import com.margin.controller.user.dto.UserCreationDto;
import com.margin.controller.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicationEventListener {
    //ignore this class, it's intended to test the application

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

    @Autowired
    private OrderProductCRUDController orderProductCRUDController;

    @Autowired
    private AdminCRUDController adminCRUDController;

    @EventListener(ContextRefreshedEvent.class)
    public void onContextRefreshedEvent() {

        //  GenericResponse<UserDto> user = createUser();
//        GenericResponse<UserDto> user1 = createUser1();
//        GenericResponse<UserDto> driver = createDriver();
//        createShop();
//         GenericResponse<AddressDTO> addressWithoutAddressLine = createAddressWithoutAddressLine();
//        GenericResponse<ShopDTO> shop = createShop();
//        GenericResponse<ProductDTO> product = createProduct(shop.getBody());
//        GenericResponse<AddressDTO> address = createAddress();
//        GenericResponse<CustomerDTO> customer = createCustomer(address.getBody().getId());
//        GenericResponse<CustomerDTO> customer1 = createCustomer(address.getBody().getId());
//        GenericResponse<CustomerDTO> updatedCustomer = updateCustomer(customer.getBody(), address.getBody());
//        GenericResponse<OrderDTO> orderDTO = createOrderWithoutAddress();
//        GenericResponse<OrderDTO> order = createOrder(customer.getBody().getId(), address.getBody().getId(), shop.getBody().getId());
//        GenericResponse<OrderProductDTO> orderProduct = createOrderProd();
//         GenericResponse<ShopDTO> shopWithoutName = createShopWithoutName();
//         GenericResponse<ProductDTO> productWithoutName = createProductWithoutNameAndDescription(shop.getBody());
//          GenericResponse<CustomerDTO> customerDTO = createCustomerWithoutName(address.getBody().getId());
//          GenericResponse<ProductDTO> productDTO = createProductWithoutNameAndDescription(shop.getBody());
    }


    public GenericResponse<UserDto> createUser() {
        // List<RoleEntity> roles = new ArrayList<>();
//        roles.add(new RoleEntity("ADMIN"));
//        roles.add(new RoleEntity("MANAGER"));
        UserCreationDto userCreationDto = new UserCreationDto(
                "hamlet",
                "123456",
                "Hamlet",
                "Petrosyan",
                UserRole.ADMIN
        );
        return adminCRUDController.createUser(userCreationDto);
    }

    public GenericResponse<ShopDTO> createShop() {
        ShopCreationDTO shopCreationDTO = new ShopCreationDTO(
                "OurShop",
                true,
                true);
        return shopCRUDController.post(shopCreationDTO);
    }

    public GenericResponse<UserDto> createUser1() {
//        List<RoleEntity> roles = new ArrayList<>();
//        roles.add(new RoleEntity("ADMIN"));
        UserCreationDto userCreationDto = new UserCreationDto(
                "asya",
                "asya",
                "Asya",
                "Khachatryan",
                UserRole.DRIVER

        );
        return adminCRUDController.createUser(userCreationDto);
    }

    public GenericResponse<UserDto> createDriver() {
//        List<RoleEntity> roles = new ArrayList<>();
//        roles.add(new RoleEntity("DRIVER"));

        UserCreationDto userCreationDto = new UserCreationDto(
                "hello",
                "world",
                "Arpi",
                "Khachatryan",
                UserRole.DRIVER
        );
        return adminCRUDController.createUser(userCreationDto);
    }

    public GenericResponse<AddressDTO> createAddressWithoutAddressLine() {
        AddressCreationDTO addressCreationDTO = new AddressCreationDTO(
                Country.ARMENIA,
                "Yerevan",
                "Yerevan",
                "Yerevan",
                "sdkjskd",
                "0097"
        );
        return addressCRUDController.post(addressCreationDTO);
    }


//    public GenericResponse<UserDto> createUser() {
//        UserCreationDto userCreationDto1 = new UserCreationDto(
//                "user",
//                "123456",
//                "Asya",
//                "Khachatryan",
//                10L,
//                UserRole.ADMIN
//        );
//        return adminCRUDController.post(userCreationDto1);
//    }


    public GenericResponse<OrderDTO> createOrderWithoutAddress() {
        OrderCreationDTO orderCreationDTO = new OrderCreationDTO(
                null,
                1L,
                1L,
                1L,
                new BigDecimal(100),
                new BigDecimal(44),
                new BigDecimal(45),
                PaymentType.CARD,
                new BigDecimal(45));
        return orderCRUDController.post(orderCreationDTO);
    }

    public GenericResponse<OrderProductDTO> createOrderProd() {
        OrderProductCreationDTO orderProductCreationDTO = new OrderProductCreationDTO(
                5L,
                1L,
                new BigDecimal(45),
                new BigDecimal(56),
                "djskjdsj",
                new BigDecimal(56),
                new BigDecimal(89)
        );
        return orderProductCRUDController.post(orderProductCreationDTO);
    }

    public GenericResponse<ProductDTO> createProductWithoutNameAndDescription(ShopDTO shopDTO) {
        ProductCreationDTO productCreationDTO = new ProductCreationDTO(
                "",
                null,
                true,
                true,
                new BigDecimal(450),
                Unit.KG,
                shopDTO.getId());
        return productCRUDController.post(productCreationDTO);
    }

    public GenericResponse<ShopDTO> createShopWithoutName() {
        ShopCreationDTO shopCreationDTO = new ShopCreationDTO(
                null,
                true,
                true);
        return shopCRUDController.post(shopCreationDTO);
    }

    public GenericResponse<ProductDTO> createProduct(ShopDTO shopDTO) {
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

    public GenericResponse<CustomerDTO> createCustomerWithoutName(Long id) {
        CustomerCreationDTO customerCreationDTO = new CustomerCreationDTO(
                null, "5656564", id, new BigDecimal(45)
        );
        return customerCRUDController.post(customerCreationDTO);
    }

    public GenericResponse<CustomerDTO> createCustomer(Long id) {
        CustomerCreationDTO customerCreationDTO = new CustomerCreationDTO(
                "Asya",
                "093910595",
                null,
                BigDecimal.ZERO);
        return customerCRUDController.post(customerCreationDTO);
    }

    public GenericResponse<AddressDTO> createAddress() {
        AddressCreationDTO addressCreationDTO = new AddressCreationDTO(
                Country.ARMENIA,
                "Yerevan",
                "Yerevan",
                "565656",
                "56444",
                "0097");
        return addressCRUDController.post(addressCreationDTO);
    }

    public GenericResponse<CustomerDTO> updateCustomer(CustomerDTO customerDTO, AddressDTO addressDTO) {
        CustomerUpdateDTO customerUpdateDTO = new CustomerUpdateDTO(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getPhoneNumber(),
                addressDTO.getId(),
                customerDTO.getBonus());
        return customerCRUDController.put(customerUpdateDTO, customerUpdateDTO.getId());
    }

    public GenericResponse<OrderDTO> createOrder(Long customerId, Long shopId, Long addressId) {
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
