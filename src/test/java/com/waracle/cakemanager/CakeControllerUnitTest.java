package com.waracle.cakemanager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.waracle.cakemanager.domain.Cake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;

@SpringBootTest
@AutoConfigureMockMvc
class CakeControllerUnitTest {

	private static MediaType MEDIA_TYPE_JSON;

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach()
	public void setUpJsonMediaType() {
		MEDIA_TYPE_JSON = new MediaType(MediaType.APPLICATION_JSON.getType(),
				MediaType.APPLICATION_JSON.getSubtype(),
				Charset.defaultCharset());

	}

	@Test
	public void whenPostHttpRequesttoCakes_thenStatusOK() throws Exception {
		Cake cake = new Cake("Res Velvet", "Red Velvet Cake",
				"https://sugargeekshow.com/wp-content/uploads/2018/01/classic-red-velvet-cake-recipe-17.jpg.webp");
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = objectWriter.writeValueAsString(cake);

		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/cakes")
						.contentType(MEDIA_TYPE_JSON)
						.content(requestJson)
				)

				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void whenGetHttpRequesttoCakes_thenStatusOK() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/cakes/list"))

				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
