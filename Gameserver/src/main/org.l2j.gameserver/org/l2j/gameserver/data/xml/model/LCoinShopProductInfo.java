package org.l2j.gameserver.data.xml.model;

import org.l2j.gameserver.model.holders.ItemHolder;

import java.util.List;

public class LCoinShopProductInfo {

    public enum Category {
        Equip,
        Special,
        Supplies,
        Other
    }

    private int id;
    private Category category;
    private int limitPerDay;
    private int minLevel;
    private boolean isEvent;
    private List<ItemHolder> ingredients;
    private ItemHolder production;
    private int remainServerItemAmount;

    public LCoinShopProductInfo(int id, Category category, int limitPerDay, int minLevel, boolean isEvent, List<ItemHolder> ingredients, ItemHolder production, int remainServerItemAmount) {
        this.id = id;
        this.category = category;
        this.limitPerDay = limitPerDay;
        this.minLevel = minLevel;
        this.isEvent = isEvent;
        this.ingredients = ingredients;
        this.production = production;
        this.remainServerItemAmount = remainServerItemAmount;
    }

    public int getId() {
        return id;
    }

    public int getRemainAmount() {
        return limitPerDay; // TODO
    }

    public int getRemainTime() {
        return -1; // TODO
    }

    public int getRemainServerItemAmount() {
        return remainServerItemAmount; // TODO
    }

    public Category getCategory() {
        return category;
    }

    public int getLimitPerDay() {
        return limitPerDay;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public boolean isEvent() {
        return isEvent;
    }

    public List<ItemHolder> getIngredients() {
        return ingredients;
    }

    public ItemHolder getProduction() {
        return production;
    }
}
