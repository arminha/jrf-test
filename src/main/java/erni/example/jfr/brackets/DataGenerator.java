package erni.example.jfr.brackets;

import java.util.Random;

public class DataGenerator {

    public String createValidBrackets(int length, double depthFactor) {
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        int remainingClosingBrackets = 0;
        while (sb.length() + remainingClosingBrackets < length) {
            boolean add = random.nextDouble() * (sb.length() + remainingClosingBrackets) / length < depthFactor;
            if (add) {
                remainingClosingBrackets++;
                sb.append('(');
            } else {
                remainingClosingBrackets--;
                sb.append(')');
            }
        }
        while (remainingClosingBrackets > 0) {
            remainingClosingBrackets--;
            sb.append(')');
        }
        return sb.toString();
    }

}
