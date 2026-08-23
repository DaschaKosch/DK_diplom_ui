<div align="center">
  <h1 style="color: #1BA8A8;">
    Дипломный проект по автоматизации тестирования сайта <br> 
    <a href="https://befree.ru/" target="_blank" style="color: inherit; text-decoration: none;">
      👗 BEEFREE
    </a>
  </h1>
</div>

## <span style="color: #1BA8A8;">☑️</span> Содержание

- Технологии и инструменты
- Список проверок, реализованных в тестах
- Запуск тестов (сборка в Jenkins) / терминал
- Allure-отчет
- Интеграция с Allure TestOps
- Интеграция с Atlassian Jira
- Уведомление в Telegram о результатах прогона тестов

<a id="tools"></a>
## :ballot_box_with_check:Технологии и инструменты

| Java                                                                                                      | IntelliJ  <br>  Idea                                                                                               | GitHub                                                                                                     | JUnit 5                                                                                                           | Gradle                                                                                                     | Selenide                                                                                                         | Selenoid                                                                                                                  | Allure <br> Report                                                                                                         |  Jenkins                                                                                                        |   Jira                                                                                                              | Telegram                                                                                                            |Allure <br> TestOps                                                                                                          
|:----------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------:|
| <a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>  | <a href="https://www.jetbrains.com/idea/"><img src="images/logo/Idea.svg" width="50" height="50"  alt="IDEA"/></a> | <a href="https://github.com/"><img src="images/logo/GitHub.svg" width="50" height="50"  alt="Github"/></a> | <a href="https://junit.org/junit5/"><img src="images/logo/Junit5.svg" width="50" height="50"  alt="JUnit 5"/></a> | <a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a> | <a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a> | <a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a> | <a href="https://github.com/allure-framework"><img src="images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a> |<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a> | <a href="https://www.atlassian.com/software/jira/"><img src="images/logo/Jira.svg" width="50" height="50" alt="Java" title="Java"/></a> | <a href="https://web.telegram.org/"><img src="images/logo\Telegram.svg" width="50" height="50" alt="Telegram"/></a> |<a href="https://qameta.io/"><img src="images/logo\Allure_TO.svg" width="50" height="50" alt="Allure_TO"/></a> |

<a id="cases"></a>
## :ballot_box_with_check: Реализованные проверки

- Проверка хэдера на главной странице
- Поиск товара через строку поиска
- Открытие корзины
- Переход в каталог 'Женское' с главной страницы
- Проверка отображения списка товаров в каталоге
- Открытие страницы товара из каталога
- Проверка пустой корзины при переходе с главной
- Добавление товара в корзину
- Удаление товара из корзины


## <img alt="Jenkins" height="25" src="images/logo/Jenkins.svg" width="25"/> Сборка в [Jenkins](https://jenkins.qa.guru/view/java-students/job/41_DK_UI/)

<p align="center">  
<img src="images/screen/Jenkins.png" alt="Jenkins" width="950"/></a>  
</p>



## :ballot_box_with_check: Параметры сборки в Jenkins:

- browser (браузер, по умолчанию chrome)
- browserVersion (версия браузера, по умолчанию 128.0)
- browserSize (размер окна браузера, по умолчанию 1920x1080)


## Команда для запуска из терминала

Удаленный запуск с использованием Jenkins+Selenoid(требуется логин и пароль):
```bash  
clean test -Denv=ci
```


## <img alt="Allure" height="25" src="images/logo/Allure.svg" width="25"/></a>  <a name="Allure"></a>Allure Report	</a>


## Основная страница отчёта

<p align="center">  
<img src="images/screen/Основная страница Allure.png" src="images/logo/Allure.svg" width="850">  
</p>  

## Сьюты

<p align="center">  
<img title="Allure Tests" src="images/screen/Allure сьют.png" width="850">  
<p align="center">  
<img title="Allure Tests" src="images/screen/Allure сьют 2.png" width="850">  

</p>

## Graphs

<p align="center">  
<img title="Allure Tests" src="images/screen/Graphs.png" width="850">  
</p>


## <img alt="Allure_TO" height="25" src="images/logo/Allure_TO.svg" width="25"/> </a>Интеграция с Allure TestOps</a>

## Allure TestOps Запуски

<p align="center">  
<img title="Allure Tests" src="images/screen/TestOps 1.png" width="850">  
</p>  

## Авто и Ручные тест-кейсы

<p align="center">  
<img title="Allure Graphics" src="images/screen/TestOps кейсы.png" width="850">   
</p>

## <img alt="Allure" height="25" src="images/logo/Jira.svg" width="25"/></a> Интеграция с <a target="_blank" href="https://jira.qa.guru/browse/MUL-33">Jira</a>

<p align="center">  
<img title="Jira" src="images/screen/Jira1.png" width="">  
</p>
<p align="center">  
<img title="Jira" src="images/screen/Jira2.png" width="">  
</p>

____
## <img alt="Allure" height="25" src="images/logo/Telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота
____
<p align="center">  
<img title="Allure Overview Dashboard" src="images/screen/Телега.png" width="550">  
</p>
