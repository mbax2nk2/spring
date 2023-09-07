package kz.nursultan.spring;

import kz.nursultan.spring.controller.HomeController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


public class WebTest {
    MockMvc mockMvc;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new HomeController()).build();
    }

    @Test
    public void test() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/").param("thing", "somewhere"))
                    .andDo(print())
                    .andExpect(MockMvcResultMatchers.content().string("home"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
