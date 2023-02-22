import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 1 Реализовать телефонный справочник
// HashMap<Login, Список телефонов>
// - добалять телефон
// - удалять телефон
// - находить по логину телефон/список телефонов

public class HW_Task_Phonebook {
    private static Map<String, String> phoneBook = new HashMap<>();

    public static void main(String[] args) {
        System.out.print("\033[H\033[J");
        phoneBook.put("Гриша", "8962139001");
        phoneBook.put("Морфей", "8962139002");
        phoneBook.put("Потапыч", "8962139000");

        
        // System.out.println(
        //         "Добро пожаловать в телефонную книгу. Пожалуйста, введите соответствующее число меню:\n1 - Вывести на экран телефонную книгу.\n2 - Добавить номер телефона.\n3 - Удалить конкретный номер телефона. \n4 - Найти по Вашему логину телефон");

        Scanner userInput = new Scanner(System.in);

        // String a = userInput.nextLine();
        // String b = userInput.nextLine();

        // addToPhoneBook(a, b);
        PrintPhonebook();
        System.out.println();

        String c = userInput.nextLine();
        userInput.close();
        deleteByPhoneNumber(c);
        System.out.println();
        PrintPhonebook();

    }

    public static void PrintPhonebook() {
        System.out.println("Телефонный справочник: ");
        for (Map.Entry<String, String> k : phoneBook.entrySet()) {
            System.out.println(k.getKey() + ": " + k.getValue());
        }

    }
    private static void addToPhoneBook(String login, String phonenumber) {
        phoneBook.put(login, phonenumber);
    }

    private static void deleteByPhoneNumber(String phone) {
        phoneBook.values().removeIf(value -> value.contains(phone));

}
}
