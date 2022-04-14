package baseball.model;

import java.util.HashSet;
import java.util.Set;

public class NumberMatcher {

    private final int length;

    private NumberMatcher(int length) {
        this.length = length;
    }

    static public NumberMatcher of(int length) {
        return new NumberMatcher(length);
    }

    public NumberMatchResult match(String answer, String prediction) {
        int strike = getStrike(answer, prediction);
        int ball = getBall(getSharedCharacterCount(answer, prediction), strike);
        return NumberMatchResult.of(strike, ball, length);
    }

    int getSharedCharacterCount(String str1, String str2) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            set.add(str1.charAt(i));
            set.add(str2.charAt(i));
        }
        return str1.length() + str2.length() - set.size();
    }

    int getBall(int sharedCharacterCount, int strike) {
        return sharedCharacterCount - strike;
    }

    int getSameSiteSameValueCount(String str1, String str2) {
        int count = 0;
        int minLength = Math.min(str1.length(), str2.length());
        for (int i = 0; i < minLength; i++) {
            count += isSameAsNumber(str1.charAt(i), str2.charAt(i));
        }
        return count;
    }

    int getStrike(String answer, String prediction) {
        return getSameSiteSameValueCount(answer, prediction);
    }

    int isSameAsNumber(Character ch1, Character ch2) {
        if (ch1 == ch2) {
            return 1;
        }
        return 0;
    }
}
