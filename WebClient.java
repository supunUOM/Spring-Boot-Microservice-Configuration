//1. ========================================= Maven dependency =========================================
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-webflux</artifactId>
		</dependency>

//2. ========================================= Config/WebClientConfig.java =========================================
package com.dcbf.apigateway.config;

import com.dcbf.apigateway.client.AuthClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;


@Configuration
public class WebClientConfig {

    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;

    @Bean
    public WebClient employeeWebClient(){
        return WebClient.builder()
                .baseUrl("http://employee-service")     //web client responsible for load balancing as well
                .filter(filterFunction)
                .build();
    }

    @Bean
    public AuthClient employeeClient(){
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(employeeWebClient()))
                .build();
        return httpServiceProxyFactory.createClient(AuthClient.class);
    }
}

//3. ========================================= client/AuthClient.java =========================================
package com.dcbf.apigateway.client;

import com.dcbf.apigateway.payload.AuthRequest;
import com.dcbf.apigateway.payload.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface AuthClient {
    @PostMapping("/authenticate")
    ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request);
}

