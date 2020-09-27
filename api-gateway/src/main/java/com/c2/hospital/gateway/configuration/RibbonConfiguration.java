package com.c2.hospital.gateway.configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;

public class RibbonConfiguration {

    @Bean
    public IPing ribbonPing(final IClientConfig config) {
        System.out.println("RibbonConfiguration.ribbonPing");
        System.out.println("config = " + config);
        return new PingUrl(false, "/health");
    }

    @Bean
    public IRule ribbonRule(final IClientConfig config) {
        System.out.println("RibbonConfiguration.ribbonRule");
        System.out.println("config = " + config);
        return new AvailabilityFilteringRule();
    }
}