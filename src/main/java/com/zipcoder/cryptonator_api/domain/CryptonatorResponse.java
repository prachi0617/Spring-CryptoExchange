package com.zipcoder.cryptonator_api.domain;

public class CryptonatorResponse {

    private Ticker ticker;
    private Boolean success;
    private String error;
    private Long timestamp;

    public CryptonatorResponse() {
    }

    public Ticker getTicker() {
        return ticker;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getError() {
        return error;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTicker(Ticker ticker) {
        this.ticker = ticker;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

}
