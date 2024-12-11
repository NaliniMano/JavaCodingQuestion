package day5;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.desktop.PreferencesEvent;
import java.util.Arrays;

public class RotateArray_RightShift {

    @Test
    public void example()
    {
        int input[]={1,2,3,4,5,6,7};
        int index=3;
        Assert.assertEquals(rotateArray(input,index),new int[]{5,6,7,1,2,3,4});
    }

    @Test
    public void example2()
    {
        int input[]={1,2,3,4,5,6,7};
        int index=2;
        Assert.assertEquals(rotateArray(input,index),new int[]{6,7,1,2,3,4,5});
    }

    private int[] rotateArray(int[] input,int n) {

        n=n%(input.length); //  handle n > length of array

        reverseArr(input,0,input.length-1);
        reverseArr(input,0,n-1);
        reverseArr(input,n,input.length-1);


        return input;
    }

    private void reverseArr(int[] input, int left, int right) {
        while(left < right)
        {
            int temp =input[left];
            input[left++]=input[right];
            input[right--]=temp;

        }
        System.out.println(Arrays.toString(input));
    }


}
