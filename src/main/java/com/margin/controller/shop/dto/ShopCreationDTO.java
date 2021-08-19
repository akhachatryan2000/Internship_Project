package com.margin.controller.shop.dto;

import com.margin.common.Schedule;
import com.margin.controller.user.dto.User;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class ShopCreationDTO {

    private String name;

    private Boolean active;

    private Boolean visible;

   // private Long scheduleId;

   // private Long userId;
}
