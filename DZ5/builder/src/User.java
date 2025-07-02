public class User {
    private final String firstName;   // обязательное
    private final String lastName;    // обязательное
    private final int age;            // опционально
    private final String phone;       // опционально
    private final String address;     // опционально

    private User(Builder b) {
        firstName = b.firstName;
        lastName  = b.lastName;
        age       = b.age;
        phone     = b.phone;
        address   = b.address;
    }

    public static class Builder {
        private final String firstName;
        private final String lastName;
        private int age;
        private String phone;
        private String address;

        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName  = lastName;
        }
        public Builder age(int age) {
            this.age = age;
            return this;
        }
        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public Builder address(String address) {
            this.address = address;
            return this;
        }
        public User build() {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return firstName + " " + lastName
                + ", age=" + age
                + (phone   != null ? ", phone=" + phone   : "")
                + (address != null ? ", address=" + address : "");
    }
}