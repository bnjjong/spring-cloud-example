/*
 * Created By dogfootmaster@gmail.com on 2022
 * This program is free software
 *
 * @author <a href=“mailto:dogfootmaster@gmail.com“>Jongsang Han</a>
 * @since 2022/01/16
 */

package com.jjong.cloud.client.repository;

import com.jjong.cloud.client.domain.User;
import java.util.List;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

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
@Repository
@Slf4j
@RequiredArgsConstructor
public class UserRepository {

  private final EntityManager em;

  public User save(User user) {
    em.persist(user);
    return user;
  }

  public User findByUserId(String userId) {
    return em.createQuery("select u from User u where u.userId = :userId", User.class)
        .setParameter("userId", userId)
        .getSingleResult();
  }

  public List<User> findAll() {
    return em.createQuery("select u from User u", User.class)
        .getResultList();
  }

}
