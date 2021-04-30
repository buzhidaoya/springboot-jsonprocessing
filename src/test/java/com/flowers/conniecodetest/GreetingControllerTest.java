package com.flowers.conniecodetest;

import com.flowers.conniecodetest.controller.GreetingController;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
class GreetingControllerTest {
    @Test
    public void getCodeTest() throws Exception {
        GreetingController greetingController = new GreetingController();
        String res = greetingController.greeting();
        assertEquals(res, "Hello Spring Boot, Connie is trying to build.");

    }
}
