import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<String> shoppingList = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);
    private static String s;

    public static void main(String[] args) {
        int selectedOption = -1;
        do { // Вертимся тут до ввода символа выхода
            showHint(); // Выводим на экран Инфопанель
            s = sc.nextLine();
            try {
                selectedOption = Integer.parseInt(s);
                switch (selectedOption) {
                    case 1 -> addPurchase();
                    case 2 -> showPurchases();
                    case 3 -> deletePurchase();
                    case 4 -> searchPurchase();
                }
            } catch (NumberFormatException nfe) { // Выполнится, если на входе не целое число
            }
        }
        while (selectedOption != 0); // Game Over

    }

    private static void addPurchase() {
        System.out.println("Какую покупку хотите добавить?");
        // TODO Предполагается, что ввод проверять не надо
        shoppingList.add(sc.nextLine());
        System.out.printf("Итого в списке покупок: %3d\n", shoppingList.size());
    }

    private static void showPurchases() {
        System.out.println("Список покупок:");
        for (int i = 0; i < shoppingList.size(); i++) {
            System.out.printf("%3d.%-12s\n", i + 1, shoppingList.get(i));
        }
    }

    private static void deletePurchase() {
        int index;
        showPurchases();
        System.out.println("Какую хотите удалить? Введите номер или название");
        s = sc.nextLine();
        try {
            index = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            index = shoppingList.indexOf(s);
        }
        shoppingList.remove(index);
    }

    private static void searchPurchase() {
        System.out.println("Введите текст для поиска:");
        s = sc.nextLine().toLowerCase();
        System.out.println("Найдено:");
        for (int i = 0; i < shoppingList.size(); i++) {
            if (shoppingList.get(i).toLowerCase().contains(s)) {
                System.out.printf("%3d.%-12s\n", i + 1, shoppingList.get(i));
            }
        }
    }

    private static void showHint() {
        System.out.print("""
                                
                <1> - Добавить
                <2> - Показать
                <3> - Удалить
                <4> - Найти
                <0> - Закончить работу
                                
                Выберите операцию:
                """);
    }
}
