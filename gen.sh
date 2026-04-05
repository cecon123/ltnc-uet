#!/bin/bash

read -p "Enter week number: " weekNumber
read -p "Enter number of lessons: " lessonCount

weekFolder="Week${weekNumber}"

mkdir -p "$weekFolder"

for ((i=1; i<=lessonCount; i++))
do
    lessonFolder=$(printf "Bai%02d" "$i")
    fullPath="$weekFolder/$lessonFolder"
    srcPath="$fullPath/src"

    mkdir -p "$srcPath"

    cat > "$fullPath/README.md" <<EOF
# $lessonFolder
EOF

    cat > "$fullPath/run.sh" <<'EOF'
#!/bin/bash
ROOT_DIR=$(pwd)
SRC_DIR="$ROOT_DIR/src"
BUILD_DIR="$ROOT_DIR/build"

mkdir -p "$BUILD_DIR"
javac -d "$BUILD_DIR" "$SRC_DIR"/*.java
java -cp "$BUILD_DIR" Main
EOF

    chmod +x "$fullPath/run.sh"

    cat > "$srcPath/Main.java" <<EOF
public class Main {
    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
EOF
done

echo "Folder structure created successfully in: $weekFolder"
