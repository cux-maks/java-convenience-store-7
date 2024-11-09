package util.parser;

import dto.promotion.PromotionsDTO;
import dto.promotion.PromotionDTO;

import util.validator.PromotionValidator;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PromotionsParser {
    public static PromotionsDTO parsePromotions(List<String> promotionsFromFile) {
        promotionsFromFile.forEach(PromotionValidator::validateFiveLength);

        List<PromotionDTO> promotions = promotionsFromFile.stream()
                .map(line -> line.split(","))
                .peek(PromotionsParser::validateParts)
                .map(PromotionsParser::createPromotionDTO)
                .collect(Collectors.toList());

        return new PromotionsDTO(promotions);
    }

    private static void validateParts(String[] parts) {
        PromotionValidator.isNumber(parts[1]);
        PromotionValidator.isNumber(parts[2]);
        PromotionValidator.isDate(parts[3]);
        PromotionValidator.isDate(parts[4]);
    }

    private static PromotionDTO createPromotionDTO(String[] parts) {
        return new PromotionDTO(
                parts[0],
                Integer.parseInt(parts[1]),
                Integer.parseInt(parts[2]),
                LocalDate.parse(parts[3]),
                LocalDate.parse(parts[4])
        );
    }
}
