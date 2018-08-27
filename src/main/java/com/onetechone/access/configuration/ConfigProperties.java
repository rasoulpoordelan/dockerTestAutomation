package com.onetechone.access.configuration;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class ConfigProperties {

    @NotBlank
    private String jedisHost;

    @Min(1025)
    @Max(65536)
    private int jedisPort;

    public String getJedisHost() {
        return jedisHost;
    }

    public void setJedisHost(String jedisHost) {
        this.jedisHost = jedisHost;
    }

    public int getJedisPort() {
        return jedisPort;
    }

    public void setJedisPort(int jedisPort) {
        this.jedisPort = jedisPort;
    }
}