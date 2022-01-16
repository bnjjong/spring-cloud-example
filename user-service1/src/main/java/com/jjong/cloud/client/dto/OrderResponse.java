/*
 * Created By dogfootmaster@gmail.com on 2022
 * This program is free software
 *
 * @author <a href=“mailto:dogfootmaster@gmail.com“>Jongsang Han</a>
 * @since 2022/01/17
 */

package com.jjong.cloud.client.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * create on 2022/01/17. create by IntelliJ IDEA.
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
@Setter
@NoArgsConstructor
@ToString
public class OrderResponse {

  private String productId;
  private Integer quantity;
  private Integer unitPrice;
  private Integer totalPrice;
  private LocalDateTime createdAt;

  private String orderId;

}
