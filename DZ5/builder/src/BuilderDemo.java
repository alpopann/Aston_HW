public class BuilderDemo {
    public static void main(String[] args) {
        User user = new User.Builder("Alice", "Smith")
                .age(30)
                .address("123 Main St")
                .build();
        System.out.println(user);
    }
}