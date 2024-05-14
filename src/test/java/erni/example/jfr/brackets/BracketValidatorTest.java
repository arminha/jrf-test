package erni.example.jfr.brackets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BracketValidatorTest {

    BracketValidator testee;

    @BeforeEach
    void setup() {
        testee = new BracketValidator();
    }

    @Test
    void stringsWithoutBracketsAreValid() {
        assertTrue(testee.isValid(""));
        assertTrue(testee.isValid("abc"));
    }

    @Test
    void singleOpenBracketsAreNotValid() {
        assertFalse(testee.isValid("("));
        assertFalse(testee.isValid("{"));
        assertFalse(testee.isValid("["));
    }

    @Test
    void singleClosingBracketsAreNotValid() {
        assertFalse(testee.isValid(")"));
        assertFalse(testee.isValid("}"));
        assertFalse(testee.isValid("]"));
    }

    @Test
    void singleClosedBracketsAreValid() {
        assertTrue(testee.isValid("()"));
        assertTrue(testee.isValid("{}"));
        assertTrue(testee.isValid("[]"));
    }

    @Test
    void singleNonMatchingBracketsAreNotValid() {
        assertFalse(testee.isValid("(]"));
        assertFalse(testee.isValid("{)"));
        assertFalse(testee.isValid("[}"));
    }

    @Test
    void nestedBalancedBracketsAreValid() {
        assertTrue(testee.isValid("([{}])"));
        assertTrue(testee.isValid("({}[])"));
    }

    @Test
    void nestedUnbalancedBracketsAreNotValid() {
        assertFalse(testee.isValid("([{}]))"));
    }
}
