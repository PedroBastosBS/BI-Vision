package com.aline_do_bi.vison_bi;

import java.nio.charset.StandardCharsets;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void whenPostRequestToUsersAndValidUser_thenCorrectResponse() throws Exception {
        MediaType applicationJsonUtf8 = new MediaType(MediaType.APPLICATION_JSON, StandardCharsets.UTF_8);
        String user = "{\"name\": \"bob\", \"email\" : \"bob@domain.com\", \"phone\" : \"(66) 99225-0840\", \"document\" : \"123.456.789-00\", \"password\" : \"password123\", \"systemProduction\" : \"systemA\"}";
        
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                .content(user)
                .contentType(applicationJsonUtf8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("bob"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("bob@domain.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phone").value("(66) 99225-0840"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.document").value("123.456.789-00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.systemProduction").value("systemA"));
    }

    @Test
    public void whenPostRequestToUsersWithInvalidData_thenValidationErrors() throws Exception {
        MediaType applicationJsonUtf8 = new MediaType(MediaType.APPLICATION_JSON, StandardCharsets.UTF_8);
        String invalidUser = "{\"name\": \"\", \"email\" : \"invalid-email\", \"phone\" : \"1234567890\", \"document\" : \"invalid-doc\", \"password\" : \"\", \"systemProduction\" : \"\"}";
    
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                .content(invalidUser)
                .contentType(applicationJsonUtf8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is("O nome é obrigatorio")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", Is.is("O campo deve conter um email válido")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phone", Is.is("O campo informado é inválido!")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.document", Is.is("O campo informado é inválido!")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password", Is.is("A senha é obrigatoria")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.systemProduction", Is.is("O campo é obrigatorio")));
    }
}
