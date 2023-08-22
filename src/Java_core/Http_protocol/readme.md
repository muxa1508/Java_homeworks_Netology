### �������
�� ������ https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats ��������� ������ ������ � ������. 
���� ������ - ������� ������ � ����� ������� � ������������� �����, �� ������� ����� �� ������������ (���� upvotes). 
������ ������ ������ ���������:

```java
{
    "id": "5b4910ae0508220014ccfe91",
    "text": "����� ������ ��������� ����� 100 ������ ������, ����� ��� ������ ������ ����� 10.",
    "type": "cat",
    "user": "Alex Petrov",
    "upvotes": null
},
```
```java
id - ���������� ������������� ������
text - ���������
type - ��� ���������
user - ��� ������������
upvotes - ������
```
��������� ������ ��������� ���� ������ � ������� ������ �� �����, � ������� ���� upvotes �� ����� `null` ��� ����.

����� ��� ��� ������ �������� url https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats 
� �������� � ���������� �� ������;

�������� ������ `maven` � �������� � `pom.xml` ���������� `apache httpclient`.
������:

```java
<dependency>
    <groupId>org.apache.httpcomponents</groupId>
    <artifactId>httpclient</artifactId>
    <version>4.5.12</version>
</dependency>
```
�������� ����� � ������� �������� � ��������� ����� `CloseableHttpClient` �������� � ������� builder

```java
CloseableHttpClient httpClient = HttpClientBuilder.create()
    .setDefaultRequestConfig(RequestConfig.custom()
        .setConnectTimeout(5000)    // ������������ ����� �������� ����������� � �������
        .setSocketTimeout(30000)    // ������������ ����� �������� ��������� ������
        .setRedirectsEnabled(false) // ����������� ��������� ��������� � ������
        .build())
    .build();
```
�������� ������ ������� 
`HttpGet request = new HttpGet("https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats")` 
� �������� ��������� ������ `CloseableHttpResponse response = httpClient.execute(request);`

�������� � `pom.xml` ���������� ��� ������ � json
������:

```java
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.11.1</version>
</dependency>
```
�������� �����, � ������� ����� ��������������� json ����� �� �������. 
������������ json � ������ java ��������. 
������������ ������ - ��������, ���������� stream api. 
�������� ��������� �� �����.

��� ������ � ��� � ��������� �����������. ��������� ���� � �������� �� ��������.