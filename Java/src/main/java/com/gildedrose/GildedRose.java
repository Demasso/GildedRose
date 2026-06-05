package com.gildedrose;

class GildedRose {
	private static String _sulfur = "Sulfuras, Hand of Ragnaros";   // never touched
	private static String _backSt = "Backstage passes to a TAFKAL80ETC concert";
	private static String _agedBr = "Aged Brie";
	private static String _conjrd = "Conjured Mana Cake";

	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		// Item item : items loop, todo: maybe there's a better way?
		for (Item item : items) {
			// todo: Refactor by implementing switch with 5 cases (1 normal, 4 exceptions), use subMethods()

			if (item.name.equals(_sulfur)) continue; // Rule 0 : exclude _sulfur right away as nothing ever changes to product

			item.sellIn -- ; // Lower sellIn. CAN be negative!
			
			// Handle by item
			if (item.name.equals(_agedBr)) { // Aged Brie
				setQuality(item, 1); // >10 : +1
				if (item.sellIn < 0) setQuality(item, 1); // quality incrases faster on negative sellIn

			} else if (item.name.equals(_backSt)) { // Backstage
				if (item.sellIn < 0) {
					setQuality(item, 0); // Quality drops to 0 once sellIn reached

				} else{
					setQuality(item, 1); // >10 : +1
					if (item.sellIn < 10) setQuality(item, 1); // <10 : +2
					if (item.sellIn <  5) setQuality(item, 1); // < 5 : +3
				}

			} else if (item.quality > 0) { // normal items
				setQuality(item, -1); // normal item's quality degrades
				if (item.sellIn < 0) setQuality(item, -1); // degrades even more once sellIn passed
				if (item.name.equals(_conjrd)) setQuality(item, -1); // Conjured rule
			}
		}
	}

	private void setQuality(Item item, int qlty){
		if (qlty == 0) {
			item.quality = 0 ;

		} else if (item.quality < 50) {
			item.quality += qlty ;
			item.quality = item.quality < 0 ? 0 : item.quality ; // Quality cannot be negative!
		}
	}
}