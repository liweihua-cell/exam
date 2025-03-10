package order.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author liweihua
 * @classname Order
 * @description TODO
 * @date 2023/6/7 15:04
 */
@Data
public class Order {
    private Long id;
    private Long userId;
    private LocalDateTime createTime;
}
