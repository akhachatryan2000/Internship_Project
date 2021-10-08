package com.margin.controller.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.margin.common.exception.DomainNotValidException;
import com.margin.controller.customer.dto.CustomerCreationDTO;
import com.margin.controller.customer.dto.CustomerUpdateDTO;
import com.margin.service.customer.model.CustomerModel;
import com.margin.service.customer.validator.CustomerValidator;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
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
@ExtendWith(SpringExtension.class)
class CustomerCRUDControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CustomerValidator customerValidator;

    @Test
    public void postCustomerExpectStatusIsOk() throws Exception {
        CustomerCreationDTO customer = new CustomerCreationDTO(
                "Someone",
                "45689",
                12L,
                new BigDecimal("45")
        );
        String json = objectMapper.writeValueAsString(customer);
        ResultActions resultActions = mockMvc.perform(post("/customers")
                        .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk());
        String response = resultActions.andReturn().getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(response);
        String body = jsonObject.get("body").toString();
        CustomerModel customerModel = objectMapper.readValue(body, CustomerModel.class);
        assertNotNull(customerModel.getId());
    }

    @Test
    public void getCustomerByIdExpectStatusIsOk() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/customers/1")).andExpect(status().isOk());
        String response = resultActions.andReturn().getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(response);
        String body = jsonObject.get("body").toString();
        CustomerModel customerModel = objectMapper.readValue(body, CustomerModel.class);
        assertEquals(new Long(1), customerModel.getId());
    }

    @Test
    public void updateCustomerExpectStatusIsOk() throws Exception {
        CustomerUpdateDTO updateDTO = new CustomerUpdateDTO(
                1L,
                "Asya",
                "65656",
                9L,
                new BigDecimal("78")
        );
        String json = objectMapper.writeValueAsString(updateDTO);
        ResultActions resultActions = mockMvc.perform(put("/customers/1").contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(
                status().isOk());
        String response = resultActions.andReturn().getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(response);
        String body = jsonObject.get("body").toString();
        CustomerModel customerModel = objectMapper.readValue(body, CustomerModel.class);
        System.out.println(customerModel);
        assertEquals(updateDTO.getPhoneNumber(), customerModel.getPhoneNumber());

    }

    @Test
    public void deleteCustomerByIdExpectStatusIsOk() throws Exception {
        ResultActions resultActions = mockMvc.perform(delete("/customers/1")).andExpect(status().isOk());
        String response = resultActions.andReturn().getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(response);
        Object body = jsonObject.get("body");
        assertEquals(true, body);

    }

    @Test
    public void postCustomerExpectStatusUnprocessableEntity() throws Exception {
        CustomerCreationDTO customer = new CustomerCreationDTO(
                null,
                null,
                7L,
                null
        );
        String json = objectMapper.writeValueAsString(customer);
        mockMvc.perform(post("/customers").contentType(MediaType.APPLICATION_JSON)
                        .content(json)).andExpect(status().isUnprocessableEntity())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof DomainNotValidException));
    }

    @Test
    public void updateCustomerExpectStatusUnprocessableEntity() throws Exception {
        CustomerUpdateDTO customerUpdateDTO = new CustomerUpdateDTO(
                5L,
                null,
                null,
                5L,
                null
        );
        String json = objectMapper.writeValueAsString(customerUpdateDTO);
        mockMvc.perform(put("/customers/5").contentType(MediaType.APPLICATION_JSON)
                        .content(json)).andExpect(status().isUnprocessableEntity())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof DomainNotValidException));
    }

    @Test
    public void getCustomerExpectStatusNotFound() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/customers/4")).andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof EntityNotFoundException));
    }
}