package day4;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class RearrangeArray {

    @Test
    public void example()
    {
        int input[]={10,20,23,12,89,34,45};
        Assert.assertEquals(shuffleArray(input),new int[]{10,89,12,45,20,34,23});
    }

    private int[] shuffleArray(int[] input) {

        int left=0,right=input.length-1;
        int output[]= new int[input.length];
        Arrays.sort(input); //10,12,20,23,34,45,89
        int i=0;
        while(left <right)
        {
            output[i]=input[left++];
            output[i+1]=input[right--];
            i=i+2;
        }
        output[output.length-1]=input[right]; //add last element
        System.out.println(Arrays.toString(output));
        return  output;
    }

}
