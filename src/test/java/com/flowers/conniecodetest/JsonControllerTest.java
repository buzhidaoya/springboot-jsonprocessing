package com.flowers.conniecodetest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flowers.conniecodetest.controller.JsonController;
import com.flowers.conniecodetest.model.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = JsonController.class)
@ActiveProfiles("test")
class JsonControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private List<Entry> entryList;

    @BeforeEach
    void setUp() {
        this.entryList = new ArrayList<>();
        this.entryList.add(new Entry(11, 101, "title1", "body1"));
        this.entryList.add(new Entry(12, 102, "title2", "body2"));
        this.entryList.add(new Entry(13, 103, "title3", "body3"));

//        objectMapper.registerModule(new ProblemMo)
    }


    @Test
    void getEntry() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
        .get("http://jsonplaceholder.typicode.com/posts")).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("返回结果信息：" + result);
    }
}