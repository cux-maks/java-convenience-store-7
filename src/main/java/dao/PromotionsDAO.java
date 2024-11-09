package dao;

import dto.promotion.PromotionsDTO;

import util.loader.PromotionFileLoader;
import util.parser.PromotionsParser;

import java.util.List;

public class PromotionsDAO {
    private static final PromotionFileLoader promotionFileLoader = new PromotionFileLoader();

    public static PromotionsDTO getPromotionsFromFile(String filePath) {

        List<String> lines = promotionFileLoader.loadDataFromFile(filePath);
        return PromotionsParser.parsePromotions(lines);

    }
}
