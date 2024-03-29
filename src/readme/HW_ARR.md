# Домашнее задание к занятию «Одномерные массивы»

## Цель задания

При выполнении этого задания вы научитесь работать с наборами данных в Java с помощью массивов.

------

## Инструкция к заданию

1. Для каждой задачи создайте отдельный реплит, если об обратном не сказано в условии.
1. Саму программу вы пишете в IDEA, реплит используется только для сдачи кода.
3. В окне редактора IDEA наберите программный код, решающий поставленную задачу.
5. Загрузите файлы из папки src проекта в реплит.
6. Отправьте выполненную работу на проверку в личном кабинете Нетологии.

------

## Материалы для выполнения задания

1. [Как поделиться реплитом для проверки.](https://github.com/netology-code/java2-homeworks/blob/main/QA_ReplitShare.md)
2. [Как автоотформатировать код.](https://github.com/netology-code/java2-homeworks/blob/main/QA_Format.md)
3. [Как залить проект из IDEA в реплит.](https://github.com/netology-code/java2-homeworks/blob/main/QA_ReplitUpload.md)

------

## Задание 1 

**Что нужно сделать**

1. Напишите программу, планирующую продуктовую корзину.  
1. У вас есть список доступных продуктов в одном массиве и соответствующая им цена в другом массиве.
1. Пользователь на повторе вводит номер продукта из первого списка и количество продуктов этого вида, которое хочет купить. 
1. Программа добавляет указанное количество выбранного продукта в итоговую продуктовую корзину.  
1. Действие повторяется до тех пор, пока пользователь не введёт команду `end`.
1. Только после этого выводится вся корзина выбранных товаров и итоговая сумма.
1. Должна быть возможность ввода пользователем **одной строкой** номера продукта и его количества для добавления в корзину.
1. Пользователь может добавлять несколько раз один и тот же товар в корзину, в этом случае он должен суммироваться.

### Пример работы
```
Список возможных товаров для покупки:
1. Молоко — 50 руб./шт.
2. Хлеб — 14 руб./шт.
3. Гречневая крупа — 80 руб./шт.

Выберите товар и количество или введите `end`
1 10 <enter>
Выберите товар и количество или введите `end`
3 1 <enter>
Выберите товар и количество или введите `end`
end <enter>

Ваша корзина:
1. Молоко — 10 шт., 50 руб./шт., 500 руб в сумме.
2. Гречневая крупа — 1 шт., 80 руб./шт., 80 руб. в сумме.

Итого 580 руб.
```

### Подсказки

У нас есть список доступных продуктов в одном массиве:

```java
String[] products = {"Хлеб", "Яблоки", "Молоко"}; 
```
и соответствующие цены в другом массиве:

```java
int[] prices = {100, 200, 300};
```


При запуске программы необходимо вывести продукты и цены на экран пользователя:

```java
 for (int i = 0; i < products.length; i++) {
   ???
 }
```

Нужно придумать, где и как будем хранить информацию о выбранных товарах. 

Мы предлагаем этот вариант: заведите массив, где в каждой ячейке будет храниться выбранное пользователем количество того товара, чей номер совпадает с номером ячейки.

Дальше заводим цикл `while (true)`. В нём нужно создать переменные, в которых сохраняются значения, вводимые пользователем. Допустим, что:

* для номера продукта — это переменная: ```int productNumber = 0;```
* для количества это — переменная: ```int productCount = 0;```
* по номеру, например, можно найти цену продукта в массиве цен: `int currentPrice = prices[productNumber];`

Для проверки на ввод `end` использовать `inputString.equals("end")`, оператор `==` со строками не работает.

Для приведения текста в числовой тип можно использовать `Integer.parseInt(inputString)`.

Для подсчёта итоговой суммы чека заведите до цикла переменную `int sumProducts = 0;` и обновляйте её в соответствии с тем, что вводит пользователь. 

После того, как пользователь введёт `end`, программа выйдет из цикла. На экран нужно вывести корзину и итоговую сумму продуктовой корзины.

------

## Правила приёма работы

Прикреплена ссылка на реплит с решением задачи.

------

## Критерии оценки

1. Программа запускается и отрабатывает без ошибок.
2. Программа соответствует всем требованиям и условиям задачи.
3. Программа работает правильно на всех примерах из условия.
4. Программный код отформатирован и соответствует пройденным требованиям к качеству кода.
5. Программа спроектирована логично и правильно, не противоречит общепринятым в производстве практикам и традициям.
6. При наличии серьёзных недочётов работа может быть отправлена на доработку. Решение принимается на основе экспертной оценки работы.
