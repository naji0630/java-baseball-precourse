package baseball.model;

public enum CommandType {

    CONTINUE("1"),
    EXIT("2");

    String val;

    CommandType(String val) {
        this.val = val;
    }

    /**
     * 명령어 파싱 함수
     *
     * @param str 명령어로 입력된 문자열
     * @return 명령 타입으로 변환된 값
     */
    public static CommandType parse(String str) {
        if (CONTINUE.val.equals(str)) {
            return CONTINUE;
        }
        if (EXIT.val.equals(str)) {
            return EXIT;
        }
        throw new IllegalArgumentException();
    }
}
