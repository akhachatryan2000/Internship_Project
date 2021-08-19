package com.margin.service.shop.model;

import com.margin.common.Schedule;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class ShopCreationModel {

    private String name;

    private Boolean active;

    private Boolean visible;

    //private Long scheduleId;

   // private Long userId;
}
