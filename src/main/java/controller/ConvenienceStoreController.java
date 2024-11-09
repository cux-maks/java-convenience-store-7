package controller;

import dto.promotion.PromotionsDTO;
import model.promotion.Promotion;
import model.promotion.Promotions;

import dao.PromotionsDAO;

public class ConvenienceStoreController {
    private Promotions promotions;

    public void run() {

        loadFiles();

        for (Promotion promotion : this.promotions.getPromotions()) {
            System.out.println(promotion.getName());
            System.out.println(promotion.getBuy());
            System.out.println(promotion.getGet());
            System.out.println(promotion.getStartDate());
            System.out.println(promotion.getEndDate());
        }
    }

    private void loadFiles() {
        PromotionsDTO loadedPromotions = PromotionsDAO.getPromotionsFromFile("src/main/resources/promotions.md");
        this.promotions = new Promotions(loadedPromotions);
    }
}
