package day4;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class InsertElementArray {

    @Test
    public void example()
    {
        int[] input={10,20,30,60,80};
        int index=2;
        int element=45;
        Assert.assertEquals(doInsert(input,index,element),new int[]{10,20,45,30,60,80});
    }

    private int[] doInsert(int[] input, int index, int element) {

        if(input.length <2 )
        {
            return input;
        }
        int[] output=new int[input.length+1];
        for(int i=0,j=0;i<input.length;i++)
        {
            if(i==index)
            {
                output[i]=element;
            }else
            {
                output[i]=input[j++];
            }
        }
        output[output.length-1]=input[input.length-1];
        System.out.println(Arrays.toString(output));
        return  output;
    }
}
