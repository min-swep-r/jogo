@echo off
java Jogo/src/main/java/com/mycompany/jogo/Jogo.java
pause



tenho que colocar ele compilando com o module e depois executando. como em:

javac --module-path javafx-sdk-18.0.2/lib --add-modules javafx.controls Main.java
java --module-path javafx-sdk-18.0.2/lib --add-modules javafx.controls Main

com o Java FX que está na pasta!