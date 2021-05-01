package com.flowers.conniecodetest.controller;

import com.flowers.conniecodetest.model.Entry;
import com.flowers.conniecodetest.service.EntryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
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

    @Test
    void testJsonObjects() {
        Entry expectedEntry = new Entry(2, 12,
                "in quibusdam tempore odit est dolorem",
                "itaque id aut magnam\npraesentium quia et ea odit et ea voluptas et\nsapiente " +
                        "quia nihil amet occaecati quia id voluptatem\nincidunt ea est distinctio odio");
        List<Entry> list = new ArrayList<>(mock(JsonController.class).jsonToObject());
        when(list.get(12)).thenReturn(expectedEntry);
        Entry actualEntry = list.get(12);
        assertEquals(expectedEntry, actualEntry);
    }



    @Test
    void countuserTest() throws Exception {

    }

    @Test
    void updateArgumentTest () {

    }

    @Test
    void updateEntryTest() throws Exception {
        Entry expectedEntry = new Entry(2, 12,
                "in quibusdam tempore odit est dolorem",
                "itaque id aut magnam\npraesentium quia et ea odit et ea voluptas et\nsapiente " +
                        "quia nihil amet occaecati quia id voluptatem\nincidunt ea est distinctio odio");
        when(mock(JsonController.class).update(12)).thenReturn(expectedEntry);
        Entry actualEntry = mock(JsonController.class).update(12);
        assertEquals(expectedEntry, actualEntry);
    }
}