package com.intellibucket.flyjob.ws;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(
        scanBasePackages = {
                "com.intellibucket.flyjob.ws.auth"
        }
)
@EnableDiscoveryClient
public class ImageProcessorService {
    public static void main(String[] args) {
        SpringApplication.run(ImageProcessorService.class, args);
    }
}