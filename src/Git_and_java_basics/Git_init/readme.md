### �������
��� ����� ����� ���������������� ����� ����� �� ������ ������, 
� ������ ������ � ��������� �������� ����������� ������� 
���������� ������. ����� ���� ���� ������ ������ ������ �������:

```java
public class SalesManager {
protected int[] sales;

    public SalesManager(int[] sales) {
        this.sales = sales;
    }

    public int max() {
        int max = -1;
        for (int sale : sales) {
            if (sale > max) {
                max = sale;
            }
        }
        return max;
    }
}
```

��� �������� ���� ������ ������������������ - ��� ������������ �������,
����� ����� ����� �������� ����������� � ����������� ��� � 
������� ��� ��������������� ��� ������.

**��� ��� �����:**

1. ������� ��������� ����������� �� ������
2. ������� ��������� �����������, ��������������� ��� ����� � ����� ����� ������� ����
3. ������� ��������� ����������� � ���������
4. ������� ���� `.gitignore`, ������ ���� �������, ������������� ���� � �������� ��� ���� ������
5. ������� � ����� src ���������� ��� �����
6. ������� ������
7. �������� ����� `Main`, � ������� �� ����������������� ������ ������ `SalesManager`
8. �������� ���� `README.md`, � ������� �� ������� ��� �� �������� 
���� �������� ������ (�� �������� ��� ������� �������������� ������ � ���� �����)
9. ������� ������ ������
10. �������� ��� ��������� �� ������, ��������� ��� �� ����������� ������� �����, 
� ����� � ����� ������� ������������