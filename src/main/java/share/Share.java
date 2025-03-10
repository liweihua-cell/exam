package share;

/**
 * @author liweihua
 * @classname Share
 * @description TODO
 * @date 2023/11/14 10:40
 */
public interface Share {

    /**
     * 获取分享类型
     *
     * @return Integer枚举code
     */
    String getShareFunctionType();

    /**
     * @param shareName
     * @return
     */
    String mainProcess(String shareName);
}
