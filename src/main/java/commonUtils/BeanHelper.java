package commonUtils;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liweihua
 * @classname BeanHelper
 * @description TODO
 * @date 2023/6/9 15:13
 */
public class BeanHelper {
    /**
     * 浅拷贝
     */
    public static <T> T copy(Object source, Class<T> target) {
        if (source == null) {
            return null;
        }
        T t;
        try {
            t = target.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        BeanUtils.copyProperties(source, t);
        return t;
    }

    /**
     * 浅拷贝
     */
    public static <T> List<T> copy(List<?> sources, Class<T> target) {
        if (CollectionUtils.isEmpty(sources)) {
            return new ArrayList<>();
        }
        List<T> targets = new LinkedList<>();
        for (Object source : sources) {
            T t = null;
            try {
                t = target.newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            BeanUtils.copyProperties(source, t);
            targets.add(t);
        }
        return targets;
    }

}
