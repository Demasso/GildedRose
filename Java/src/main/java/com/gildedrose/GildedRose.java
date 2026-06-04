package com.gildedrose;

class GildedRose {
	private static String _sulfur = "Sulfuras, Hand of Ragnaros";
	private static String _backSt = "Backstage passes to a TAFKAL80ETC concert";
	private static String _agedBr = "Aged Brie";

	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		// this loop is so much better.
		for (Item item : items) {
			// exclude _sulfur right away as nothing ever changes to product
			if (item.name.equals(_sulfur)) continue;

			// 1. decrease sellIn for the product:
			item.sellIn -- ;
			
			// 2. handle quality
			if (item.name.equals(_agedBr) || item.name.equals(_backSt)) {
				if (item.quality < 50) {
					// increase quality for _agedBr & _backSt
					item.quality ++ ;

					// _backSt quality improves even more nearing sellIn end
					if (item.name.equals(_backSt)) {
						if (item.sellIn < 10 && item.quality < 50) item.quality ++ ;
						if (item.sellIn < 5 && item.quality < 50) item.quality ++ ;
					}
				}

			} else if (item.quality > 0) {
				item.quality -- ;
			}

			// 3. TODO in case of negative sellIn:
			if (item.sellIn < 0) {
				if (!item.name.equals(_agedBr)) {
					if (!item.name.equals(_backSt)) {
						if (item.quality > 0) {
							if (!item.name.equals(_sulfur)) item.quality -- ;
						}
					} else {
						item.quality = 0 ;
					}
				} else {
					if (item.quality < 50) item.quality ++ ;
				}
			}
		}
	}
}