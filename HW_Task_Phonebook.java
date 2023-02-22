import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.sql.rowset.spi.SyncResolver;

// 1 Реализовать телефонный справочник
// HashMap<Login, Список телефонов>
// - добалять телефон
// - удалять телефон
// - находить по логину телефон/список телефонов

public class HW_Task_Phonebook {
    private static Map<String, String> phoneBook = new HashMap<>();

    public static void main(String[] args) {
        System.out.print("\033[H\033[J");
        phoneBook.put("GG", "8962139001");
        phoneBook.put("Морфей", "8962139002");
        phoneBook.put("Потапыч", "8962139000");

        // System.out.println(
        // "Добро пожаловать в телефонную книгу. Пожалуйста, введите соответствующее
        // число меню:\n1 - Вывести на экран телефонную книгу.\n2 - Добавить номер
        // телефона.\n3 - Удалить конкретный номер телефона. \n4 - Найти по Вашему
        // логину телефон");

        Scanner userInput = new Scanner(System.in);

        // String a = userInput.nextLine();
        // String b = userInput.nextLine();

        // addToPhoneBook(a, b);
        PrintPhonebook();
        System.out.println();

        // String c = userInput.nextLine();

        // deleteByPhoneNumber(c);
        // System.out.println();
        // PrintPhonebook();

        String d = userInput.nextLine();

        // System.out.println(FindPhoneNumber(d));
        // System.out.println(FindLogin(d));
        System.out.println(gettKey(phoneBook, d));

        userInput.close();

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

    public static String FindLogin(String login) {
        String result = phoneBook.get(login);
        if (result == null)
            return "\u001B[31mТакой логин не зарегистрирован";
        return result;
    }

    public static String[] FindPhoneNumber(String phone) {
        List<String> result = new ArrayList<String>();
        for (Map.Entry entry : phoneBook.entrySet()) {
            if (phone.equalsIgnoreCase((String) entry.getValue())) {
                result.add((String) entry.getKey());
            }
        }
        if (result.size() == 0)
            result.add("\u001B[31mУказанный номер телефонв не найден");
        return result.toArray(new String[0]);
    }

    public static <Key, Value> Key gettKey(Map<Key, Value> map, Value value) {
        for (Map.Entry<Key, Value> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        System.out.println("\u001B[31mУказанный номер телефона не найден");
        System.exit(0);
        return null;
    }
}
