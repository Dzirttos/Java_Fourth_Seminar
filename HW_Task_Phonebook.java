import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// 1 Реализовать телефонный справочник
// HashMap<Login, Список телефонов>
// - добалять телефон
// - удалять телефон
// - находить по логину телефон/список телефонов

public class HW_Task_Phonebook {

    private static Map<String, List<String>> phoneBook = new HashMap<>();

    public static void main(String[] args) {
        System.out.print("\033[H\033[J");

        List<String> phoneMemo1 = new ArrayList(Arrays.asList("8999", "8777"));
        List<String> phoneMemo2 = new ArrayList(Arrays.asList("8966", "8754", "8444"));
        List<String> phoneMemo3 = new ArrayList(Arrays.asList("8912", "8444"));

        phoneBook.put("Goga", phoneMemo1);
        phoneBook.put("Morpheus", phoneMemo2);
        phoneBook.put("Kal-el", phoneMemo3);

        System.out.println("Добро пожаловать в телефонную книгу." +
                "Пожалуйста, введите соответствующее число меню:\n" +
                "1 - Вывести на экран телефонную книгу.\n" +
                "2 - Добавить номер телефона.\n" +
                "3 - Удалить конкретный номер телефона.\n" +
                "4 - Найти по логину необходимый телефон.\n" +
                "5 - Найти по номеру телефона необходимый логин.\n");

        Scanner userInput = new Scanner(System.in);

        String n = userInput.nextLine();

        switch (n) {
            case "1":
                System.out.println("\u001B[33m");
                PrintPhonebook();
                break;
            case "2":
                System.out.println("Пожалуйста, введите логин нового абонента: ");
                String a = userInput.nextLine();
                System.out.println(
                        "Пожалуйста, введите телефон нового абонента. Если номеров несколько, то введите их через запятую и пробел: ");
                // String b = userInput.nextLine();
                List<String> b = new ArrayList(Arrays.asList(userInput.nextLine()));
                addToPhoneBook(a, b);
                System.out.println("\u001B[32m");
                PrintPhonebook();
                break;
            case "3":
                System.out.println("Пожалуйста, введите номер телефона, который нужно удалить: ");
                String c = userInput.nextLine();
                deleteByPhoneNumber(c);
                System.out.println("\u001B[35m");
                PrintPhonebook();
                break;
            case "4":
                // PrintPhonebook();  // для удобства ввода на логина с клавиатуры
                System.out.println("Пожалуйста, введите логин для поиска номера телефона: ");
                String d = userInput.nextLine();
                System.out.println();
                System.out.println(FindLogin(d));
                break;
            case "5":
                // PrintPhonebook();  // для удобства ввода на телефона с клавиатуры
                System.out.println("Пожалуйста, введите номер телефона для поиска логина: ");
                String f = userInput.nextLine();
                FindPhoneNumber(phoneBook, f);
                break;
            default:
                System.out.println("\u001B[31mНевернный ввод! Попробуйте еще раз!");
                break;
        }
        userInput.close();
        System.out.println();
    }

    public static void PrintPhonebook() {
        System.out.println("Телефонный справочник: ");
        for (Map.Entry<String, List<String>> k : phoneBook.entrySet()) {
            System.out.println(k.getKey() + ": " + k.getValue());
        }
    }

    private static void addToPhoneBook(String login, List<String> phonenumber) {
        phoneBook.put(login, phonenumber);
    }

    private static void deleteByPhoneNumber(String phone) {
        phoneBook.values().removeIf(value -> value.contains(phone));
    }

    public static List<String> FindLogin(String login) {
        List<String> result = phoneBook.get(login);
        if (result == null) {
            System.out.println("\u001B[31mТакой логин не зарегистрирован");
            System.exit(0);
        }
        return result;
    }

    public static void FindPhoneNumber(Map<String, List<String>> map, String value) {
        int count = 0;
        for (Map.Entry<String, List<String>> item : map.entrySet()) {
            if (item.getValue().contains(value)) {
                System.out.println("\n" + item.getKey());
                count += 1;
            }
        }
        if (count == 0) {
            System.out.println("\u001B[31mУказанный номер телефона не найден");
        }
    }
}
