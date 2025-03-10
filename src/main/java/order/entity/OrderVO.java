package order.entity;

import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liweihua
 * @classname OrderVO
 * @description TODO
 * @date 2023/6/7 15:05
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderVO extends Order {
    private String userName;
}
