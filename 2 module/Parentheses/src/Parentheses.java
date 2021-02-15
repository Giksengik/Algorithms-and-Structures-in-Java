import java.util.Stack;

public class Parentheses {
    private static boolean isTheSameBracket(Stack<Character> operations, char operation){
        switch (operations.firstElement()){
            case ')':
                if (operation == '(')
                    return true;
            case '}':
                if (operation == '{')
                    return true;
            case ']':
                if (operation == '[')
                    return true;
        }
        return false;
    }
    public static boolean isCorrect(String str){
        Stack<Character> operation = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if( operation.empty() || isTheSameBracket(operation, str.charAt(i)))
                operation.push(str.charAt(i));
            else operation.pop();
        }
        return  operation.empty();
    }
}
