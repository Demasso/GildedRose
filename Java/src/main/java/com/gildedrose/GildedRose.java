package com.gildedrose;

class GildedRose {
	private static String _sulfur = "Sulfuras, Hand of Ragnaros";   // never touched
	private static String _backSt = "Backstage passes to a TAFKAL80ETC concert";
	private static String _agedBr = "Aged Brie";
	private static String _conjrd = "Conjured Mana Cake";

	// TODO: Implement conjured items

	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		// Item item : items loop, maybe there's a better way?
		for (Item item : items) {
			// Refactor by implementing switch with 5 cases (1 normal, 4 exceptions), use subMethods()

			// Rule 0 : exclude _sulfur right away as nothing ever changes to product
			if (item.name.equals(_sulfur)) continue;

			// Rule 1 : Lower sellIn. CAN be negative!
			item.sellIn -- ;
			
			// 2. handle quality
			// Rule 2.1 : _agedBr && _backSt IMPROVE in quality
			if (item.name.equals(_agedBr) || item.name.equals(_backSt)) {
				// Rule 2.1.1 : quality can never be >50
				if (item.quality < 50) {
					// Rule 2.1.2 : _agedBr & _backSt increase in quality
					item.quality ++ ; // >10 : +1

					// Rule 2.1.3 : _backSt quality improves even more nearing sellIn end
					if (item.name.equals(_backSt)) {
						if (item.sellIn < 10 && item.quality < 50) item.quality ++ ; // <10 : +2
						if (item.sellIn < 5 && item.quality < 50) item.quality ++ ; // < 5 : +3
					}
				}

			} else if (item.quality > 0) {
				// Rule 2.2 : Lower Quality. Never negative!
				item.quality -- ;

				// Rule 2.3 : _conjrd degrades twice as fast
				if (item.name.equals(_conjrd)) item.quality -- ;
			}

			// Rule 3 : in case of negative sellIn:
			if (item.sellIn < 0) {
				if (item.name.equals(_agedBr)) {
					// 3.1. increase _agedBr quality when sellIn has passed
					if (item.quality < 50) item.quality ++ ;

				} else if (item.name.equals(_backSt)) {
					// 3.2. _backSt degrade immediately to 0
					item.quality = 0 ;

				} else {
					// 3.3. Quality degrades twice as fast, EXCEPT for above tow items.
					if (item.quality > 0) item.quality -- ;
				}
			}
		}
	}
}

/*
	RUN INCLUDED TEST:

	in root dir:
	./gradlew -q text --args 30

	or
	
	in Java dir:
	python3 texttest_rig.py -a 30

	Diff compare output with texttests/ThirtyDays/stdout.gr
*/
