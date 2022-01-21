
# Приложение для тех, кто не доверяет одному сайту погоды :)

# Погодник написан с использованием фрэймворка Spring Boot, в качестве БД выступает Postgres.

# `Принцип работы:`
Приложение обращается к API двух разных сервисов погоды и выдает средний результат всех показателей в общем классе.

API:
* Для того, чтобы получить ответ от одного из сервисов:

`GET/openweather/{cityName}` 

`GET/weatherapi/{cityName}` - где cityName название города, о котором хотите получить данные погоды.

Ответ приходит только с необходимой информацией о погоде, без тысячи ненужных данных :)

Данные этих запросов напрямую выдают результат с сервиса и не сохраняются в базе данных.

* Для того, чтобы сохранить результат достаточно получить ответ и вставить его в тело запроса:

`POST/openweather`

`POST/weatherapi` - результатом таких запросов является сохранение объектов в базу данных.

Теперь перейдём к самой интересной части приложения :)

* Для того чтобы создать объект в котором будет храниться средний результат `двух разных сервисов`(т. к. объект создается на основе двух разных классов), нужно указать Id в POST запросе, по которым связаны объекты в базе данных:

`POST/generalweather/{id}` - в БД будет создан объект и связан с остальными по Id (при создании объекта данные уже берутся из имеющихся в базе, а не напрямую из API сервисов).

* Для того, чтобы получить результат необходимо просто обратиться к БД, через GET метод и передать название города:

`GET/generalweather/{cityName}` - тут Ваш ответ от сервера, с желаемым результатом :)

