import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        CustomManager manager = new CustomManager();
        WriterCustom writer = new WriterCustom();
        Menu menu = new Menu();
        ReaderCustom rc = new ReaderCustom();
        manager.display(manager.getMap());
        while (true) {
            System.out.println("================Menu===============");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Hiển thị danh sách khách hàng");
            System.out.println("3. Tìm khách hàng ");
            System.out.println("4. Xóa khách hàng");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Sửa thông tin khách hàng");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn : ");
            int choice = sc.nextInt();

            sc.nextLine();
            switch (choice) {
                case 1:
                    menu.case1();
                    break;
                case 2:
                    menu.case2();
                    break;
                case 3:
                    menu.case3();
                    break;
                case 4:
                    menu.case4();
                    break;
                case 5:
                    menu.case5();
                    break;
                case 6:
                    menu.case6();
                    break;
                case 0:
                    System.out.println("Bái bai :))");
                    System.exit(0);
            }
        }
    }


}
