@echo off
echo Executando o programa...
java -cp "target;lib/*" main.ReservasMaven
if %errorlevel% neq 0 (
    echo Erro na execucao!
    pause
    exit /b %errorlevel%
)
pause 