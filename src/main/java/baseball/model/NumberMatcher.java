package baseball.model;

import java.util.HashSet;
import java.util.Set;

public class NumberMatcher {

    private final int length;

    /**
     * 숫자 매칭 내부 생성자
     *
     * @param length 매칭하고자 하는 숫자의 길이
     */
    private NumberMatcher(int length) {
        this.length = length;
    }

    /**
     * 숫자 매칭 객체 생성 함수
     *
     * @param length 매칭하고자 하는 숫자의 길이
     * @return 생성된 NumberMatcher 객체
     */
    static public NumberMatcher of(int length) {
        return new NumberMatcher(length);
    }

    /**
     * 숫자 매칭 함수
     *
     * @param answer 정답 숫자
     * @param prediction 예상 숫자
     * @return strike와 ball 결과가 담긴 NumberMatchResult 객체
     */
    public NumberMatchResult match(String answer, String prediction) {
        int strike = getStrike(answer, prediction);
        int ball = getBall(getSharedCharacterCount(answer, prediction), strike);
        return NumberMatchResult.of(strike, ball, length);
    }

    /**
     * 두 수가 공유하는 숫자의 갯수를 반환하는 함수
     *
     * @param str1 비교하고자 하는 숫자1
     * @param str2 비교하고자 하는 숫자2
     * @return str1, str2가 공유하는 숫자의 갯수
     */
    int getSharedCharacterCount(String str1, String str2) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            set.add(str1.charAt(i));
            set.add(str2.charAt(i));
        }
        return str1.length() + str2.length() - set.size();
    }

    /**
     * ball의 갯수를 반환하는 함수
     *
     * @param sharedCharacterCount 두 수가 공유하는 숫자의 갯수
     * @param strike 두 수의 strike 갯수
     * @return 두 수의 ball 갯수
     */
    int getBall(int sharedCharacterCount, int strike) {
        return sharedCharacterCount - strike;
    }

    /**
     * 두 수의 같은 자리의 같은 수가 있는 경우의 수를 반환하는 함수
     *
     * @param str1 비교하고자 하는 숫자1
     * @param str2 비교하고자 하는 숫자2
     * @return 두 수의 위치와 값이 모두 동일한 숫자의 갯수
     */
    int getSameSiteSameValueCount(String str1, String str2) {
        int count = 0;
        int minLength = Math.min(str1.length(), str2.length());
        for (int i = 0; i < minLength; i++) {
            count += isSameAsNumber(str1.charAt(i), str2.charAt(i));
        }
        return count;
    }

    /**
     * 두 수의 strike 갯수를 반환하는 함수
     *
     * @param answer 정답
     * @param prediction 예측
     * @return 두 수의 strike 갯수
     */
    int getStrike(String answer, String prediction) {
        return getSameSiteSameValueCount(answer, prediction);
    }

    /**
     * 두 문자가 동일한지 숫자로 반환하는 함수
     *
     * @param ch1 비교하고자 하는 문자1
     * @param ch2 비교하고자 하는 문자2
     * @return 두 수가 동일한지 판단 결과(같음 = 1, 다름 = 0)
     */
    int isSameAsNumber(Character ch1, Character ch2) {
        if (ch1 == ch2) {
            return 1;
        }
        return 0;
    }
}
