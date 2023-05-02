REST API
на основе микро-фреймворка Spark
https://sparkjava.com/
-----------------------------------------

1) Создаем Maven-проект.

2) Подтягиваем зависимости (pom.xml).

3) Формируем пакеты, классы.

4) Запускаем
org.example.app.App

5) Для тестирования REST API, запускаем
Postman (https://www.postman.com/)


Тестируем REST API
----------------------
По умолчанию Spark работает на порту 4567.
https://sparkjava.com/documentation#embedded-web-server

1) REST-запрос на получение данных

GET http://localhost:4567/users

2) REST-запрос на создание данных
Настройки в Postman: Body, raw, JSON.

{
	"id": 1,
    "name": "Alice",
    "phone": "067 237-5599",
    "email": "ali@mail.com"
}
POST http://localhost:4567/users

Проверим
GET http://localhost:4567/users

Добавим еще объект.

{
	"id": 2,
	"name": "Tom",
	"phone": "095 147-4588",
	"email": "tom@gmail.com"
}
POST http://localhost:4567/users

{
	"id": 3,
	"name": "Olga",
	"phone": "093 368-6374",
	"email": "olga@ukr.net"
}
POST http://localhost:4567/users

{
	"id": 4,
	"name": "Kat",
	"phone": "050 147-5911",
	"email": "kat@mail.com"
}
POST http://localhost:4567/users

Проверим
GET http://localhost:4567/users

3) REST-запрос на получение данных по id

GET http://localhost:4567/users/4

4) REST-запрос на обновление данных по id.
Настройки в Postman: Body, raw, JSON.

PUT http://localhost:4567/users/3

{
	"id": 3,
	"name": "Olga",
	"phone": "093 368-6374",
	"email": "olga@gmail.com"
}

Проверим
GET http://localhost:4567/users/3

5) REST-запрос на удаление данных по id

DELETE http://localhost:4567/users/4

Проверим
GET http://localhost:4567/users

