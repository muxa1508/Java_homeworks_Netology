### �������

����� ���� ��� ���������, ������������ �� ����������� �������� ������� �� ���������� ������� ��� �������.

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Integer> products = new HashMap<>();
        products.put("����", 56);
        products.put("�����", 153);
        products.put("�������", 211);
        products.put("�������", 45);

        System.out.println("� �������� � �������");
        for (Map.Entry<String, Integer> productAndPrice : products.entrySet()) {
            System.out.println(productAndPrice.getKey() + " �� " + productAndPrice.getValue() + " ���./��.");
        }

        System.out.println("������� ��� �����: �������� ������ � ����������. ��� end");
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
        System.out.println("�����: " + sum);
    }
}
```

� ��������������� �����:

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
        System.out.println("�������:");
        for (int i = 0; i < purchases.length; i++) {
            Purchase purchase = purchases[i];
            if (purchase == null) continue;
            System.out.println("\t" + purchase.title + " " + purchase.count + " ��. � ����� " + (purchase.count * prices.get(purchase.title)) + " ���.");
            sum += purchase.count * prices.get(purchase.title);
        }
        return sum;
    }
}
```


��� ����� ��������, ������� ������ ����� � ���, ��� ������������ ������ ������ �� ����� 
������, � ��� ��������, � ����� ��� � ���������� ������������ �������. 
���� ��� ���������� ������� � ���������� ��������� ������� ���������, ������������� �� �������.

**���� ������** - ������ ����� ��� ��� ��������� ������������, ����� ��� ��������� � ���������. 
��� ��, ��� ����� ����������� � ������� � ������������ ����������.

� �������� ������� ������ ���� ������ �� ����������� � ����� (��� �����) �������� � ������������ ��������.

**�����**: ����� ����� � ����������� � ������� ������� �������, ����� ��������� ���� ���������, 
��� ���������� � � ��� �������� ���� �����������. 
���������� �� � ���� ��� ��������� �������� ������ ���������� ��������� ��������� ������������ 
��������� ������������ ��������� �� �����.