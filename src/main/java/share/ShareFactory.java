package share;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liweihua
 * @classname ShareFactory
 * @description TODO
 * @date 2023/11/14 10:42
 */
@Component
public class ShareFactory {
    @Autowired
    private List<Share> shareFunctionList;

    /**
     * 根据分享类型获取对应的分享处理方式
     *
     * @param type
     * @return
     */
    public Share getShareFunction(String type) {
        for (Share shareFunction : shareFunctionList) {
            if (shareFunction.getShareFunctionType().equals(type)) {
                return shareFunction;
            }
        }
        return null;
    }

    public enum EnumShareType {
        SUCCESS_ORDER("successOrder");
        private String name;

        EnumShareType(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return super.toString();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
