package model.promotion;

import static constants.ConvenienceErrorMessages.*;

import dto.promotion.PromotionsDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Promotions {

    private final List<Promotion> promotions;

    public Promotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public Promotions(PromotionsDTO promotionsDTO) {
        this.promotions = promotionsDTO.getPromotions().stream()
                .map(promotion -> new Promotion(
                        promotion.getName(),
                        promotion.getBuy(),
                        promotion.getGet(),
                        promotion.getStartDate(),
                        promotion.getEndDate()
                ))
                .collect(Collectors.toList());
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    private Optional<Promotion> getPromotion(String promotionName) {
        return promotions.stream()
                .filter(promotion -> promotion.getName().equals(promotionName))
                .findFirst();
    }

    public Promotion getPromotionByName(String name) {
        return getPromotion(name)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format(PROMOTION_NOT_FOUND.getMessage(), name)
                ));
    }
}
