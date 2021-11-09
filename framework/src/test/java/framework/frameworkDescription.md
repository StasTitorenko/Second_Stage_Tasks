framework:
1)package 'driver' - Содержит singleton для выбора webdriver(bonigarcia)
package 'featuredCategories' - Содержит перечисления используемые в форме GoogleCalculator(используются для передачи
2)динамического локатора к обьекту)
3)package 'model' - Содержит модель GoogleCalculator
4)package 'pages'- Содержит страницы сайтов:
    package 'googleCloud':
        HomePage - домашняя страница GoogleCloud
        SearchResultsPage - страница результатов поиска
        CalculatorPage - страница GoogleCalculator
        CalculatorResultsPage - страница результатов 
    package 'tempMail'
        EmailPage - домашняя страница сайта tempmail
    AbstractPage - абстрактная страница для web страниц
5)package 'service' содержит:
    CalculatorCreator - преобразует полученный на входе propeties file в модель GoogleCalculator
    TestDataReader - прослушивает передаваемое значение -Denvironment и передаёт его в CalculatorCreator
6)package 'tests' - содержит тестовые сценарии
    CommonConditions - подготовительные шаги для последующих тестов, содержит логику открытия и закрытия браузера
- класс предок
    CorrectFillingCalculatorFormTest - smoke test для проверки правильности заполнения форму GoogleCalculator
    CostsCompareTest - тест сравнения цены полученной на сайте из GoogleCalculator и через почту
7)package 'util' содержит:
    FormatFields - утильный класс для преобразования строк полученных из модели GoogleCalculator к виду получаемому с 
сайта GoogleCalculator
    TestListener - listener событий тестов. используется для создания скриншотов необходимых кондиций
resources:
1)dev.properties - файл со значениями модели GoogleCalculator окружение=developers
2)qa.properties  - файл со значениями модели GoogleCalculator окружение=qa
3)log4j2.xml - создатель отчетов
4)testng-all.xml - suite для запуска всех тестов
5)testnh-smoke.xml - suite для запуска smoke теста
Параметры запуска
-browser_Выбор браузера для тестов(по умолчанию хром)
-environment_Выбор окружения для тестов(по умолчанию dev)
-Dsurefire.suiteXmlFiles_Выбор набора тестов (по умолчанию smoke) 