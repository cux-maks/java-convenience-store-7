package util.validator;

import static constants.ConvenienceErrorMessages.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class PromotionValidator {
    public static void validatePromotion(String name, int buy, int get, LocalDate startDate, LocalDate endDate) {
        validateName(name);
        validateBuy(buy);
        validateGet(get);
        validateStartDate(startDate);
        validateEndDate(endDate);
    }

    public static void validateFiveLength(String line) {
        if (line.split(",").length != 5) {
            throw new IllegalArgumentException(
                    String.format(INVALID_LENGTH_EXCEPTION.getMessage(), line)
            );
        }
    }

    private static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(PROMOTION_NAME_NOT_NULL.getMessage());
        }
    }

    private static void validateBuy(int buy) {
        if (buy < 0) {
            throw new IllegalArgumentException(
                    String.format(BUY_AT_LEAST_ONE_ITEM.getMessage(), buy)
            );
        }
    }

    private static void validateGet(int get) {
        if (get < 0) {
            throw new IllegalArgumentException(
                    String.format(GET_AT_LEAST_ONE_ITEM.getMessage(), get)
            );
        }
    }

    private static void validateStartDate(LocalDate startDate) {
        if (startDate == null) {
            throw new IllegalArgumentException(PROMOTION_START_DATE_NOT_NULL.getMessage());
        }
    }

    private static void validateEndDate(LocalDate endDate) {
        if (endDate == null) {
            throw new IllegalArgumentException(PROMOTION_END_DATE_NOT_NULL.getMessage());
        }
    }

    public static void isNumber(String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    String.format(IS_NOT_A_NUMBER.getMessage(), target)
            );
        }
    }

    public static void isDate(String target) {
        try {
            LocalDate.parse(target);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(
                    String.format(INVALID_DATE_FORMAT.getMessage(), target)
            );
        }
    }
}
