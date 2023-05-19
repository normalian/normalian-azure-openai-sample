package xyz.normalian.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Choice {
    private int index;
    @JsonProperty("finish_reason")
    private String finishReason;
    private Message message;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getFinishReason() {
        return finishReason;
    }

    public void setFinishReason(String finishReason) {
        this.finishReason = finishReason;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
