package programhabib.webmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createPerson() throws Exception {
        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("firstName", "Septiadi")
                        .param("middleName", "Habib")
                        .param("lastName", "Ashegaff")
                        .param("email", "habib@example.com")
                        .param("phone", "088910234576")
                        .param("address.street", "Jalan Besar")
                        .param("address.city", "Cikarang")
                        .param("address.country", "Indonesia")
                        .param("address.postalCode", "17535")
                        .param("hobbies[0]", "Coding")
                        .param("hobbies[1]", "Gaming")
                        .param("hobbies[2]", "Reading")
                        .param("sosialMedias[0].name", "Facebook")
                        .param("sosialMedias[0].location", "facebook.com/SeptiadiHabib")
                        .param("sosialMedias[1].name", "Instagram")
                        .param("sosialMedias[1].location", "instagram.com/SeptiadiHabib")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Success create person Septiadi Habib Ashegaff " +
                        "with email habib@example.com and phone 088910234576" +
                        "with address Jalan Besar, Cikarang, Indonesia, 17535"))
        );
    }
}