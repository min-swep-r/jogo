#!/bin/bash

# Verifica a versão do Java instalada
java_version=$(java --version 2>&1 | awk '/version/ {print $3}')

if [[ -z "$java_version" ]]; then
    echo "Java não encontrado. Por favor, instale o Java."
    exit 1
else
    echo "Versão do Java instalada: $java_version"
fi

# Compila o arquivo src/Main.java usando os módulos do JavaFX
javac --module-path javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.fxml src/Main.java

# Verifica se a compilação foi bem-sucedida
if [ $? -eq 0 ]; then
    echo "Compilação concluída com sucesso."

    # Executa o código Java
    java --module-path javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.fxml src.Main
else
    echo "Erro durante a compilação. Corrija os problemas antes de executar o programa."
fi
