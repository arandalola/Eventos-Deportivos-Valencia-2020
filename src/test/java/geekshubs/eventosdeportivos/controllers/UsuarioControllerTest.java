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
class UsuarioControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @BeforeEach
    public  void setup(){
        DefaultMockMvcBuilder defaultBuilder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = defaultBuilder.build();
    }

    @Test
    public void listUsuarioOK()  throws Exception  {
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/v1/usuarios");
        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status()
                        .isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void createUsuario()  throws Exception {
        String content="{\"id\": 6,\"nombre\": \"Noelia\",\"apellidos\": \"Sanchez\",\"email\": \"noelia@geekshubs.com\",\"evento_id\": []}";
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.post("/v1/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content);
        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status()
                        .isOk())
                .andDo(MockMvcResultHandlers.print());
    }

}