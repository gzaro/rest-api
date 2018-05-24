package github.gzaro.rest;

import github.gzaro.rest.api.EchoController;
import github.gzaro.rest.config.SpringBootApp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.TEXT_HTML_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = SpringBootApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AcceptanceTests {

	private static final String TEST_MESSAGE = "{ \"message\": \"hello\" }";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenGettingSwaggerUiThenNoErrorIsReturned() throws Exception {
        mockMvc.perform(get("/swagger-ui.html")
                .accept(TEXT_HTML_VALUE))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void whenSendingMessageThenSameMessageIsReturned() throws Exception {
        mockMvc.perform(post(EchoController.PATH)
                .contentType(APPLICATION_JSON)
                .content(TEST_MESSAGE)
                .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(TEST_MESSAGE));
    }

}
