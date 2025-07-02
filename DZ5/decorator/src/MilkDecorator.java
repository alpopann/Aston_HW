public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee decorated) {
        super(decorated);
    }
    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }
    @Override
    public String getDescription() {
        return super.getDescription() + ", milk";
    }
}