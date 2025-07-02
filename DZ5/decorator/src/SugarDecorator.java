public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee decorated) {
        super(decorated);
    }
    @Override
    public double getCost() {
        return super.getCost() + 0.2;
    }
    @Override
    public String getDescription() {
        return super.getDescription() + ", sugar";
    }
}
