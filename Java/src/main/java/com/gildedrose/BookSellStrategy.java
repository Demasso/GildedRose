public class BookSellStrategy implements SellStrategy {
    @Override
    public String sell(Item item) {
        // Simple general sale logic
        return String.format("SUCCESS: Successfully sold the book titled '%s' for $%.2f.", 
                             item.getName(), item.getBasePrice());
    }
}