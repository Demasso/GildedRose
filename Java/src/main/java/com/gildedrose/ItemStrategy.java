package com.gildedrose;

public interface ItemStrategy {
    /**
     * Updates the item's quality and sellIn based on the rules for this strategy.
     * @param item The item to update.
     */
    void update(Item item);
}