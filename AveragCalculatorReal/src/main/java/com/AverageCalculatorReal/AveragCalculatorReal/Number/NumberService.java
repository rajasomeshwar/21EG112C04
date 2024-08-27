package com.AverageCalculatorReal.AveragCalculatorReal.Number;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

//@Service
public class NumberService {

    private final RestTemplate restTemplate;
    private final List<Integer> numberWindow = new ArrayList<>();
    private final int windowSize = 10;

    public NumberService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder
                .setConnectTimeout(Duration.ofMillis(500))
                .setReadTimeout(Duration.ofMillis(500))
                .build();
    }

    public NumberResponse processNumber(String numberId) throws Exception {
        Integer number = fetchNumberFromServer(numberId);

        if (number != null && !numberWindow.contains(number)) {
            if (numberWindow.size() >= windowSize) {
                numberWindow.remove(0); // Remove the oldest number
            }
            numberWindow.add(number);
        }

        double average = numberWindow.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);

        return new NumberResponse();
    }

    private Integer fetchNumberFromServer(String numberId) throws Exception {
        String url = "https://test-server/api/numbers/" + numberId;
        ResponseEntity<Integer> response = restTemplate.getForEntity(url, Integer.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new Exception("Failed to fetch number from server");
        }
    }
}
