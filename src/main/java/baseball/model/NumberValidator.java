package baseball.model;

import java.util.HashSet;
import java.util.Set;

public class NumberValidator {

    private final int length;

    private NumberValidator(int length) {
        this.length = length;
    }

    static public NumberValidator of(int length) {
        return new NumberValidator(length);
    }

    public void validatePrediction(String target) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < target.length(); i++) {
            set.add(target.charAt(i));
        }
        if (target.length() != length || set.size() != length) {
            throw new IllegalArgumentException();
        }
    }
}
