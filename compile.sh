find * -name "*.java" > sources.txt
javac @sources.txt
rm -f sources.txt