package xyz.normalian.example.dto;

import java.util.List;

public class ChatRequest {
    private List<Message> messages;
    private double temperature;
    private String stop;

    public ChatRequest() {
    }

    public ChatRequest(List<Message> messages, int maxTokens, double temperature, double frequencyPenalty, double presencePenalty, double topP, String stop) {
        this.messages = messages;
        this.temperature = temperature;
        this.stop = stop;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }
}
