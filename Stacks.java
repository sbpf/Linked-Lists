import java.util.*;
public class Stacks {

	/*Leetcode 32. Longest Valid Parentheses
	 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

		Example 1:
		
		Input: "(()"
		Output: 2
		Explanation: The longest valid parentheses substring is "()"
	 */
	
	public static int validMaximumBalancedParanthesesSubStr(String parantheses)
	{
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int max_length = 0;
        for(int i=0; i<parantheses.length(); i++)
        {
            char current = parantheses.charAt(i);
            if(current == '(')
            {
            	stack.push(i);
            }
            else
            {
               stack.pop();
                if(stack.isEmpty())
                {
                  stack.push(i);
                }
                else
                max_length = Math.max(max_length,i-stack.peek());
            }
        }
        return max_length;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Parantheses: ");
		String parantheses = "(())((()))()()";
		System.out.println(validMaximumBalancedParanthesesSubStr(parantheses));
	}

}
