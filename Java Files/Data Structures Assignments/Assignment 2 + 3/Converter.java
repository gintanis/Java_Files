import java.util.Stack;

public class Converter 
{
    /*
        convert the input STRING from INFIX into a POSTFIX expression
            use either Array Stack or the Linked Stack 

            infix: expression in which the operator is 
            in between every pair of operands.
                a + b - c

    
            postfix: expression in which the operator is AFTER 
            each pair of operands
                ab+c-

            Ex: 

                input: ((a + b) - c)
                
                output: ab+c-


            * Input String gets saved as an instance variable 
                *  toPostFix()


            * collect user input 
            * "tokenize" each operand and operator into a list of tokens 
            * stack is used to convert to a postfix expression 
            * Algorithm 
                * if character c = operand (numbers), append it to the 
                * end of the OUTPUT string 

                * if character c = operator (+, -, / , *)
                    PEAK at the top of the stack to make sure the 
                        operator has a lower precedence 
                        
                        Higher: PUSH it onto the stack 
                        
                        Lower: POP the operator out of the stack 
                            and append to String

                * When theres an open parenthesis, always add it to the stack. 
                * When there's a closed parenthesis pop out all the operators 
                

    */









    public Converter(){}


    

    //create a stack for operands 

   // int MAX = 100; 
    //int size = -1; 
   // public String [] operandArr = new String[MAX]; 
    


    /*
    public void push(String operand) { operandArr[++size] = operand; }
    public String pop() {return operandArr[size--];}
    public String peek() {return operandArr[size];}

*/
    boolean isNumber (String s)
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
   
    public int caseSwitch(String x)
    {
        switch (x)
        {
  
            case "^":
                return 3; 
            case "*":
            case "/":
                return 2; 
            case "+": 
            case "-":
                return 1; 
            case " ( ":
            case " ) ":
                return 0; 

                
        }

        return -1; 
    }

    public String toPostFix(String equation)
    {
        Stack <String> stk = new Stack<>(); 
        ParserHelper parserHelper = new ParserHelper();

         
        char[] input = equation.toCharArray();  
        String toPostFixString = ""; 
        //int pL = 0;
        //int pR = 0; 
        
      
    
       // System.out.println(parserHelper.parse(input));

        String[] parsed = new String[parserHelper.parse(input).size()];

        int index = 0; 
        for(String s: parserHelper.parse(input))
        {
            parsed[index] = s;
            index++;

        }


       
        for (int i = 0; i < parsed.length; i++)
        {
            String s = parsed[i];

           // System.out.println(stk); 
     
            

            
            if(isNumber(s))
            {toPostFixString += s;}
  
            else if ( s.equals("(")) 
            {  
                //pL++; 
               
                stk.push(s); 
            }


            else if (caseSwitch(s) >= 1)
            {

                while (!stk.isEmpty() &&  !stk.peek().equals("(") && caseSwitch(stk.peek()) >= caseSwitch(s))
                {
                   
                    toPostFixString += stk.pop(); 
                    
                }

                stk.push(s); 
            }

            
            else if (s.equals(")"))
            {
                //pR++; 
                //countP --; 
                while (!stk.isEmpty())
                {
                    if (!stk.peek().equals("("))
                    {
                        toPostFixString += stk.pop();
                         
         
                        
                    }
                    else
                    {
                        stk.pop(); 
                        break; 
                    }
                }

            }
  
        }
        
        while (!stk.isEmpty())
        {
            toPostFixString += stk.pop();
        }

        System.out.println(toPostFixString);
        return toPostFixString;  
        
    }

  







}