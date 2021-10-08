package com.margin.controller.shop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.margin.common.exception.DomainNotValidException;
import com.margin.controller.shop.dto.ShopCreationDTO;
import com.margin.controller.shop.dto.ShopUpdateDTO;
import com.margin.service.shop.model.ShopModel;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.persistence.EntityNotFoundException;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ShopCRUDControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void getShopExpectStatusIsOk() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/shops/2")).andExpect(status().isOk());
        String response = resultActions.andReturn().getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(response);
        String body = jsonObject.get("body").toString();
        ShopModel shopModel = mapper.readValue(body, ShopModel.class);
        assertEquals(shopModel.getId(), Long.valueOf(2));
    }

    @Test
    public void postShopExpectStatusIsOk() throws Exception {
        ShopCreationDTO shopCreationDTO = new ShopCreationDTO(
                "Dvin1",
                true,
                true
        );
        String json = mapper.writeValueAsString(shopCreationDTO);
        ResultActions resultActions = mockMvc.perform(post("/shops")
                .contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isOk());
        String response = resultActions.andReturn().getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(response);
        String body = jsonObject.get("body").toString();
        ShopModel shopModel = mapper.readValue(body, ShopModel.class);
        assertNotNull(shopModel.getId());
    }

    @Test
    public void updateShopExpectStatusIsOk() throws Exception {
        ShopUpdateDTO shopUpdateDTO = new ShopUpdateDTO(
                7L, "Dvin100",
                false, true
        );
        String json = mapper.writeValueAsString(shopUpdateDTO);
        ResultActions resultActions = mockMvc.perform(put("/shops/7")
                .contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isOk());
        String response = resultActions.andReturn().getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(response);
        String body = jsonObject.get("body").toString();
        ShopModel shopModel = mapper.readValue(body, ShopModel.class);
        assertEquals(shopUpdateDTO.getName(), shopModel.getName());
    }

    @Test
    public void deleteShopExpectStatusIsOk() throws Exception {
        ResultActions resultActions = mockMvc.perform(delete("/shops/4")).andExpect(status().isOk());
        String response = resultActions.andReturn().getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(response);
        String body = jsonObject.get("body").toString();
        assertEquals("true", body);
    }

    @Test
    public void getShopExpectStatusNotFound() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/shops/-45"))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof EntityNotFoundException));
    }

    @Test
    public void postShopExpectStatusUnprocessableEntity() throws Exception {
        ShopCreationDTO shop = new ShopCreationDTO(
                null,
                null,
                null
        );
        String json = mapper.writeValueAsString(shop);
        ResultActions resultActions = mockMvc.perform(post("/shops")
                        .contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isUnprocessableEntity())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof DomainNotValidException));
    }
}
