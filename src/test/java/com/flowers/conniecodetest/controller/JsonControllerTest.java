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

    private

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
    void updateEntryTest() throws Exception {
        Entry expectedEntry = new Entry(2, 12, "in quibusdam tempore odit est dolorem",
                "itaque id aut magnam\npraesentium quia et ea odit et ea voluptas et\nsapiente quia nihil amet " +
                        "occaecati quia id voluptatem\nincidunt ea est distinctio odio");
//        when()
    }
}