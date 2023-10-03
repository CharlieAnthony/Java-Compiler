@echo off
echo ============================================
echo Cleaning old builds... 
echo(
cmd /c "gradlew -q :task1:clean"
echo(
echo Done.
echo(
echo ============================================
echo(
echo Building the project...
echo(
cmd /c "gradlew -q :task1:build"
echo(
echo Done.
echo(
echo ============================================
echo(
echo Input: Demo1.dl (5,10)
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "type .\task1\src\test.txt | .\gradlew -q :task1:run"
echo(
echo ============================================
