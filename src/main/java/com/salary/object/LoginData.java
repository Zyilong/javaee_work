package com.salary.object;

public class LoginData {
    private long userId;
    private String accessToken;

    public LoginData(long userId, String accessToken) {
        this.userId = userId;
        this.accessToken = accessToken;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
