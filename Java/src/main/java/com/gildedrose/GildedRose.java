package com.gildedrose;

class GildedRose {

	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		// Item item : items loop, todo: maybe there's a better way?
		for (Item item : items) {
			// Rule 0 : exclude "Sulfuras, Hand of Ragnaros" right away as nothing ever changes to product
			if (item.name.equals("Sulfuras, Hand of Ragnaros")) continue;

			item.sellIn -- ; // Lower sellIn. CAN be negative!
			item.setItem();
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
