@echo off
chcp 65001 > nul

:: Navega para o diretório src
cd src

:: Verifica a versão do Java instalada
for /f "tokens=3" %%i in ('java -version 2^>^&1 ^| findstr /i "version"') do set java_version=%%i

if not defined java_version (
    echo Java não encontrado. Por favor, instale o Java.
    pause
    exit /b 1
) else (
    echo Versão do Java instalada: %java_version%
)

:: Compila o arquivo Main.java usando os módulos do JavaFX
javac --module-path ..\javafx-sdk-21.0.2\lib --add-modules javafx.controls,javafx.fxml Main.java

:: Verifica se a compilação foi bem-sucedida
if %errorlevel% equ 0 (
    echo Compilação concluída com sucesso.

    :: Mensagem antes de executar o código Java
    echo Executando o código Java...

    :: Executa o código Java
    java --module-path ..\javafx-sdk-21.0.2\lib --add-modules javafx.controls,javafx.fxml Main

    :: Mensagem depois de executar o código Java
    echo Código Java executado com sucesso.
    pause
) else (
    echo Erro durante a compilação. Corrija os problemas antes de executar o programa.
    pause
)

:: Retorna ao diretório original
cd ..
