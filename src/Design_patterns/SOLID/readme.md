### Задание

Перед вами код программы, напоминающий по функционалу домашнее задание на одномерные массивы про магазин.

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Integer> products = new HashMap<>();
        products.put("Хлеб", 56);
        products.put("Масло", 153);
        products.put("Колбаса", 211);
        products.put("Пирожок", 45);

        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");
        for (Map.Entry<String, Integer> productAndPrice : products.entrySet()) {
            System.out.println(productAndPrice.getKey() + " за " + productAndPrice.getValue() + " руб./шт.");
        }

        System.out.println("Введите два слова: название товара и количество. Или end");
        Scanner scanner = new Scanner(System.in);
        Purchase purchase = new Purchase();
        while (true) {
            String line = scanner.nextLine();
            if ("end".equals(line)) break;
            String[] parts = line.split(" ");
            String product = parts[0];
            int count = Integer.parseInt(parts[1]);
            purchase.addPurchase(product, count);
        }
        long sum = purchase.sum(products);
        System.out.println("ИТОГО: " + sum);
    }
}
```

и вспомогательный класс:

```java
import java.util.Map;

public class Purchase {
protected String title;
protected int count;
protected Purchase[] purchases = new Purchase[4];

    public Purchase(String title, int count) {
        this.title = title;
        this.count = count;
    }

    public Purchase() {
    }

    public void addPurchase(String title, int count) {
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purchase(title, count);
                return;
            }
            if (purchases[i].title.equals(title)) {
                purchases[i].count += count;
                return;
            }
        }
    }

    public long sum(Map<String, Integer> prices) {
        long sum = 0;
        System.out.println("КОРЗИНА:");
        for (int i = 0; i < purchases.length; i++) {
            Purchase purchase = purchases[i];
            if (purchase == null) continue;
            System.out.println("\t" + purchase.title + " " + purchase.count + " шт. в сумме " + (purchase.count * prices.get(purchase.title)) + " руб.");
            sum += purchase.count * prices.get(purchase.title);
        }
        return sum;
    }
}
```


Как можно заметить, отличие прежде всего в том, что пользователь теперь вводит не номер 
товара, а его название, а также что в реализации используется хешмапа. 
Этот код специально написан с нарушением некоторых базовых принципов, рассмотренных на занятии.

**Ваша задача** - понять чужой код без подробных комментариев, найти эти нарушения и исправить. 
Это то, что часто встречается в задачах в коммерческой разработке.

В качестве решения должна быть ссылка на репозиторий с двумя (или более) классами в исправленном варианте.

**ВАЖНО**: Кроме этого в комментарии к решению следует описать, какие конкретно были нарушения, 
где находились и в чём состояло ваше исправление. 
Переписать всё с нуля или полностью изменить логику реализации программы считаться исправлением 
недочётов существующей программы не будет.