/**
 * Defines the interface for all concrete selling strategies.
 * This is the core of the Strategy Pattern.
 */
public interface SellStrategy {
    /**
     * Executes the specific selling logic for a product type.
     * @param item The item being sold.
     * @return A string describing the outcome of the sale.
     */
    String sell(Item item);
}