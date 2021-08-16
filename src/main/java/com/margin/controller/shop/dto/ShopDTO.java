package com.margin.controller.shop.dto;

import com.margin.common.Schedule;
import com.margin.controller.product.dto.ProductDTO;
import com.margin.controller.user.dto.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.util.List;
@Getter
@Setter
public class ShopDTO {

    private Long id;

    private String name;

    private Boolean active;

    private Boolean visible;

    private Schedule schedule;

    private User user;


}
