package resultWrapper;

/**
 * @author liweihua
 * @classname ResultCode
 * @description TODO
 * @date 2023/6/9 14:53
 */
public enum ResultCode {
    SUCCESS(1000, "访问成功"),
    SYSTEM_FAILURE(1001, "系统异常"),
    ;

    private final int code;
    private final String description;

    ResultCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
