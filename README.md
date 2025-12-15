# 🚀 Selenium & Appium Test Automation Project

![Java](https://img.shields.io/badge/Java-25-orange)
![Selenium](https://img.shields.io/badge/Selenium-4.20.0-green)
![TestNG](https://img.shields.io/badge/TestNG-7.9.0-blue)
![Maven](https://img.shields.io/badge/Maven-3.9.11-red)

## 📋 Описание проекта
Проект автоматизированного тестирования для веб-сайта Wikipedia и мобильного приложения Wikipedia. Реализован в рамках учебного задания по автоматизации тестирования.

## 🎯 Цели проекта
- Реализация автоматизированных тестов для веб-приложения
- Создание тестов для мобильного приложения
- Использование Page Object Model
- Настройка CI/CD готового проекта

## 🏗️ Структура проекта

selenium-appium-project/
├── 📁 src/
│   ├── 📁 main/
│   │   └── 📁 java/org/example/
│   │       └── 📁 utils/
│   │           └── 📄 ConfigReader.java          # Чтение конфигурации
│   │
│   └── 📁 test/
│       └── 📁 java/org/example/
│           ├── 📁 pages/                         # Page Object Model
│           │   ├── 📁 web/                       # Веб-страницы
│           │   │   ├── 📄 BasePage.java
│           │   │   ├── 📄 HomePage.java          # Главная страница
│           │   │   ├── 📄 SearchPage.java        # Страница поиска
│           │   │   └── 📄 ArticlePage.java       # Страница статьи
│           │   │
│           │   └── 📁 mobile/                    # Мобильные экраны
│           │       ├── 📄 BasePage.java
│           │       ├── 📄 WelcomePage.java       # Экран приветствия
│           │       ├── 📄 SearchPage.java        # Поиск в приложении
│           │       └── 📄 ArticlePage.java       # Статья в приложении
│           │
│           ├── 📁 tests/                         # Тестовые классы
│           │   ├── 📁 web/
│           │   │   └── 📄 WikipediaWebTests.java # 5 веб-сценариев
│           │   │
│           │   └── 📁 mobile/
│           │       └── 📄 WikipediaAppTests.java # 5 мобильных сценариев
│           │
│           └── 📁 utils/                         # Утилиты
│               ├── 📄 DriverManager.java         # Управление WebDriver
│               └── 📄 AppiumDriverManager.java   # Управление Appium
│
├── 📁 resources/
│   ├── 📄 config.properties                      # Конфигурация
│   └── 📁 testng/                                # Конфигурация TestNG
│       ├── 📄 web-tests.xml
│       └── 📄 mobile-tests.xml
│
├── 📄 pom.xml                                    # Maven конфигурация
├── 📄 .gitignore                                 # Игнорируемые файлы
├── 📄 README.md                                  # Документация
└── 📁 screenshots/                               # Скриншоты результатов

## 🧪 Веб-тесты (5 реализованных сценариев)
1. ✅ **Загрузка главной страницы** - проверка доступности Wikipedia
2. ✅ **Функциональность поиска** - поиск статей по ключевым словам
3. ✅ **Открытие статьи** - переход к статье из результатов поиска
4. ✅ **Проверка контента** - валидация содержимого страницы
5. ✅ **Навигация по сайту** - проверка перехода между страницами

## 📱 Мобильные тесты (5 сценариев)
1. ✅ **Описание тестов** - документация мобильных тестов
2. ✅ **Поиск статьи** - сценарий поиска в мобильном приложении
3. ✅ **Главный экран** - проверка отображения интерфейса
4. ✅ **Открытие статьи** - навигация к контенту
5. ✅ **Прокрутка** - тестирование скроллинга

## 🛠️ Технологии
- **Java 25** - основной язык программирования
- **Selenium WebDriver 4.20.0** - автоматизация веб-браузера
- **TestNG 7.9.0** - фреймворк для тестирования
- **Appium 9.2.2** - автоматизация мобильных приложений
- **Maven** - управление зависимостями и сборка
- **WebDriverManager** - автоматическая загрузка драйверов

## 🚀 Запуск тестов

### Предварительные требования
- JDK 11 или выше
- Maven 3.6+
- Google Chrome
- (Для мобильных тестов) Appium Server, Android эмулятор

### Команды для запуска
```bash

# Сборка проекта
mvn clean compile

# Запуск всех тестов
mvn test

# Запуск только веб-тестов
mvn test -Dtest=WikipediaWebTests

# Запуск только мобильных тестов (требует Appium)
mvn test -Dtest=WikipediaAppTests
