package arrays_soln;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayIntersection {

    @Test
    public void example1()
    {
        int[] input1={4,9,5};
        int[] input2={4,7,8,5,2};
        Assert.assertEquals(findArrayInter(input1,input2),new int[]{4,5});
    }

    @Test
    public void example2()
    {
        int[] input1={9};
        int[] input2={4,7,8,5,2};
        Assert.assertEquals(findArrayInter(input1,input2),new int[]{});
    }

    @Test
    public void example3()
    {
        int[] input1={};
        int[] input2={4,7,8,5,2};
        Assert.assertEquals(findArrayInter(input1,input2),new int[]{});
    }

    private int[] findArrayInter(int[] input1, int[] input2) {
        List<Integer> list1= new ArrayList<>();
        List<Integer> output= new ArrayList<>();
        for(int num :input1)
        {
            list1.add(num);

        }

        for(int num2:input2)
        {
            if(list1.contains(num2))
            {
                output.add(num2);
            }
        }

        int[] result = new int[output.size()];
        for(int i=0;i<result.length;i++)
        {
            result[i]=output.get(i);
        }
        return  result;
    }
}
