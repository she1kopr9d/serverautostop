# Server Auto Stop

Мод для Minecraft 1.20.1 (Fabric), который автоматически останавливает сервер после периода бездействия.

## Возможности

- Автоматическая остановка сервера через заданное время без игроков
- Настраиваемое время до остановки
- Предупреждение перед остановкой
- Настраиваемая команда остановки
- Включение/выключение функционала через конфиг

## Установка

### Для сервера

1. Установите [Fabric Loader](https://fabricmc.net/use/installer/) для Minecraft 1.20.1
2. Скачайте [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api/files/4631300)
3. Скачайте последнюю версию мода из [Releases](https://github.com/yourusername/serverautostop/releases)
4. Поместите файлы в папку `mods` вашего сервера:
   ```
   mods/
   ├── fabric-api-0.83.1+1.20.1.jar
   └── serverautostop-1.0.0.jar
   ```
5. Запустите сервер

### Настройка

При первом запуске в папке `config` будет создан файл `serverautostop.json` со следующими настройками:

```json
{
  "inactivityTimeout": 10,
  "enabled": true,
  "stopCommand": "stop",
  "warningTime": 5,
  "warningMessage": "Сервер будет остановлен через %d минут из-за отсутствия игроков"
}
```

Вы можете изменить эти настройки:
- `inactivityTimeout` - время в минутах до остановки сервера (по умолчанию 10)
- `enabled` - включен ли мод (по умолчанию true)
- `stopCommand` - команда для остановки сервера (по умолчанию "stop")
- `warningTime` - за сколько минут предупреждать об остановке (по умолчанию 5)
- `warningMessage` - сообщение предупреждения

## Сборка из исходников

### Требования

- Java 17 или выше
- Gradle 8.12.1 или выше

### Шаги сборки

1. Клонируйте репозиторий:
   ```bash
   git clone https://github.com/yourusername/serverautostop.git
   cd serverautostop
   ```

2. Соберите мод:
   ```bash
   ./gradlew build
   ```

3. Готовый JAR-файл будет находиться в `build/libs/serverautostop-1.0.0.jar`

## Разработка

### Настройка среды разработки

1. Установите [IntelliJ IDEA](https://www.jetbrains.com/idea/) или [Eclipse](https://www.eclipse.org/)
2. Клонируйте репозиторий
3. Откройте проект в вашей IDE
4. Дождитесь индексации и загрузки зависимостей

### Структура проекта

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── examplemod/
│   │               ├── ExampleMod.java
│   │               └── ModConfig.java
│   └── resources/
│       └── fabric.mod.json
build.gradle
gradle.properties
settings.gradle
```

## Лицензия

Этот проект распространяется под лицензией MIT. Подробности смотрите в файле [LICENSE](LICENSE).

## Вклад в проект

1. Форкните репозиторий
2. Создайте ветку для ваших изменений (`git checkout -b feature/amazing-feature`)
3. Зафиксируйте изменения (`git commit -m 'Add some amazing feature'`)
4. Отправьте изменения в ваш форк (`git push origin feature/amazing-feature`)
5. Создайте Pull Request
