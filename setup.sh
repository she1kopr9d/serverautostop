#!/bin/bash

# Удаляем старые файлы
rm -rf .git
rm -rf .gradle
rm -rf build
rm -rf gradle
rm -f gradlew
rm -f gradlew.bat
rm -f settings.gradle
rm -f build.gradle
rm -f gradle.properties

# Клонируем Fabric Example Mod
git clone https://github.com/FabricMC/fabric-example-mod.git temp
mv temp/* .
mv temp/.gitignore .
rm -rf temp

# Обновляем gradle.properties
cat > gradle.properties << EOL
# Done to increase the memory available to gradle.
org.gradle.jvmargs=-Xmx1G
org.gradle.parallel=true

# Fabric Properties
minecraft_version=1.20.1
yarn_mappings=1.20.1+build.10
loader_version=0.14.22

# Mod Properties
mod_version=1.0.0
maven_group=com.example
archives_base_name=serverautostop

# Dependencies
fabric_version=0.83.1+1.20.1
EOL

# Даем права на выполнение gradlew
chmod +x gradlew 