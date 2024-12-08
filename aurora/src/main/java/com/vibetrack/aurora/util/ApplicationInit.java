package com.vibetrack.aurora.util;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
@Slf4j
public class ApplicationInit {

    public static String ipAddress;

    @PostConstruct
    public void init() {
        try {
            ipAddress = InetAddress.getLocalHost().getHostAddress();
            log.info("IP address: {}", ipAddress);
        } catch (UnknownHostException e) {
            throw new RuntimeException("Failed to get IP address", e);
        }
    }
}
