package day2;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.testng.Assert.assertEquals;

public class SecondLargestElement
{
    @Test
    public void example1_positive()
    {
        int input[]={3,4,1,7,9,23,24};
        assertEquals(23,findSecondElement(input));


    }
    @Test
    public void example2_negative()
    {
        int input[]={};
        assertEquals(0,0);


    }

    @Test
    public void example_edge()
    {
        int input[]={3,3,3,3,3,3};
        assertEquals(3,findSecondElement(input));


    }

    @Test
    public void example_stream()
    {
        int input[]={10,20,40,50,22,45,70,25};
        assertEquals(50,findSecondElement_streams(input));


    }

    @Test
    public void example_noinbuild()
    {
        int input[]={3,3,3,3,3,3};
        assertEquals(findSecondElement_noinbuild(input),3);


    }

    @Test
    public void example_noinbuild2()
    {
        int input[]={10,3,4,5,20,34,2};
        assertEquals(findSecondElement_noinbuild(input),20);


    }


    private int findSecondElement(int[] input) {
        if(input.length>=2) {
            Arrays.sort(input);
            return input[input.length - 2];
        }
        return 0;
    }

    private int findSecondElement_streams(int[] input) {
        Optional<Integer> output= Arrays.stream(input)
                .boxed()
                .sorted((a,b)->b-a)
                .skip(1)
                .findFirst();
        return  output.get();


    }

    private int findSecondElement_noinbuild(int[] input) {
        int largest= Integer.MIN_VALUE;
        int second_largest=Integer.MIN_VALUE;

        for(int i=0;i<input.length;i++)
        {
            if(input[i]>largest)
            {
                second_largest=largest;
                largest=input[i];

            } else if (input[i]>second_largest && input[i]!=largest) {
                second_largest=input[i];
            }
        }
        if (second_largest == Integer.MIN_VALUE) {
            second_largest=input[0];
        }
        return second_largest;
    }

    }
