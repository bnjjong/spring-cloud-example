/*
 * Created By dogfootmaster@gmail.com on 2022
 * This program is free software
 *
 * @author <a href=“mailto:dogfootmaster@gmail.com“>Jongsang Han</a>
 * @since 2022/01/16
 */

package com.jjong.cloud.client.service;

import com.jjong.cloud.client.domain.User;
import com.jjong.cloud.client.dto.UserRequest;
import com.jjong.cloud.client.repository.UserRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * create on 2022/01/16. create by IntelliJ IDEA.
 *
 * <p> 클래스 설명 </p>
 * <p> {@link } and {@link }관련 클래스 </p>
 *
 * @author Jongsang Han
 * @version 1.0
 * @see
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{
  private final UserRepository userRepository;
  private final BCryptPasswordEncoder encoder;

  @Override
  @Transactional
  public User save(UserRequest userRequest) {
//    ModelMapper mapper = new ModelMapper();
//    mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//    User user = mapper.map(userRequest, User.class);

    User user = new User(
        userRequest.getEmail(),
        userRequest.getName(),
        UUID.randomUUID().toString(),
        encoder.encode(userRequest.getPassword()));

    return userRepository.save(user);
  }

  @Override
  public User findByUserId(String userId) {
    return userRepository.findByUserId(userId);
  }

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }
}
