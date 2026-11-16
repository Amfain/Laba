package Labs.lab3_2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RadixSort implements Sorting<BigInteger> {

    @Override
    public void sort(List<BigInteger> nums) {

        if (nums.size() < 2) {
            return;
        }


        List<List<BigInteger>> buckets = new ArrayList<>();

        for (int digit = 0; digit < 10; digit++) {
            buckets.add(new ArrayList<>());
        }


        BigInteger divisor = BigInteger.ONE;


        for (int position = 0; position < 20; position++) {


            for (int digit = 0; digit < 10; digit++) {
                buckets.get(digit).clear();
            }


            for (BigInteger number : nums) {
                int digit = number
                        .divide(divisor)
                        .mod(BigInteger.TEN)
                        .intValue();


                buckets.get(digit).add(number);
            }


            int index = 0;

            for (int digit = 0; digit < 10; digit++) {
                for (BigInteger number : buckets.get(digit)) {
                    nums.set(index, number);
                    index++;
                }
            }


            divisor = divisor.multiply(BigInteger.TEN);
        }
    }
}
