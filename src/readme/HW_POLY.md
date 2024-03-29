# Домашнее задание к занятию "Полиморфизм"

## Цель задания

1. Научиться использовать полиморфизм в проектировании логики работы классов

------

## Инструкция к заданию

1. Для каждой задачи создайте отдельный реплит, если об обратном не сказано в условии
1. Саму программу вы пишете в IDEA, реплит используется только для сдачи кода
3. В окне редактора IDEA наберите программный код, решающий поставленную задачу
5. Загружаете файлы из папки src проекта в реплит
6. Отправьте выполненную работу на проверку в личном кабинете Нетологии

------

## Материалы, которые пригодятся для выполнения задания

1. [Как поделиться реплитом для проверки?](https://github.com/netology-code/java2-homeworks/blob/main/QA_ReplitShare.md)
2. [Как автоотформатировать код?](https://github.com/netology-code/java2-homeworks/blob/main/QA_Format.md)
3. [Как залить проект из идеи в реплит?](https://github.com/netology-code/java2-homeworks/blob/main/QA_ReplitUpload.md)

------

## Задание 1 (обязательное)

Мы будем писать систему бухгалтерского учёта.
При этом, логика контроля доходов и расходов будет в одном классе, а логика системы налогооблажения в других.
Для того чтобы это гладко работало друг с другом, нам и понадобится полиморфизм.

Создайте класс `Company`. Каждая компания должна знать свои `title` (название), `debit` (доходы), `credit` (расходы) и `taxSystem` (систему налогооблажения, об этом ниже).

В этом классе должен быть только один конструктор, задающий название компании и систему налогооблажения, принимая их параметрами. Доходы и расходы изначально равны нулю.

У компании должен быть метод `shiftMoney(int amount)`, который работает следующим образом:
* если `amount` больше 0, то увеличивается значение `debit` на `amount`;
* если `amount` меньше 0, то увеличивается значение `credit` на `Math.abs(amount)`;
* если `amount` равен 0, то ничего не происходит.

Теперь поговорим про системы налогооблажения.
Все системы налогооблажения будут наследоваться от класса `TaxSystem`, переопределяя метод рассчёта налогов по доходам и расходам:
```java
package taxes;

public class TaxSystem {
    public int calcTaxFor(int debit, int credit) {
        return 0;
    }
}
```

Обратите внимание, что этот класс находится в пакете. В том же пакете должны находиться и классы других налоговых систем, которые вам предстоит написать.

Реализуйте два класса налоговых систем:
* УСН доходы - налог 6% от доходов;
* УСН доходы минус расходы - налог 15% от разницы доходов и расходов.

Помните, что налог не может быть отрицательным (в таком случае налог должен быть 0).

Компания должна работать с любой системой налогооблажения, поэтому внутри класса `Company` используйте класс `TaxSystem` в указании типов ячеек; по правилу полиморфизма, в них можно будет передать объекты любых наследников этого класса, с уже конкретными логиками расчёта налогов.

Добавьте в класс `Company` сеттер для смены системы налогооблажения.

Добавьте в класс `Company` метод `payTaxes()`, который:
* рассчитает с помощью выбранной этой компанией системы налогооблажения размер налогов;
* выведет сообщение на экран вида: `Компания <название> уплатила налог в размере: <сумма> руб.`;
* обнулит счётчики `debit` и `credit`.

Протестируйте работоспособность своих классов в `Main`.

## Задание 2 (НЕобязательное)

:warning: _Эта задача - усложнение первой задачи, поэтому делается в том же реплите. Как итог вы сдаёте один реплит, в которой либо первая, либо вторая задача._

Создайте в вашем проекте дополнительный класс `Deal`, объект которого будет описывать сделку, что может провернуть компания.
Каждая сделка сопровождается комментарием (`comment`), сумммой расходов (`creditChange`) и суммой доходов (`debitChange`).
Создайте конструктор, который принимает эти три параметра.

Создайте два наследника: `Sale` (продажа) и `Expenditure` (трата). Объект `Sale` должен конструироваться от названия товара и его цены, являясь сделкой с комментарием (`comment`) вида `Продажа <название товара> на <цена> руб.`, `debitChange` размером в цену и нулевым `creditChange`. Объект `Expenditure` должен конструироваться от названия товара и его цены, являясь сделкой с комментарием (`comment`) вида `Покупка <название товара> на <цена> руб.`, `creditChange` размером в цену и нулевым `debitChange`

В классе `Company` создайте метод `int applyDeals(Deal[] deals)`, в результате вызова которого:
* компания применяет все сделки из массива сделок (т.е. увеличивает `credit` на `creditChange`, `debit` на `debitChange`);
* выплачивает все налоги;
* возвращает из метода разницу доходов и расходов, которая была на момент старта уплаты налогов.

Протестируйте работоспособность своих классов в `Main`.

------

## Правила приема работы

Прикреплена только одна ссылка на один реплит с решением либо первой, либо второй задачи.

------

## Критерии оценки

1. Программа запускается и отрабатывает без ошибок
2. Программа соответствует всем требованиям из условия задачи
3. Программа работает правильно на всех примерах из условия
4. Программный код отформатирован и соответствует пройденным требованиям к качеству кода
5. Программа спроектирована достаточно логично и правильно, не противоречит общепринятым в производстве практикам и традициям
6. При наличии недочётов, в зависимости от их серьёзности и количества, работа может быть отправлена на доработку или принята; решение принимается на основе экспертной оценки работы.
