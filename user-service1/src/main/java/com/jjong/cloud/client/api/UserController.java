/*
 * Created By dogfootmaster@gmail.com on 2022
 * This program is free software
 *
 * @author <a href=“mailto:dogfootmaster@gmail.com“>Jongsang Han</a>
 * @since 2022/01/15
 */

package com.jjong.cloud.client.api;

import com.jjong.cloud.client.domain.User;
import com.jjong.cloud.client.dto.UserRequest;
import com.jjong.cloud.client.dto.UserResponse;
import com.jjong.cloud.client.service.UserService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create on 2022/01/15. create by IntelliJ IDEA.
 *
 * <p> 클래스 설명 </p>
 * <p> {@link } and {@link }관련 클래스 </p>
 *
 * @author Jongsang Han
 * @version 1.0
 * @see
 * @since 1.0
 */
@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class UserController {

  private final Environment env;
  private final UserService userService;

  @GetMapping("health-check")
  public String status() {
    return String.format("Is's working in user service on port %s",
        env.getProperty("local.server.port"));
  }

  @GetMapping("welcome")
  public String welcome() {
    return env.getProperty("greeting.message");
  }

  @PostMapping("/user")
  public ResponseEntity create(@RequestBody UserRequest userRequest) {
    User user = userService.save(userRequest);
    ModelMapper mapper = new ModelMapper();
    mapper.getConfiguration().setMatchingStrategy(
        MatchingStrategies.STRICT);

    UserResponse response = mapper.map(user, UserResponse.class);

    return ResponseEntity.status(HttpStatus.CREATED).body(response);

  }

  @GetMapping("/users")
  public ResponseEntity<List<UserResponse>> getAll() {
    List<User> users = userService.findAll();
    List<UserResponse> result = new ArrayList<>();
    users.forEach(u -> {
      result.add(new ModelMapper().map(u, UserResponse.class));
    });

    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  @GetMapping("/user/{userId}")
  public ResponseEntity getByUserId(@PathVariable("userId") String userId) {
    User user = userService.findByUserId(userId);
    UserResponse userResponse = new ModelMapper().map(user, UserResponse.class);

    return ResponseEntity.status(HttpStatus.OK).body(userResponse);
  }


}
