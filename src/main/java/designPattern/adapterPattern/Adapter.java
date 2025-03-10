package designPattern.adapterPattern;

/**
 * @author liweihua
 * @classname Adapter
 * @description TODO
 * @date 2023/11/6 11:09
 */

// 适配器类，继承了被适配类，同时实现标准接口
class Adapter extends Adaptee implements Target {
    public void request() {
        super.specificRequest();
    }

}
