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
import java.util.List;
import org.w3c.dom.stylesheets.LinkStyle;

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
public interface UserService {

  User save(UserRequest userRequest);

  User findByUserId(String userId);

  List<User> findAll();

}
