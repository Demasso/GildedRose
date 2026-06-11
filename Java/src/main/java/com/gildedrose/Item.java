package com.gildedrose;
// Item class cannot be touched?
public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    void setItem(){
        // Handle by item
        if (name.equals("Aged Brie")) { // Aged Brie
            setQuality(1); // >10 : +1
            if (sellIn < 0) setQuality(1); // quality incrases faster on negative sellIn

        } else if (name.equals("Backstage passes to a TAFKAL80ETC concert")) { // Backstage
            if (sellIn < 0) {
                setQuality(0); // Quality drops to 0 once sellIn reached

            } else{
                setQuality(1); // >10 : +1
                if (sellIn < 10) setQuality(1); // <10 : +2
                if (sellIn <  5) setQuality(1); // < 5 : +3
            }

        } else if (quality > 0) { // normal items
            setQuality(-1); // normal item's quality degrades
            if (sellIn < 0) setQuality(-1); // degrades even more once sellIn passed
            if (name.equals("Conjured Mana Cake")) setQuality(-1); // Degrades tice as fast.
        }
    }

    private void setQuality(int qlty){
        if (qlty == 0) {
            quality = 0 ;

        } else if (quality < 50) {
            quality += qlty ;
            quality = quality < 0 ? 0 : quality ; // Quality cannot be negative!
        }
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
