/*
 * Created By dogfootmaster@gmail.com on 2021
 * This program is free software
 *
 * @author <a href=“mailto:dogfootmaster@gmail.com“>Jongsang Han</a>
 * @since 2021/12/29
 */

package com.jjong.cloud.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

/**
 * create on 2021/12/29. create by IntelliJ IDEA.
 *
 * <p> 클래스 설명 </p>
 * <p> {@link } and {@link }관련 클래스 </p>
 *
 * @author Jongsang Han
 * @version 1.0
 * @see
 * @since 1.0
 */
//@Configuration
public class FilterConfig {

//  @Bean
  public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
    return builder.routes()
        .route(r -> r.path("/first-service/**")
            .filters(f -> f.addRequestHeader("first-request","first-request-header")
                            .addResponseHeader("first-response", "first-response-header"))
            .uri("http://localhost:8081"))
        .route(r -> r.path("/second-service/**")
            .filters(f -> f.addRequestHeader("second-request","second-request-header")
                .addResponseHeader("second-response", "second-response-header"))
            .uri("http://localhost:8082"))
        .build();
  }
}
