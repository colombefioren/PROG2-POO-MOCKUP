package colombe;

public class ChangePriceForm {
    public final String reason;
    public final double Price;

    public ChangePriceForm(String reason, double Price) {
        this.reason = reason;
        this.Price = Price;
    }

    public String getReason() {
        return reason;
    }

    public double getPrice() {
        return Price;
    }
}
