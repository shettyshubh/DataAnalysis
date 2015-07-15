cwd=$(pwd)
cd src
javac *.java
java WordCounter $cwd
java MedianCalculator $cwd


