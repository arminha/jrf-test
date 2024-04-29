package erni.example.jfr.brackets;

public class BracketValidator {

    public boolean isValid(String s) {
        Stack<Character> openBrackets = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    openBrackets.push(c);
                    break;
                case ')':
                case '}':
                case ']':
                    if (!isMatchingCLosingBracket(c, openBrackets.pop())) {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return openBrackets.isEmpty();
    }

    private boolean isMatchingCLosingBracket(char closingBracket, Character openBracket) {
        return switch (openBracket) {
            case '(' -> closingBracket == ')';
            case '[' -> closingBracket == ']';
            case '{' -> closingBracket == '}';
            case null -> false;
            default -> false;
        };
    }
}
