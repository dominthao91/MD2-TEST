import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        PhoneBookManagement phoneBookManagement = new PhoneBookManagement();
        int choice;
        do {
            menu();
            System.out.println("Nhập lựa chọn của bạn");
            choice =scanner.nextInt();
            switch (choice){
                case 1:{
                    showPhoneBook(phoneBookManagement);
                    break;
                }
                case 2:{
                    addPhoneBook(phoneBookManagement);
                    break;
                }
                case 3:{
                    updatePhoneBook(phoneBookManagement);
                    break;
                }
                case 4:{
                    deletePhoneBook(phoneBookManagement);
                    break;
                }
                case 5:{
                    seachPhoneBook(phoneBookManagement);
                    break;
                }
                case 0:{
                    System.exit(0);
                }
            }


        }while (choice!=0);
    }
    private static void seachPhoneBook(PhoneBookManagement phoneBookManagement){
        System.out.println("5. Tìm kiếm danh ba theo SDT");
        scanner.nextLine();
        System.out.println("nhập số điện thoại muốn tìm");
        String phonenumber =scanner.nextLine();
      int index= phoneBookManagement.findPhoneBook(phonenumber);
      if (index!=-1){
          System.out.println(phoneBookManagement.getPhoneBooks().get(index));
        }else {
          System.out.println("không tìm thấy SDT");
      }

    }
    private static void deletePhoneBook(PhoneBookManagement phoneBookManagement){
        System.out.println("4. Xóa thông tin liên lạc");
        scanner.nextLine();
        System.out.println("Nhập số điện thoại muốn xóa");
        String phone = scanner.nextLine();
        int index = phoneBookManagement.searchPhoneBook(phone);
        if (index!=-1){
            phoneBookManagement.deletePhoneBook(phone);
        }else {
            System.out.println("số điện thoại không đúng");
        }
    }
    private static void updatePhoneBook(PhoneBookManagement phoneBookManagement){
        System.out.println("3. Chỉnh sửa danh bạ");
        scanner.nextLine();
        System.out.println("Nhập số điện thoại cần sửa");
        String phoneNumber = scanner.nextLine();
        int index = phoneBookManagement.searchPhoneBook(phoneNumber);
        if (index!=-1){
            PhoneBook phoneBook = inputPhoneBook();
            phoneBookManagement.updatePhoneBook(phoneNumber,phoneBook);
        }else {
            System.err.println("Không có SDT này trong danh bạ");
        }
    }
    public static void addPhoneBook(PhoneBookManagement phoneBookManagement){
        PhoneBook phoneBook = inputPhoneBook();
        phoneBookManagement.addPhoneBook(phoneBook);
    }
    private static  PhoneBook inputPhoneBook(){

        System.out.println("2. Thêm  tên người dùng mới ");
        scanner.nextLine();
        System.out.println("Nhập tên : ");
        String name = scanner.nextLine();
        System.out.println("Nhập số điện thoại: ");
        String phone = scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
       String address = scanner.nextLine();
        System.out.println("Nhập email: ");
        String email = scanner.nextLine();
        System.out.println("nhập facebook: ");
        String facebook = scanner.nextLine();
        return new PhoneBook(name,phone, address, email, facebook);
    }
    public static void showPhoneBook(PhoneBookManagement phoneBookManagement){
        System.out.println("1. Hiển thị danh bạ");
        phoneBookManagement.showPhoneBook();
    }

    private static void menu() {
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("0. Thoát");
    }
}
