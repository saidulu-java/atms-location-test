package test.atm.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import test.atm.dto.AtmDetail;

@Configuration
public class AtmLocatorService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${atm.service.url}")
	private String url;

	public List<AtmDetail> getAllAtmsDetails() throws JsonMappingException, JsonProcessingException {

		String response = restTemplate.getForObject(url, String.class);
		response = response.substring(5, response.length());
		ObjectMapper mapper = new ObjectMapper();
		List<AtmDetail> atmDetails = mapper.readValue(response, new TypeReference<List<AtmDetail>>() {
		});
		return atmDetails;
	}

}
