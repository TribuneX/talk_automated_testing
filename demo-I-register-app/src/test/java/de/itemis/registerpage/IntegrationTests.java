package de.itemis.registerpage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
public class IntegrationTests {

    @Autowired
    private MockMvc mockMvc;
    private final String USERNAME = "Peter";

    @Test
    void shouldNotAcceptPassword() throws Exception {
        ResultActions requestResult = sendUsernameAndPassword(CrazyFastUnitTests.LESS_THAN_EIGHT_SYMBOLS);

        requestResult
            .andExpect(status().isOk())
            .andExpect(content().string(containsString(CrazyFastUnitTests.AT_LEAST_8_CHARACTERS_MESSAGE)));
    }

    @Test
    void shouldForwardToGreetingForValidPassword() throws Exception {
        ResultActions requestResult = sendUsernameAndPassword(CrazyFastUnitTests.VALID_PASSWORD);

        requestResult.andExpect(status().is3xxRedirection());
    }

    @Test
    public void testUserGreeting() throws Exception {
        String username = USERNAME;
        mockMvc.perform(get("/greeting?username=" + username))
               .andExpect(status().isOk())
               .andExpect(view().name("greeting"))
               .andExpect(content().string(containsString("Hello, " + USERNAME)));
    }












    private ResultActions sendUsernameAndPassword(String password) throws Exception {
        return mockMvc.perform(post("/register")
                                   .param("username", USERNAME)
                                   .param("password", password)
                                   .param("retypedPassword", password));
    }
}
