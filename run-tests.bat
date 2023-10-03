@echo off
echo ============================================
echo Cleaning old builds... 
echo(
cmd /c "gradlew -q clean & rd /s /q .gradle"
echo(
echo Done.
echo(
echo ============================================
echo(
echo Building the project...
echo( 
cmd /c "gradlew -q build"
echo(
echo Done.
echo(
echo ============================================
echo(
echo Input expression:
echo(
echo 3 + 5.0
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "echo 3 + 5.0 | gradlew -q :task1:run"
echo(
echo ============================================
echo(
echo Input expression:
echo(
echo 12.0 - 3.0 * 5.0
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "echo 12.0 - 3.0 * 5.0 | gradlew -q :task2:run"
echo(
echo ============================================
echo(
echo Input expression:
echo(
echo 13 - (4 + 7) + 2 * 2
echo(
echo ---------------------
echo(
echo Output:
echo(
cmd /c "echo 13 - (4 + 7) + 2 * 2 | gradlew -q :task1:run"
echo(
echo ============================================
echo If the outputs above are
echo(
echo Incompatible operands: the types of two operands must agree.
echo -3.0
echo 6.0
echo(
echo then tests passed.
