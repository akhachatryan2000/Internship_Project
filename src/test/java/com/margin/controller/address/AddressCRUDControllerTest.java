package com.margin.controller.address;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.margin.common.enums.Country;
import com.margin.common.exception.DomainNotValidException;
import com.margin.controller.address.dto.AddressCreationDTO;
import com.margin.controller.address.dto.AddressUpdateDTO;
import com.margin.service.address.model.AddressModel;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.persistence.EntityNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest()
@TestPropertySource(locations = "classpath:application.properties")
@AutoConfigureMockMvc
class AddressCRUDControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void getAddressExpectOk() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/addresses/2"))
                .andDo(print()).andExpect(status().isOk());
        MvcResult mvcResult = resultActions.andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(response);
        String body = jsonObject.get("body").toString();
        AddressModel addressModel = mapper.readValue(body, AddressModel.class);
        assertEquals(Long.valueOf(2), addressModel.getId());
    }

    @Test
    public void postAddressWorksThroughAllLayers() throws Exception {
        AddressCreationDTO addressCreationDTO = new AddressCreationDTO(
                Country.ARMENIA,
                "Yerevan",
                "Yerevan",
                "Yerevan 1",
                "Yerevan 2",
                "0097"
        );
        String json = mapper.writeValueAsString(addressCreationDTO);
        ResultActions resultActions = mockMvc.perform(post("/addresses")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().isOk());
        MvcResult mvcResult = resultActions.andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        System.out.println(response);
        response = new JSONObject(response).get("body").toString();
        System.out.println(response);
        AddressModel address = mapper.readValue(response, AddressModel.class);
        System.out.println(address);
        Assertions.assertNotNull(address.getId());
    }

    @Test
    public void updateAddressThroughAllLayers() throws Exception {
        AddressUpdateDTO addressUpdateDTO = new AddressUpdateDTO(
                12L,
                Country.ARMENIA,
                "Yerevan",
                "Yerevan",
                "Yerevan 1111",
                "Yerevan 2",
                "0097"
        );
        String json = mapper.writeValueAsString(addressUpdateDTO);
        ResultActions resultActions = mockMvc.perform(put("/addresses/12")
                        .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk());
        MvcResult mvcResult = resultActions.andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        response = new JSONObject(response).get("body").toString();
        AddressModel addressModel = mapper.readValue(response, AddressModel.class);
        Assertions.assertEquals(addressModel.getAddressLine1(), addressUpdateDTO.getAddressLine1());
    }

    @Test
    public void deleteAddressExpectStatusIsOk() throws Exception {
        ResultActions resultActions = mockMvc.perform(delete("/addresses/25")).andExpect(status().isOk());
        MvcResult mvcResult = resultActions.andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        Object object = new JSONObject(response).get("body");
        assertEquals(true, object);

    }

    @Test
    public void getAddressExpectStatusNotFound() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/addresses/-1"))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof EntityNotFoundException));
    }

    @Test
    public void postAddressExpectStatusUnprocessableEntity() throws Exception {
        AddressCreationDTO addressCreationDTO = new AddressCreationDTO(
                null,
                null,
                null,
                null,
                "Yerevan 1",
                "0097"
        );
        String json = mapper.writeValueAsString(addressCreationDTO);
        mockMvc.perform(post("/addresses").contentType(MediaType.APPLICATION_JSON)
                        .content(json)).andExpect(status().isUnprocessableEntity())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof DomainNotValidException));
    }

    @Test
    public void updateAddressExpectStatusUnprocessableEntity() throws Exception {
        AddressUpdateDTO addressUpdateDTO = new AddressUpdateDTO(
                26L,
                Country.ARMENIA,
                null,
                null,
                null,
                "sjdjs",
                "88686"
        );
        String json = mapper.writeValueAsString(addressUpdateDTO);
        mockMvc.perform(put("/addresses/26").
                        contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof DomainNotValidException));
    }
}