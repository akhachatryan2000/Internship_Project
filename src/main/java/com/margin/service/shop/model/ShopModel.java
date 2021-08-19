package com.margin.service.shop.model;

import com.margin.common.Schedule;

import com.margin.service.product.model.ProductModel;
import com.margin.service.user.model.UserModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class ShopModel {

    private Long id;

    private String name;

    private Boolean active;

    private Boolean visible;

   // private Long scheduleId;

   //private Long userId;


}
