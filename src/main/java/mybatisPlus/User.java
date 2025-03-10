package mybatisPlus;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import lombok.Data;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import javax.management.Query;
import java.io.Serializable;
import java.util.Date;

/**
 * @author liweihua
 * @classname User
 * @description TODO
 * @date 2023/6/19 8:54
 */
@Data
public class User implements Serializable {
    @TableId(type = IdType.AUTO)
    private long id;
    private String name;
    private int age;
    private String email;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableLogic
    private Integer sfyx;

}
