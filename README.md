# Server Auto Stop

[![Latest Release](https://img.shields.io/github/v/release/yourusername/serverautostop?style=for-the-badge)](https://github.com/yourusername/serverautostop/releases/latest)
[![Minecraft Version](https://img.shields.io/badge/Minecraft-1.20.1-green?style=for-the-badge)](https://www.minecraft.net)
[![Fabric API](https://img.shields.io/badge/Fabric%20API-0.83.1-blue?style=for-the-badge)](https://www.curseforge.com/minecraft/mc-mods/fabric-api)

## 📥 Быстрый старт

1. **Скачайте последнюю версию мода**:
   - Перейдите в [раздел релизов](https://github.com/yourusername/serverautostop/releases/latest)
   - Скачайте файл `serverautostop-1.0.0.jar`

2. **Установите зависимости**:
   - [Fabric Loader](https://fabricmc.net/use/installer/) для Minecraft 1.20.1
   - [Fabric API 0.83.1+1.20.1](https://www.curseforge.com/minecraft/mc-mods/fabric-api/files/4631300)

3. **Установка**:
   ```
   mods/
   ├── fabric-api-0.83.1+1.20.1.jar
   └── serverautostop-1.0.0.jar
   ```

4. **Запустите сервер** - мод начнет работать автоматически!

## ⚙️ Настройка

При первом запуске в папке `config` будет создан файл `serverautostop.json`:

```json
{
  "inactivityTimeout": 10,    // Время до остановки (минуты)
  "enabled": true,            // Включен ли мод
  "stopCommand": "stop",      // Команда для остановки
  "warningTime": 5,           // Время предупреждения (минуты)
  "warningMessage": "Сервер будет остановлен через %d минут из-за отсутствия игроков"
}
```

## 📋 Возможности

- 🕒 Автоматическая остановка сервера через заданное время без игроков
- ⚙️ Настраиваемое время до остановки
- 🔔 Предупреждение перед остановкой
- 🛑 Настраиваемая команда остановки
- ✅ Включение/выключение функционала через конфиг

## 🛠️ Сборка из исходников

### Требования
- Java 17 или выше
- Gradle 8.12.1 или выше

### Шаги сборки
```bash
git clone https://github.com/yourusername/serverautostop.git
cd serverautostop
./gradlew build
```
Готовый JAR-файл будет в `build/libs/`

## 🤝 Вклад в проект

1. Форкните репозиторий
2. Создайте ветку (`git checkout -b feature/amazing-feature`)
3. Зафиксируйте изменения (`git commit -m 'Add some amazing feature'`)
4. Отправьте изменения (`git push origin feature/amazing-feature`)
5. Создайте Pull Request

## 📄 Лицензия

Этот проект распространяется под лицензией MIT. Подробности в файле [LICENSE](LICENSE).
