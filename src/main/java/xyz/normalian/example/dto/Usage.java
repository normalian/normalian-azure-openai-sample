package xyz.normalian.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Usage {
    
    @JsonProperty("completion_tokens")
    private int completionTokens;
    @JsonProperty("prompt_tokens")
    private int promptTokens;
    @JsonProperty("total_tokens")
    private int totalTokens;

    public int getCompletionTokens() {
        return completionTokens;
    }

    public void setCompletionTokens(int completionTokens) {
        this.completionTokens = completionTokens;
    }

    public int getPromptTokens() {
        return promptTokens;
    }

    public void setPromptTokens(int promptTokens) {
        this.promptTokens = promptTokens;
    }

    public int getTotalTokens() {
        return totalTokens;
    }

    public void setTotalTokens(int totalTokens) {
        this.totalTokens = totalTokens;
    }
}
