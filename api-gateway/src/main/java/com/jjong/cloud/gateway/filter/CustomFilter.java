/*
 * Created By dogfootmaster@gmail.com on 2021
 * This program is free software
 *
 * @author <a href=“mailto:dogfootmaster@gmail.com“>Jongsang Han</a>
 * @since 2021/12/29
 */

package com.jjong.cloud.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

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
@Component
@Slf4j
public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config> {

  public CustomFilter() {
    super(Config.class);
  }

  @Override
  public GatewayFilter apply(Config config) {
    return ((exchange, chain) -> {
      ServerHttpRequest request = exchange.getRequest();
      ServerHttpResponse response = exchange.getResponse();

      log.info("Custom PRE filter : request id -> {}", request.getId());

      // Custom Post Filter
      return chain.filter(exchange).then(Mono.fromRunnable(() -> {
        log.info("Custom Post filter : response code -> {}", response.getStatusCode());
      }));
    });
  }

  public static class Config {

  }

}
