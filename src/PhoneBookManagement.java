import java.util.ArrayList;
import java.util.List;

public class PhoneBookManagement {
    private List<PhoneBook> phoneBooks = new ArrayList<>();

    public void showPhoneBook() {
        for (PhoneBook phonebook : phoneBooks) {
            System.out.println(phonebook);
        }
    }

    public void addPhoneBook(PhoneBook phoneBook) {
        this.phoneBooks.add(phoneBook);
    }

    public List<PhoneBook> getPhoneBooks() {
        return phoneBooks;
    }

    public int searchPhoneBook(String phoneNumber) {
        int index = -1;
        for (int i = 0; i < phoneBooks.size(); i++) {
            if (phoneNumber.equals(phoneBooks.get(i).getPhoneNumber())) {
                index = i;
                break;
            }
        }
        return index;
    }
    public boolean updatePhoneBook(String phoneNumber, PhoneBook phoneBook){
        boolean isUpdate = false;
        int index = searchPhoneBook(phoneNumber);
        if (index!=-1){
            isUpdate =true;
            phoneBooks.set(index,phoneBook);
        }
        return isUpdate;
    }
    public boolean deletePhoneBook(String phoneNumber){
        boolean isDelete =false;
        int index = searchPhoneBook(phoneNumber);
        if (index!=-1){
            isDelete =true;
            phoneBooks.remove(index);
        }
        return isDelete;
    }
    public int findPhoneBook(String phoneNumber){
        int index =-1;
        for (int i = 0; i < phoneBooks.size(); i++) {
            if (phoneBooks.get(i).getPhoneNumber().equals(phoneNumber));
            return index =i;
        }
        return index;
    }

}
