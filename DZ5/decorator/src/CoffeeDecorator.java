public abstract class CoffeeDecorator implements Coffee {
    protected final Coffee decorated;
    protected CoffeeDecorator(Coffee decorated) {
        this.decorated = decorated;
    }
    @Override
    public double getCost() {
        return decorated.getCost();
    }
    @Override
    public String getDescription() {
        return decorated.getDescription();
    }
}
