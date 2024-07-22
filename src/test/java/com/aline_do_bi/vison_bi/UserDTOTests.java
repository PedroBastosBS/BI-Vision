package com.aline_do_bi.vison_bi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.aline_do_bi.vison_bi.user.domain.dtos.UserDTO;

@SpringBootTest
public class UserDTOTests {
    @Test
    void userGetNameTest() {
        String nameExpected = "John";
        UserDTO user = new UserDTO();
        user.setName(nameExpected);
        assertEquals(nameExpected, user.getName());
    }
    @Test
    void userGetEmailTest() {
        String emailExpected = "John@email.com";
        UserDTO user = new UserDTO();
        user.setEmail(emailExpected);
        assertEquals(emailExpected, user.getEmail());
    }
    @Test
    void userGetPhoneTest() {
        String phoneExpected = "66992250840";
        UserDTO user = new UserDTO();
        user.setPhone(phoneExpected);
        assertEquals(phoneExpected, user.getPhone());
    }
    @Test
    void userGetDocumentTest() {
        String document = "00000000000";
        UserDTO user = new UserDTO();
        user.setDocument(document);
        assertEquals(document, user.getDocument());
    }
    @Test
    void userGetPasswordTest() {
        String passwordExpected = "1234143";
        UserDTO user = new UserDTO();
        user.setPassword(passwordExpected);
        assertEquals(passwordExpected, user.getPassword());
    }
    @Test
    void userGetSystemProductionTest() {
        String systemProduction = "1";
        UserDTO user = new UserDTO();
        user.setSystemProduction(systemProduction);
        assertEquals(systemProduction, user.getSystemProduction());
    }
}
