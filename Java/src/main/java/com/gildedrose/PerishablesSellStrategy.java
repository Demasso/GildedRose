public class PerishablesSellStrategy implements SellStrategy {
    @Override
    public String sell(Item item) {
        // Logic specific to Perishables: Check expiration dates and apply heavy markdown.
        if (item.getExpirationDate() == null) {
            return "SALE FAILED: Perishables must have a clear expiration date.";
        }
        
        double discountedPrice = item.getBasePrice() * 0.70; // Example: 30% markdown
        return String.format("SUCCESS: Sold %s (Exp: %s). Deep Discount Price: $%.2f (Perishables Markdown).", 
                             item.getName(), item.getExpirationDate(), discountedPrice);
    }
}