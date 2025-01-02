package arrays_soln;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class MissingElement_SortedArray {

    @Test
    public void example1()
    {
        int[] input={1, 2, 3, 4, 7, 8, 10};
        findMissingElement(input);
    }

    @Test
    public void example2()
    {
        int[] input={};
        findMissingElement(input);
    }

    private void findMissingElement(int[] input) {

        if(input.length < 1)
        {
            System.out.println("0");

        }else {
            Set<Integer> hset = new HashSet<>();
            int n = input[input.length - 1];

            for (int i : input) {
                hset.add(i);
            }
            for (int j = 1; j <= n; j++) {
                if (!hset.contains(j))
                    System.out.println(j);
            }
        }
    }
}
