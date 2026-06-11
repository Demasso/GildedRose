public class ElectronicsSellStrategy implements SellStrategy {
    @Override
    public String sell(Item item) {
        // Logic specific to Electronics: Check compatibility, calculate refurbished value.
        if (item.getSerialNumber() == null || item.getSerialNumber().isEmpty()) {
            return "SALE FAILED: Electronics require a registered serial number.";
        }
        
        double finalPrice = item.getBasePrice() * 0.85; // Example: 15% discount for refurbishment
        return String.format("SUCCESS: Sold %s! Serial #%s. Final Price: $%.2f (Electronics Discount Applied).", 
                             item.getName(), item.getSerialNumber(), finalPrice);
    }
}