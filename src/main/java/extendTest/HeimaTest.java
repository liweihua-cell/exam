package extendTest;

public class HeimaTest {
    public static void main(String[] args) {
        new Heima();
    }
}

class Heima extends School{
    String name = "黑马程序员";
    public Heima() {
        //调用构造器会自动去调父类方法，此时编译器会将String name = "黑马程序员"拆分成
        //String name 与name = "黑马程序员"两部分。
        //String name是属性声明语句，放在原位置，此时name = null;而name = "黑马程序员"是属性赋值语句，放在构造器中的super之后。
        //JVM遇到new对象时会执行String name。
        //super()执行完后才会执行name = "黑马程序员"进行属性真正赋值。
        //即先打印String name = null再打印super中的"传智教育"，此时super的getName()已执行完毕再执行最接近的Heima类里的getName
        //因此打印顺序为：
        //null
        //传智教育
        //黑马程序员
        //传智教育
        super();
        getName();
    }
    public void getName(){
        System.out.println(name);
        System.out.println(super.name);
    }
}

class School{
    String name = "传智教育";
    public School(){
        super();
        getName();
    }
    public void getName(){
        System.out.println(name);
    }
}
