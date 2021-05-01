package com.flowers.conniecodetest.controller;

import com.flowers.conniecodetest.model.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Iterator;
import java.util.List;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonControllerTest {

//    private MockMvc mockMvc;

//    @BeforeEach
//    void setUp() throws Exception {
//        mockMvc = MockMvcBuilders.standaloneSetup(new JsonController()).build();
//    }

    @Test
    void testGetStringjsonToObject() {
        Iterator i = mock(Iterator.class);
        when(i.next()).thenReturn("Success!");
        String res = i.next() + "";
//        verify(i, times(1)).next();
        assertEquals("Success!", res);
    }

    @Test
    void testJsonObjectObjects() {

    }



    @Test
    void countuser() throws Exception {

    }

    @Test
    void update() throws Exception {
//        mockMvc.perform(get("/update/4"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.person.name").value("Jason"));
    }
}