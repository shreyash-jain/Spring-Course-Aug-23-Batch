package com.shreyash.demo;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "wa")
@ConfigurationPropertiesScan
@Component
@Validated
public class WhatsappConfig {
    private HostName hostName;

    public HostName getHostName() {
        return hostName;
    }

    public void setHostName(HostName hostName) {
        this.hostName = hostName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @NotBlank
    private String token;
}

