package com.gildedrose;

class GildedRose {

	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		// Item item : items loop, todo: maybe there's a better way?
		for (Item item : items) {
			switch(item.name) {
				case "Sulfuras, Hand of Ragnaros" :
					break ;  // Exclude _sulfur right away as nothing ever changes to product

				case "Aged Brie" :
					item.sellIn -- ;
					setQuality(item, 1); // >10 : +1
					if (item.sellIn < 0) setQuality(item, 1); // quality incrases faster on negative sellIn
					break ;

				case "Backstage passes to a TAFKAL80ETC concert" :
					item.sellIn -- ;

					if (item.sellIn < 0) {
						setQuality(item, 0); // Quality drops to 0 once sellIn reached

					} else {
						setQuality(item, 1); // rule 4 & 6
						if (item.sellIn < 10) setQuality(item, 1); // <10 : +2
						if (item.sellIn <  5) setQuality(item, 1); // < 5 : +3
					}
					break ;
					
				default :
					item.sellIn -- ;

					if (item.quality > 0) { // normal items
						setQuality(item, -1); // normal item's quality degrades
						if (item.sellIn < 0) setQuality(item, -1); // degrades even more once sellIn passed
						if (item.name.equals(_conjrd)) setQuality(item, -1); // Conjured rule
					}
					break ;
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

/*
	RUN INCLUDED TEST:

	in root dir:
	./gradlew -q text --args 30

	or
	
	in Java dir:
	python3 texttest_rig.py -a 30

	Diff compare output with texttests/ThirtyDays/stdout.gr
*/
