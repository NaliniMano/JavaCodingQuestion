package arrays_soln;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class DeleteLastOccuranceOfChar {
    @Test
    public void example1()
    {
        int[] input={1, 2, 3, 4, 1, 2, 3, 4, 5, 6, 2, 4, 2, 5};
        int num=2;
        Assert.assertEquals(deleteLastOccurance(input,num),
                new int[]{1, 2, 3, 4, 1, 2, 3, 4, 5, 6, 2, 4,5});
    }

    @Test
    public void example2()
    {
        int[] input={1, 2, 3, 4, 1, 2, 3, 4, 5, 6, 2, 4, 2, 5};
        int num=9;
        Assert.assertEquals(deleteLastOccurance(input,num),
                new int[]{1, 2, 3, 4, 1, 2, 3, 4, 5, 6, 2, 4,2,5});
    }

    private int[] deleteLastOccurance(int[] input, int num) {

        // find last occurance
        int last_index=-1;
        for(int i =0;i<input.length;i++)
        {
            if(input[i] == num)
            {
                last_index=i;
            }
        }

        if(last_index == -1)
        {
            return  input;
        }

        int[] output= new int[input.length-1];
        int index=0;
        for(int j=0;j<input.length;j++)
        {
            if(j!=last_index)
            {
                output[index++]=input[j];
            }
        }
        System.out.println(Arrays.toString(output));
        return  output;
    }
}
