import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liweihua
 * @classname AssertTest
 * @description TODO
 * @date 2023/8/22 9:58
 */
public class AssertTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int i = 0;
        for (i = 0; i < 5; i++) {
            System.out.println(i);
        }
        //假设程序不小心多了一句--i;
        --i;
        assert i == 5;
    }
}
