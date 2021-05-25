import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomManager manager = new CustomManager();
        System.out.println("Danh sách:");
        manager.display();
        while (true) {
            System.out.println("================Menu===============");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Hiển thị danh sách khách hàng");
            System.out.println("3. Tìm khách hàng ");
            System.out.println("4. Xóa khách hàng");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Sửa thông tin khách hàng");
            System.out.println("0. Thoát");
            System.out.println("Nhập lựa chọn : ");
            int choice = sc.nextInt();
            int key;
            sc.nextLine();
            switch (choice) {
                case 1:
                    do {
                        System.out.println("Nhập key : ");
                        key = sc.nextInt();
                        sc.nextLine();
                        if (manager.map.containsKey(key)) {
                            System.out.println("Key đã tồn tại yêu cầu nhập lại !");
                        }
                    }
                    while (manager.map.containsKey(key));
                    manager.addCus(key, themCus());
                    break;
                case 2:
                    manager.display();
                    break;
                case 3:
                    System.out.println("====================");
                    System.out.println("1. Tìm theo tên ");
                    System.out.println("2. Tìm theo tuổi ");
                    System.out.println("3. Tìm theo địa chỉ ");
                    System.out.println("4. Tìm theo ID ");
                    System.out.println("Nhập lựa chọn : ");
                    int find = sc.nextInt();
                    sc.nextLine();
                    switch (find) {
                        case 1:
                            System.out.print("Nhập tên cần tìm kiếm :");
                            String findName = sc.nextLine();
                            if (manager.findByName(findName) == null) {
                                System.out.println("Không tìm thấy");
                            } else {
                                System.out.println(manager.findByName(findName));
                            }
                            break;
                        case 2:
                            System.out.print("Nhập tuổi cần tìm : ");
                            int findAge = sc.nextInt();
                            sc.nextLine();
                            if (manager.findByAge(findAge) == null) {
                                System.out.println("Không tìm thấy");
                            } else {
                                System.out.println(manager.findByAge(findAge));
                            }
                            break;
                        case 3:
                            System.out.print("Nhập địa chỉ cần tìm : ");
                            String findAddress = sc.nextLine();
                            if (manager.findByAddress(findAddress) == null) {
                                System.out.println("Không tìm thấy");
                            } else {
                                System.out.println(manager.findByAddress(findAddress));
                            }
                            break;
                        case 4:
                            System.out.println("Nhập ID cần tìm : ");
                            String findID = sc.nextLine();
                            if (manager.findByID(findID) == null) {
                                System.out.println("Không tìm thấy");
                            } else {
                                System.out.println(manager.findByID(findID));
                            }
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Nhập key của khách hàng cần xóa :");
                    int deleteId = sc.nextInt();
                    manager.deleteCus(deleteId);
                    manager.display();
                    break;
                case 5:
                    System.out.println("===================");
                    System.out.println("1. Sắp xếp theo tên ");
                    System.out.println("2. Sắp xếp theo tuổi ");
                    System.out.println("3. Sắp xếp theo tên và tuổi ");
                    System.out.print("Nhập lựa chọn :");
                    int sort = sc.nextInt();
                    switch (sort) {
                        case 1:
                            manager.sortByName();
                            manager.display();
                            break;
                        case 2:
                            manager.sortByAge();
                            manager.display();
                            break;
                        case 3:
                            manager.sortByNameAndAge();
                            manager.display();
                            break;
                    }
                    break;
                case 6:
                    System.out.println("Nhập key cần sửa thông tin:");
                    int editKey = sc.nextInt();
                    manager.editCus(editKey, themCus());
                    manager.display();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }

    public static Customer themCus() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập khách hàng ");
        System.out.print("Nhập tên : ");
        String name = sc.nextLine();
        System.out.print("Nhập tuổi : ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhập địa chỉ:");
        String address = sc.nextLine();
        System.out.print("Nhập id :");
        String id = sc.nextLine();
        return new Customer(name, age, address, id);
    }
}
