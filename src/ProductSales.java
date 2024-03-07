import java.math.BigDecimal;

public class ProductSales {
    public static void main(String[] args) {

        // Unique values for the net price, VAT rate, and quantity sold
        double netPriceDouble = 9.99;
        double vatRateDouble = 0.23;
        int quantitySold = 10000;

        // Create a Product object
        Product product = new Product(BigDecimal.valueOf(netPriceDouble));

        // Set a new price for the product
        //product.setPrice(new BigDecimal("12.50"));

        // Calculate gross value using double
        double grossValueDouble = product.getPrice().doubleValue() * (1 + vatRateDouble);

        // Calculate total sales value excluding VAT using double
        double totalSalesExcludingVATDouble = grossValueDouble * quantitySold;

        // Print results for double implementation
        System.out.println("Using double implementation:");
        System.out.println("Gross value per product: " + grossValueDouble);
        System.out.println("Total sales value excluding VAT: " + totalSalesExcludingVATDouble);

        // Calculate gross value using BigDecimal
        BigDecimal vatRateBigDecimal = new BigDecimal("0.23");

        BigDecimal grossValueBigDecimal = product.getPrice().multiply(BigDecimal.ONE.add(vatRateBigDecimal));

        // Calculate total sales value excluding VAT using BigDecimal
        BigDecimal totalSalesExcludingVATBigDecimal = grossValueBigDecimal.multiply(BigDecimal.valueOf(quantitySold));

        // Print results for BigDecimal implementation
        System.out.println("\nUsing BigDecimal implementation:");
        System.out.println("Gross value per product: " + grossValueBigDecimal);
        System.out.println("Total sales value excluding VAT: " + totalSalesExcludingVATBigDecimal);
    }
}

class Product {
    private BigDecimal price;

    public Product(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
