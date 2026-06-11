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
                case "Sulfuras, Hand of Ragnaros" : break;

                case "Aged Brie" : item.setAgedBrie();
                    break;

                case "Backstage passes to a TAFKAL80ETC concert" : item.setBackStage();
                    break;

                case "Conjured Mana Cake" : item.setConjured();
                    break;

                default : item.setDefault();
                    break;
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
