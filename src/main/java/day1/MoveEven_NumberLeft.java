package day1;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveEven_NumberLeft {

    @Test
    public void example()
    {
        int input[]={3,5,7,9,2,4,6};
        Assert.assertEquals(moveLeft(input), new int[]{2, 4, 6, 3, 5, 7, 9});

    }

    @Test
    public void example2()
    {
        int input[]={3,5,7,9,2,4,6};
        Assert.assertEquals(moveleft_optimise(input), new int[]{2, 4, 6, 9,3, 5, 7});

    }

    private int[] moveLeft(int[] input) {
        List<Integer> li_even = new ArrayList<>();
        List<Integer> li_odd = new ArrayList<>();

        for(int i=0;i<input.length;i++)
        {
            if(isEven(input[i]))
            {
              li_even.add(input[i]);
            }else {
                li_odd.add(input[i]);
            }

        }

        li_even.addAll(li_odd);
        int[] output = new int[input.length];
        for(int i=0;i<li_even.size();i++)
        {
            output[i]=li_even.get(i);
        }
        return  output;
    }

    public  boolean isEven(int num)
    {
        if(num%2 == 0)
            return  true;
        return false;
    }

    public int[] moveleft_optimise(int[] input)
    {
        //3,5,7,9,2,4,6
        int j=0;
        for(int i=0;i<input.length;i++)
        {
            if(isEven(input[i]))
            {
                if(i!=j)
                {
                    int temp = input[i];
                    input[i]=input[j];
                    input[j]=temp;
                }
                ++j;
            }

        }
 System.out.println(Arrays.toString(input));
      return  input;
    }

}
