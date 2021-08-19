package com.margin.service.shop.model;

import com.margin.common.Schedule;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class ShopUpdateModel {

    private Long id;

    private String name;

    private Boolean active;

    private Boolean visible;

   // private Long scheduleId;

  //  private Long userId;
}
