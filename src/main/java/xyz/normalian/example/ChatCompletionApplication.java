package xyz.normalian.example;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import xyz.normalian.example.dto.ChatCompletion;
import xyz.normalian.example.dto.ChatRequest;
import xyz.normalian.example.dto.Choice;
import xyz.normalian.example.dto.Message;

public class ChatCompletionApplication {

	private static final Logger log = LoggerFactory.getLogger(ChatCompletionApplication.class);

	public static void main(String[] args) throws Exception{
		//SpringApplication.run(ConsumingRestApplication.class, args);
		try{
			RestTemplate restTemplate = new RestTemplate(); 

			String deploymentName = System.getenv("AOAI_DEPLOYMENT_NAME");
			String baseUrl = System.getenv("AOAI_BASE_URL");
			String apiKey = System.getenv("AOAI_API_KEY");

			log.info("deployment name:" + deploymentName);
			log.info("base url:" + baseUrl);
			log.info("api key:" + apiKey);
			if(deploymentName == null || baseUrl == null || apiKey ==null){
				log.error("deployment name, base url, or api key are not valid. Check your environment variable.");
				System.exit(0);
			}

			String url = baseUrl + "/openai/deployments/" + deploymentName + "/chat/completions?api-version=2023-03-15-preview";

			ChatRequest chatRequest = new ChatRequest();
			List<Message> messages = new ArrayList<>();
			messages.add(new Message( "system", "You are an AI assistant that helps people find information."));
			messages.add(new Message( "user", "How can I leverage both Azure Cognitive Search and Azure Open AI?"));
			chatRequest.setMessages(messages);
			chatRequest.setTemperature(0.7);
			chatRequest.setStop(null);

			ObjectMapper objectMapper = new ObjectMapper();
			String jsonString = objectMapper.writeValueAsString(chatRequest);

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.add("api-key", apiKey);
			HttpEntity<String> entity = new HttpEntity<>(jsonString, headers);

			ChatCompletion response = restTemplate.postForObject(url, entity, ChatCompletion.class);
			if(response != null){
				log.info("ID: " + response.getId());
				log.info("Model: " + response.getModel());
				for( Choice choice : response.getChoices()){
					log.info("[" + choice.getIndex() + "] role: " + choice.getMessage().getRole() + ", content: " + choice.getMessage().getContent());
				}
			}else{
				log.info("response was null.");
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
}
