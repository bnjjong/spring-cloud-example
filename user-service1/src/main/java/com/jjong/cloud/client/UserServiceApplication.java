/*
 * Created By dogfootmaster@gmail.com on 2021
 * This program is free software
 *
 * @author <a href=“mailto:dogfootmaster@gmail.com“>Jongsang Han</a>
 * @since 2021/12/30
 */

package com.jjong.cloud.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * create on 2021/12/30. create by IntelliJ IDEA.
 *
 * <p> 클래스 설명 </p>
 * <p> {@link } and {@link }관련 클래스 </p>
 * gradle 로 실행 하기
 * <pre>
 * ./gradlew bootRun --args='--server.port=9003'
 * java -jar -Dserver.port=9004 ./build/libs/userservice-0.0.1-SNAPSHOT.jar
 * </pre>
 * @author Jongsang Han
 * @version 1.0
 * @see
 * @since 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserServiceApplication.class, args);
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
