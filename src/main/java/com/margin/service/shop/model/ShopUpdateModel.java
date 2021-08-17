package com.margin.service.shop.model;

import com.margin.common.Schedule;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ShopUpdateModel {

    private Long id;

    private String name;

    private Boolean active;

    private Boolean visible;

    private Schedule schedule;

    //private User user;
}