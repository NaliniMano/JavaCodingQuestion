package arrays_soln;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MaximumContinuous_Subarray {

    //Kandane_algorithm

    @Test
    public void example1()
    {
        int[] input={-2,1,-3,4,-1,2,1,-5,4};
        Assert.assertEquals(maxSubarray(input),6);

    }

    @Test
    public void example2()
    {
        int[] input={-3,-4,-2,-9};
        Assert.assertEquals(maxSubarray(input),-2);

    }

    private int maxSubarray(int[] input) {

        int sum=0;
        int max= Integer.MIN_VALUE;
        for(int i=0;i<input.length;i++)
        {
            sum+=input[i];
            if(sum < input[i])
                sum=input[i];

            if(max < sum)
                max = sum;
        }
        System.out.println("Max="+max);
        return  max;
    }
}
