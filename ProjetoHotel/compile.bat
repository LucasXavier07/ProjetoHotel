@echo off
echo Compilando o projeto...
javac -cp "lib/*" -d target src/main/java/main/*.java src/main/java/dao/*.java src/main/java/model/*.java
if %errorlevel% neq 0 (
    echo Erro na compilacao!
    pause
    exit /b %errorlevel%
)
echo Compilacao concluida com sucesso!
echo.
echo Para executar o programa, use: java -cp "target;lib/*" main.ReservasMaven
pause 