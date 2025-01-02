package arrays_soln;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesis {

    @Test
    public void example1()
    {
        String input="(()";
        Assert.assertFalse(isValidParanthesis(input));
    }

    @Test
    public void example2()
    {
        String input="([])";
        Assert.assertTrue(isValidParanthesis(input));
    }

    private boolean isValidParanthesis(String input) {

        Map<Character,Character> hmap = new HashMap();
        hmap.put(']','[');
        hmap.put(')','(');
        hmap.put('}','{');

        Stack<Character> stack = new Stack<>();
        for(char c:input.toCharArray())
        {
            if(!hmap.containsKey(c))
            {
                stack.push(c);
            }else
            {
                if(!stack.isEmpty() && stack.peek()==hmap.get(c))
                {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();

    }
}
