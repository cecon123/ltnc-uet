ROOT_DIR=$(pwd)
SRC_DIR="$ROOT_DIR/src"
BUILD_DIR="$ROOT_DIR/build"

mkdir -p "$BUILD_DIR"
javac -encoding UTF-8 -d "$BUILD_DIR" "$SRC_DIR"/*.java
java -Dfile.encoding=UTF-8 -cp "$BUILD_DIR" Main
