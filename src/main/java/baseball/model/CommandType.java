package baseball.model;

public enum CommandType {

    CONTINUE("1"),
    EXIT("2");

    String val;

    CommandType(String val) {
        this.val = val;
    }

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
