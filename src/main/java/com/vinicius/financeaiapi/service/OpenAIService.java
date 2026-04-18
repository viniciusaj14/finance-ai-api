package com.vinicius.financeaiapi.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@Service
public class OpenAIService {

    @Value("${openai.api.key}")
    private String apiKey;

    public String classify(String description) {
        try {
            URL url = new URL("https://api.openai.com/v1/chat/completions");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + apiKey);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String prompt = """
            Classifique o seguinte gasto em UMA palavra:
            Opções: Transporte, Alimentação, Mercado, Outros.
            Gasto: %s
            """.formatted(description);

            String body = """
            {
              "model": "gpt-4o-mini",
              "messages": [
                {"role": "user", "content": "%s"}
              ]
            }
            """.formatted(prompt);

            OutputStream os = conn.getOutputStream();
            os.write(body.getBytes());
            os.flush();

            Scanner scanner = new Scanner(conn.getInputStream());
            String response = scanner.useDelimiter("\\A").next();
            scanner.close();

            // 👇 AQUI ESTÁ O DIFERENCIAL
            ObjectMapper mapper = new ObjectMapper();
            JsonNode json = mapper.readTree(response);

            String result = json
                    .get("choices")
                    .get(0)
                    .get("message")
                    .get("content")
                    .asText();

            return result.trim();

        } catch (Exception e) {
            return "Outros";
        }
    }
}