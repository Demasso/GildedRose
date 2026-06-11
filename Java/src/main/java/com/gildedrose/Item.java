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


    public void setAgedBrie(){
        sellIn -- ;
        setQuality(1); // >10 : +1
        if (sellIn < 0) setQuality(1); // quality incrases faster on negative sellIn
    }

    public void setBackStage(){
        sellIn -- ;
        if (sellIn < 0) {
            setQuality(0); // Quality drops to 0 once sellIn reached

        } else{
            setQuality(1); // >10 : +1
            if (sellIn < 10) setQuality(1); // <10 : +2
            if (sellIn <  5) setQuality(1); // < 5 : +3
        }
    }

    public void setConjured(){
        setDefault();
        setQuality(-1); // Degrades tice as fast.
    }

    public void setDefault(){
        sellIn -- ;
        if (quality > 0) {
            setQuality(-1); // normal item's quality degrades
            if (sellIn < 0) setQuality(-1); // degrades even more once sellIn passed
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