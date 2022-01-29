# 19. REST API. Подключаем Allure
http://demowebshop.tricentis.com

* Автоматизируем проверку ui-взаимодействия по api
* Добавляем Allure-listener
* Добавляем шаблоны для более красивого отчета в Allure Report 
* Логируем деnализацию запросов в лог 
* Используем спецификации

## 🚀 Зупуск теста локально
Необходимо создать файл `credential.properties`, в котором указать:
- `cookie` (Nop.customer)
- `login` и `password` от учётной записи на сайте http://demowebshop.tricentis.com
- `firstName`, `lastName`, `email` - данные указанные в профиле

## 🚀 Запуск теста удалённо 
* Открыть сборку [Jenkins](https://jenkins.autotests.cloud/job/009_qaguru_j_unicorn_hw19_Demowebshop(API+UI)/)
* Нажать **"Собрать сейчас"**.

##  Отчет о результатах тестирования в Allure Report
![image](https://user-images.githubusercontent.com/93325839/151679382-de399d64-43fc-43f5-9065-073c0b1eb228.png)

## Видео прохождения тестов в Selenoid
https://user-images.githubusercontent.com/93325839/151679836-ea4c78c6-6329-484e-9af2-1a8a6e65cf52.mp4

## Интеграция тестов c тест-менеджмент системой [Allure TestOps](https://allure.autotests.cloud/project/935/dashboards/1787)
![image](https://user-images.githubusercontent.com/93325839/151679452-62846ea8-3288-4a9e-9584-e8b3641b6ced.png)

## Уведомления о прохождении тестов в Telegram 
![image](https://user-images.githubusercontent.com/93325839/151679601-7b8647ef-9e33-48b0-9ea7-7aeaa702b5dc.png)
