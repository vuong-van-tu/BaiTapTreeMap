public class Customer implements Comparable<Customer> {
    private String name;
    private int age;
    private String address;
    private String id;

    public Customer() {
    }

    public Customer(String name, int age, String address, String id) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public int compareTo(Customer o) {
        return this.name.compareTo(o.name);
    }
}
