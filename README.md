# Три-в-ряд

Консольная игра "Три-в-ряд" на Java, спроектированная по методике Бертрана Мейера. Поле 8×8, пять
типов элементов, линейные и кросс-комбо, бонусы (удаление строки/столбца/типа),
счётчик очков и ходов.

## Структура проекта

```
src/main/java/com/oop/match_3/
├── client/      — консольный ввод/вывод
├── field/       — игровое поле (Grid, Cell, Coords, Combo)
├── gameplay/    — фазы (Phase) и шаги (Step) игрового цикла
├── statistics/  — очки, ходы, бонусы
└── math/        — UnsignedInt
```

## Технические требования

| Компонент | Версия |
|-----------|-------|
| JDK       | 21+ |
| Maven     | 3.8+ |
| ОС        | Любая с поддержкой JDK 21 (Linux / macOS / Windows) |
| Терминал  | Поддержка ANSI-escape кодов (для цветного вывода) |

Сторонние зависимости (подтягиваются Maven автоматически):

- JUnit Jupiter 5.10.2 (тесты)
- Hamcrest 2.2 (тесты)
- Maven Surefire Plugin 3.2.5

## Сборка

Из корня проекта:

```bash
# Полная сборка с прогоном тестов
mvn clean package

# Только компиляция
mvn clean compile

# Только тесты
mvn test
```

После `mvn package` собранный jar окажется в `target/match-3-1.0-SNAPSHOT.jar`.

## Запуск

Главный класс — `com.oop.match_3.client.Console`.

```bash
# Через Maven exec (после mvn compile)
mvn exec:java -Dexec.mainClass=com.oop.match_3.client.Console

# Или напрямую через java
mvn compile
java -cp target/classes com.oop.match_3.client.Console
```
