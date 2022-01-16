/*
 * Created By dogfootmaster@gmail.com on 2022
 * This program is free software
 *
 * @author <a href=“mailto:dogfootmaster@gmail.com“>Jongsang Han</a>
 * @since 2022/01/16
 */

package com.jjong.cloud.client.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.ToString;

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
@Getter
@ToString
public class UserRequest {

  @NotNull(message = "Name cannot be null.")
  @Size(min = 2, message = "Name not be less than 2 characters.")
  private String name;

  @NotNull(message = "Email cannot be null.")
  @Email(message = "Not a valid Email address.")
  private String email;

  @NotNull(message = "Password cannot be null.")
  @Size(min = 8, message = "Password must be equal or grater than 8 characters.")
  private String password;

}
