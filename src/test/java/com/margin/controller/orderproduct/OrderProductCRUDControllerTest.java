package com.margin.controller.orderproduct;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.margin.common.exception.DomainNotValidException;
import com.margin.controller.orderproduct.dto.OrderProductCreationDTO;
import com.margin.controller.orderproduct.dto.OrderProductUpdateDTO;
import com.margin.service.orderproduct.model.OrderProductModel;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class OrderProductCRUDControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;


    @Test
    public void getOrderProductExpectStatusIsOk() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/order_products/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        String response = resultActions.andReturn().getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(response);
        String body = jsonObject.get("body").toString();
        OrderProductModel orderProductModel = mapper.readValue(body, OrderProductModel.class);
        assertEquals(new Long(1), orderProductModel.getId());
    }

    @Test
    public void postOrderProductExpectStatusIsOk() throws Exception {
        OrderProductCreationDTO orderProductCreationDTO = new OrderProductCreationDTO(
                4L, 1L,
                new BigDecimal("45"),
                new BigDecimal("78"),
                "OrderProduct",
                new BigDecimal("45"),
                new BigDecimal("10"));
        String json = mapper.writeValueAsString(orderProductCreationDTO);
        ResultActions resultActions = mockMvc.perform(post("/order_products")
                .contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isOk());
        String result = resultActions.andReturn().getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(result);
        String body = jsonObject.get("body").toString();
        OrderProductModel orderProductModel = mapper.readValue(body, OrderProductModel.class);
        assertNotNull(orderProductModel.getId());
    }

    @Test
    public void updateOrderProductExpectStatusIsOk() throws Exception {
        OrderProductUpdateDTO orderProductUpdateDTO = new OrderProductUpdateDTO(
                4L,
                5L,
                5L,
                new BigDecimal("45"),
                new BigDecimal("89"),
                "OrderProduct",
                new BigDecimal("78"),
                new BigDecimal("88")
        );
        String json = mapper.writeValueAsString(orderProductUpdateDTO);
        ResultActions resultActions = mockMvc.perform(put("/order_products/4")
                .contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isOk());
        String response = resultActions.andReturn().getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(response);
        String body = jsonObject.get("body").toString();
        OrderProductModel orderProductModel = mapper.readValue(body, OrderProductModel.class);
        assertEquals(orderProductUpdateDTO.getProductId(), orderProductModel.getProductId());
    }

    @Test
    public void deleteOrderProductExpectStatusIsOk() throws Exception {
        ResultActions resultActions = mockMvc.perform(delete("/order_products/4"))
                .andExpect(status().isOk());
        String response = resultActions.andReturn().getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(response);
        String body = jsonObject.get("body").toString();
        assertEquals("true", body);

    }

    @Test
    public void getOrderProductExpectStatusNotFound() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/order_products/-9"))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof EntityNotFoundException));
    }

    @Test
    public void postOrderProductExpectStatusUnprocessableEntity() throws Exception {
        OrderProductCreationDTO orderProductCreationDTO = new OrderProductCreationDTO(
                null,
                null,
                new BigDecimal(566),
                new BigDecimal(122),
                "sjhdkjsd",
                new BigDecimal(122),
                new BigDecimal(23)
        );
        String json = mapper.writeValueAsString(orderProductCreationDTO);
        mockMvc.perform(post("/order_products")
                        .contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isUnprocessableEntity())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof DomainNotValidException));
    }
}