package com.margin.controller.shop.dto;

import com.margin.common.Schedule;
import com.margin.controller.user.dto.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopCreationDTO {

    private String name;

    private Boolean active;

    private Boolean visible;

    private Schedule schedule;

    private User user;
}
