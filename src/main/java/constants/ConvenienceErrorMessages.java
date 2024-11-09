package constants;

public enum ConvenienceErrorMessages {
    PROMOTION_NOT_FOUND("해당 프로모션이 존재하지 않습니다. (%s)"),
    FILE_NOT_FOUND("파일을 읽어올 수 없습니다. (%s)"),
    PROMOTION_NAME_NOT_NULL("프로모션의 이름은 공백이 될 수 없습니다."),
    BUY_AT_LEAST_ONE_ITEM("구매 수량은 1 이상이어야 합니다. (%d)"),
    GET_AT_LEAST_ONE_ITEM("수령 수량은 1 이상이어야 합니다. (%d)"),
    PROMOTION_START_DATE_NOT_NULL("프로모션 시작 날짜는 공백이 될 수 없습니다."),
    PROMOTION_END_DATE_NOT_NULL("프로모션 종료 날짜는 공백이 될 수 없습니다."),
    IS_NOT_A_NUMBER("숫자가 아닙니다. (%s)"),
    INVALID_DATE_FORMAT("날짜 형식이 올바르지 않습니다. (%s)"),
    INVALID_LENGTH_EXCEPTION("입력 길이가 올바르지 않습니다. (%s)");

    private static final String ERROR_PREFIX = "[ERROR]";
    private final String message;

    ConvenienceErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}