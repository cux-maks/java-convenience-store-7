package dto.promotion;

import java.util.List;

public class PromotionsDTO {
    private final List<PromotionDTO> promotions;

    public PromotionsDTO(List<PromotionDTO> promotions) {
        this.promotions = promotions;
    }

    public List<PromotionDTO> getPromotions() {
        return promotions;
    }
}
