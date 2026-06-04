package com.gildedrose;

class GildedRose {
	private static String _sulfur = "Sulfuras, Hand of Ragnaros";   // never touched
	private static String _backSt = "Backstage passes to a TAFKAL80ETC concert";
	private static String _agedBr = "Aged Brie";

	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		// Item item : items loop, maybe there's a better way?
		for (Item item : items) {
			// exclude _sulfur right away as nothing ever changes to product
			if (item.name.equals(_sulfur)) continue;

			// 1. decrease sellIn for the product:
			item.sellIn -- ;
			
			// 2. handle quality
			// _agedBr && _backSt improve in quality
			if (item.name.equals(_agedBr) || item.name.equals(_backSt)) {
				// quality can never be >50
				if (item.quality < 50) {
					// 2.a. _agedBr & _backSt increase in quality
					item.quality ++ ;

					// 2.b. _backSt quality improves even more nearing sellIn end
					if (item.name.equals(_backSt)) {
						if (item.sellIn < 10 && item.quality < 50) item.quality ++ ;
						if (item.sellIn < 5 && item.quality < 50) item.quality ++ ;
					}
				}

			} else if (item.quality > 0) {
				// 2.b. while other degrade in quality
				item.quality -- ;
			}

			// 3. in case of negative sellIn:
			if (item.sellIn < 0) {
				if (item.name.equals(_agedBr)) {
					// 3.a. increase _agedBr quality when sellIn has passed
					if (item.quality < 50) item.quality ++ ;

				} else if (item.name.equals(_backSt)) {
					// 3.b. _backSt degrade immediately to 0
					item.quality = 0 ;

				} else {
					// 3.c. other products decrases daily when negative sellIn
					if (item.quality > 0) item.quality -- ;
				}
			}
		}
	}
}