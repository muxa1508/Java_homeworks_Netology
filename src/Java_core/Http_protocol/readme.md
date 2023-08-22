### Задание
По адресу https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats находится список фактов о кошках. 
Наша задача - сделать запрос к этому ресурсу и отфильтровать факты, за которые никто не проголосовал (поле upvotes). 
Формат каждой записи следующий:

```java
{
    "id": "5b4910ae0508220014ccfe91",
    "text": "Кошки могуть создавать более 100 разных звуков, тогда как собаки только около 10.",
    "type": "cat",
    "user": "Alex Petrov",
    "upvotes": null
},
```
```java
id - уникальный идентификатор записи
text - сообщение
type - тип животного
user - имя пользователя
upvotes - голоса
```
Программа должна прочитать весь список и вернуть только те факты, у которых поле upvotes не равно `null` или нулю.

Перед тем как начать откройте url https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats 
в браузере и посмотрите на данные;

Создайте проект `maven` и добавьте в `pom.xml` библиотеку `apache httpclient`.
Пример:

```java
<dependency>
    <groupId>org.apache.httpcomponents</groupId>
    <artifactId>httpclient</artifactId>
    <version>4.5.12</version>
</dependency>
```
Создайте метод в который добавьте и настройте класс `CloseableHttpClient` например с помощью builder

```java
CloseableHttpClient httpClient = HttpClientBuilder.create()
    .setDefaultRequestConfig(RequestConfig.custom()
        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
        .build())
    .build();
```
Добавьте объект запроса 
`HttpGet request = new HttpGet("https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats")` 
и вызовите удаленный сервис `CloseableHttpResponse response = httpClient.execute(request);`

Добавьте в `pom.xml` библиотеку для работы с json
Пример:

```java
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.11.1</version>
</dependency>
```
Создайте класс, в который будем преобразовывать json ответ от сервера. 
Преобразуйте json в список java объектов. 
Отфильтруйте список - например, средствами stream api. 
Выведите результат на экран.

Гит коммит и пуш в публичный репозиторий. Отправьте репо с решением на проверку.