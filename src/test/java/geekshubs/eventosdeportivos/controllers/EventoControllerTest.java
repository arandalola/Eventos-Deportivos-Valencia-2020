package geekshubs.eventosdeportivos.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class EventoControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @BeforeEach
    public  void setup(){
        DefaultMockMvcBuilder defaultBuilder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = defaultBuilder.build();
    }

    @Test
    public void listEvento()throws Exception  {
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/v1/eventos");
        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status()
                        .isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void createEvento() throws Exception {
        String content="{\"id\": 11,\"nombre\": \"Triatlon Valencia\",\"descripcion\": \"Disciplina deportiva, natación ciclismo y carrera a pie\",\"fecha\": \"2020-05-15\",\"aforo\": \"500\"}";
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.post("/v1/eventos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content);
        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status()
                        .isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}