import com.backinfile.support.Random;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandTest {
    @Test
    public void test() {
        List<Integer> list = Arrays.asList(100, 200, 50, 25);
        List<Integer> rate = Arrays.asList(4, 8, 2, 1);

        List<Integer> randResult = new ArrayList<>(4);
        randResult.add(0);
        randResult.add(0);
        randResult.add(0);
        randResult.add(0);

        for (int i = 0; i < 100_000_000; i++) {
            int index = Random.getInstance().randWeightIndex(list);
            randResult.set(index, randResult.get(index) + 1);
        }
        System.out.println(randResult);
        for (int i = 0; i < randResult.size(); i++) {
            randResult.set(i, Math.round(randResult.get(i) * 1f / randResult.get(3)));
        }
        assert rate.equals(randResult);
    }

    @RepeatedTest(3)
    public void testBool() {
        int trueCount = 0;
        int falseCount = 0;
        int MAX = 1000000;
        Random random = Random.getInstance();
        for (int i = 0; i < MAX; i++) {
            if (random.nextBool()) {
                trueCount++;
            } else {
                falseCount++;
            }
        }
//        System.out.println(Math.abs(trueCount - falseCount));
        assert Math.abs(trueCount - falseCount) < MAX / 100;
    }
}
