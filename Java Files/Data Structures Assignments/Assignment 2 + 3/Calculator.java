import java.util.Stack;


import javax.script.ScriptException;
public class Calculator {
    /* 
        will evaluate the postfix expression 
            Use either Array Stack or the Linked Stack


            * will instantiate an object of the Converter class
            * additional operator " ^ " will be used for exponents 
            * 

    */

   




    public Calculator (){}

    private boolean isNumber (String s)
    {

        try 
        {
            Integer.parseInt(s); 
        }
        catch (NumberFormatException e)
        {
            return false; 
        }
        return true ; 
    }
    
    public int result (String num1, String op, String num2)
    {

        switch (op){
            case "+":
                return Integer.valueOf(num1) + Integer.valueOf(num2);
            case "-":
                return Integer.valueOf(num1) - Integer.valueOf(num2);
            case "/":
                return Integer.valueOf(num1) / Integer.valueOf(num2);
            case "*":
                return Integer.valueOf(num1) * Integer.valueOf(num2);
            case "%":
                return Integer.valueOf(num1) % Integer.valueOf(num2);
        }
        return 0;
   
    }

    public void postfixExpression( String e) throws ScriptException
    {
       
       

        Stack<String> stk = new Stack<>(); 
        

        ParserHelper parseHelper = new ParserHelper(); 
        Converter converter = new Converter();
        String expression = converter.toPostFix(e); 

        char[] eArray = expression.toCharArray();
        
        String[] parsedExpression = new String[parseHelper.parse(eArray).size()];


        int num = 0; 

        int left = 0; 
        int right = 0; 
       

        String res = "";
       
    
        int index = 0; 
        for(String s: parseHelper.parse(eArray))
        {
            parsedExpression[index] = s;
            index++;
       

            if (isNumber(s))
            {
                stk.push(s); 
            }
            else
            {
                right = Integer.valueOf(stk.pop()); 
                left = Integer.valueOf(stk.pop());; 
                if (s.equals("+"))
                {
                    num = left + right ; 
                   
                }
                else if (s.equals("-"))
                {
                    num = left - right; 
                
                }
                else if (s.equals("/"))
                {
                    num = left / right; 
                   
                }
                else if (s.equals("*"))
                {
                    num = left * right; 
                }

                res = "" + num + ""; 

                stk.push(res); 

                
               // System.out.println(result); 
            }            
            

        }

        System.out.println("Converted to postfix: " + parseHelper.parse(eArray)); 

        
        System.out.println("answer is " + res);



       

    }
    


 
    public static void main (String[] args) throws ScriptException
    {
        Calculator calculator = new Calculator(); 

        String e = "(4+8)^(6-5)/((3-2)*(2+2))";
        calculator.postfixExpression(e) ;
        
     

    }
}
