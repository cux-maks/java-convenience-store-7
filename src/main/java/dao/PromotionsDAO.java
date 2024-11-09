package dao;

import dto.promotion.PromotionsDTO;

import util.loader.FileLoader;
import util.parser.PromotionsParser;

import java.util.List;

public class PromotionsDAO {

    public static PromotionsDTO getPromotionsFromFile(String filePath) {

        List<String> lines = FileLoader.loadDataFromFile(filePath);
        return PromotionsParser.parsePromotions(lines);

    }
}
