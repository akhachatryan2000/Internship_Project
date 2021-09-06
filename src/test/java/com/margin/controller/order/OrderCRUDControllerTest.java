package com.margin.controller.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.margin.common.enums.PaymentType;
import com.margin.common.exception.DomainNotValidException;
import com.margin.controller.order.dto.OrderCreationDTO;
import com.margin.controller.order.dto.OrderUpdateDTO;
import com.margin.service.order.model.OrderModel;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class OrderCRUDControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getOrderExpectStatusIsOk() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/orders/1")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        String response = resultActions.andReturn().getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(response);
        String body = jsonObject.get("body").toString();
        OrderModel orderModel = objectMapper.readValue(body, OrderModel.class);
        assertEquals(new Long(1), orderModel.getId());
    }

    @Test
    void postOrderExpectStatusIsOk() throws Exception {
        OrderCreationDTO orderCreationDTO = new OrderCreationDTO(
                null,
                4L,
                5L,
                11L,
                new BigDecimal("65"),
                new BigDecimal("86"),
                new BigDecimal("89"),
                PaymentType.CASH,
                new BigDecimal("89"));

        String json = objectMapper.writeValueAsString(orderCreationDTO);
        ResultActions resultActions = mockMvc.perform(post("/orders").contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().isOk());
        String response = resultActions.andReturn().getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(response);
        String body = jsonObject.get("body").toString();
        OrderModel orderModel = objectMapper.readValue(body, OrderModel.class);
        assertNotNull(orderModel.getId());
    }

    @Test
    void putOrderExpectStatusIsOk() throws Exception {
        OrderUpdateDTO orderUpdateDTO = new OrderUpdateDTO(
                1L,
                5L,
                4L,
                13L,
                new BigDecimal("78"),
                new BigDecimal("89"),
                new BigDecimal("89"),
                PaymentType.CARD,
                new BigDecimal("89")
        );
        String json = objectMapper.writeValueAsString(orderUpdateDTO);
        ResultActions resultActions = mockMvc.perform(put("/orders/5")
                .contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isOk());
        String response = resultActions.andReturn().getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(response);
        String body = jsonObject.get("body").toString();
        OrderModel order = objectMapper.readValue(body, OrderModel.class);
        assertEquals(order.getAddressId(), orderUpdateDTO.getAddressId());
    }

    @Test
    void deleteOrderExpectStatusIsOk() throws Exception {
        ResultActions resultActions = mockMvc.perform(delete("/orders/7")).andExpect(status().isOk());
        String response = resultActions.andReturn().getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(response);
        Object body = jsonObject.get("body");
        assertEquals(true, body);
    }

    @Test
    public void postOrdersExpectStatusUnprocessableEntity() throws Exception {
        OrderCreationDTO order = new OrderCreationDTO(
                null,
                null,
                7L,
                null,
                null,
                null,
                null,
                PaymentType.CARD,
                null
        );
        String json = objectMapper.writeValueAsString(order);
        mockMvc.perform(post("/orders").contentType(MediaType.APPLICATION_JSON)
                        .content(json)).andExpect(status().isUnprocessableEntity())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof DomainNotValidException));
    }

    @Test
    public void updateOrdersExpectStatusUnprocessableEntity() throws Exception {
        OrderUpdateDTO order = new OrderUpdateDTO(
                5l,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );
        String json = objectMapper.writeValueAsString(order);
        mockMvc.perform(put("/orders/5").contentType(MediaType.APPLICATION_JSON)
                        .content(json)).andExpect(status().isUnprocessableEntity())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof DomainNotValidException));
    }
}