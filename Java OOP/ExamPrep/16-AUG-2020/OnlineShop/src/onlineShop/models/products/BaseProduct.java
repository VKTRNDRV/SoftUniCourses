package onlineShop.models.products;

public abstract class BaseProduct implements Product{

    private int id;

    private String manufacturer;

    private String model;

    private double price;

    private double overallPerformance;

    public BaseProduct(int id, String manufacturer, String model, double price, double overallPerformance) {
        setId(id);
        setManufacturer(manufacturer);
        setModel(model);
        setPrice(price);
        setOverallPerformance(overallPerformance);
    }

    // Getters and setters for the fields
    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getOverallPerformance() {
        return overallPerformance;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id can not be less or equal than 0.");
        }
        this.id = id;
    }

    public void setManufacturer(String manufacturer) {
        if (manufacturer == null || manufacturer.trim().isEmpty()) {
            throw new IllegalArgumentException("Manufacturer can not be empty.");
        }
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model can not be empty.");
        }
        this.model = model;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price can not be less or equal than 0.");
        }
        this.price = price;
    }

    public void setOverallPerformance(double overallPerformance) {
        if (overallPerformance <= 0) {
            throw new IllegalArgumentException("Overall Performance can not be less or equal than 0.");
        }
        this.overallPerformance = overallPerformance;
    }

    @Override
    public String toString() {
        return String.format("Overall Performance: %.2f. Price: %.2f - %s: %s %s (Id: %d)",
                overallPerformance, price, this.getClass().getSimpleName(), manufacturer, model, id);
    }
}
