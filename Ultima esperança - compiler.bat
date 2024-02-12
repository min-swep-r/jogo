@echo off
chcp 65001 > nul

:: Navega para o diretório src
cd src

:: Define a variável de ambiente JAVA_TOOL_OPTIONS para UTF-8
set JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8

:: Verifica a versão do Java instalada
for /f "tokens=3" %%i in ('java -version 2^>^&1 ^| findstr /i "version"') do set java_version=%%i

if not defined java_version (
    echo Java não encontrado. Por favor, instale o Java.
    pause
    exit /b 1
) else (
    echo Versão do Java instalada: %java_version%
)

:: Compila todos os arquivos .java na pasta src
for %%f in (*.java) do (
    javac %%f
)

:: Verifica se a compilação foi bem-sucedida
if %errorlevel% equ 0 (
    echo Compilação concluída com sucesso.
    pause
) else (
    echo Erro durante a compilação. Corrija os problemas antes de executar o programa.
    pause
)

:: Retorna ao diretório original
cd ..
