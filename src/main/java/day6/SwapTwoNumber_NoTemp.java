package day6;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SwapTwoNumber_NoTemp {

    @Test
    public void example()
    {
        int num1=10,num2=20;
        Assert.assertEquals(swapNum(num1,num2),"20,10");
    }

    private String swapNum(int num1, int num2) {
        num1=num1+num2;
        num2=num1-num2;
        num1=num1-num2;

        String output="";
        output=num1+","+num2;
        return output;
    }
}
