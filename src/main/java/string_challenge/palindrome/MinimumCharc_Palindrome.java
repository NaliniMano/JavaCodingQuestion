package string_challenge.palindrome;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MinimumCharc_Palindrome {

    @Test
    public void example1()
    {
        String input="abcd";
        Assert.assertEquals(minChartoMakePalindrome(input),3);

    }

    @Test
    public void example2()
    {
        String input="aaaa";
        Assert.assertEquals(minChartoMakePalindrome(input),0);

    }


    @Test
    public void example3()
    {
        String input="abaa";
        Assert.assertEquals(minChartoMakePalindrome(input),1);

    }

    private int minChartoMakePalindrome(String input) {

        int end=input.length()-1;
        int n=input.length();
        while(end >=0)
        {
            if(isPalindrome(input,0,end)){
                break;
            }
            end--;


        }
        return  n-end-1;
    }

    private boolean isPalindrome(String input, int start, int end) {
        while(start < end)
        {
            if(input.charAt(start) != input.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return  true;

    }
}
