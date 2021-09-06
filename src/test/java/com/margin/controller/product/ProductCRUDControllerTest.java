package com.margin.controller.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.margin.common.enums.Unit;
import com.margin.common.exception.DomainNotValidException;
import com.margin.controller.product.dto.ProductCreationDTO;
import com.margin.controller.product.dto.ProductUpdateDTO;
import com.margin.service.product.model.ProductModel;
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
import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ProductCRUDControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void getProductExpectStatusIsOk() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/products/4")).andExpect(status().isOk());
        String response = resultActions.andReturn().getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(response);
        String body = jsonObject.get("body").toString();
        ProductModel productModel = mapper.readValue(body, ProductModel.class);
        assertEquals(productModel.getId(), new Long(4));
    }

    @Test
    public void postProductExpectStatusIsOk() throws Exception {
        ProductCreationDTO productCreationDTO = new ProductCreationDTO(
                "Apple",
                "Green Apple",
                true,
                true,
                new BigDecimal("89"),
                Unit.KG,
                4L
        );
        String json = mapper.writeValueAsString(productCreationDTO);
        ResultActions resultActions = mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isOk());
        String response = resultActions.andReturn().getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(response);
        String body = jsonObject.get("body").toString();
        ProductModel productModel = mapper.readValue(body, ProductModel.class);
        assertNotNull(productModel.getId());
    }

    @Test
    public void updateProductExpectStatusIsOk() throws Exception {
        ProductUpdateDTO productUpdateDTO = new ProductUpdateDTO(
                7L,
                "Pear",
                "Yellow pear",
                true,
                true,
                new BigDecimal("89"),
                Unit.KG,
                8L);

        String json = mapper.writeValueAsString(productUpdateDTO);
        ResultActions resultActions = mockMvc.perform(put("/products/7").contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().isOk());
        String response = resultActions.andReturn().getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(response);
        String body = jsonObject.get("body").toString();
        ProductModel productModel = mapper.readValue(body, ProductModel.class);
        assertEquals(productUpdateDTO.getName(), productModel.getName());
    }

    @Test
    public void deleteProductExpectStatusIsOk() throws Exception {
        ResultActions resultActions = mockMvc.perform(delete("/products/4")).andExpect(status().isOk());
        String response = resultActions.andReturn().getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(response);
        Object body = jsonObject.get("body");
        assertEquals(body, true);
    }

    @Test
    public void getProductExpectStatusNotFound() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/products/500000"))
                .andExpect(status().isNotFound()).andExpect(result -> assertTrue(result.getResolvedException() instanceof EntityNotFoundException));
    }

    @Test
    public void postProductExpectStatusUnprocessableEntity() throws Exception {
        ProductCreationDTO productCreationDTO = new ProductCreationDTO(
                null,
                null,
                null,
                true,
                null,
                null,
                null
        );
        String json = mapper.writeValueAsString(productCreationDTO);
        ResultActions resultActions = mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof DomainNotValidException));
    }
}
