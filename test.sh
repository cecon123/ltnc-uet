#!/bin/bash

if [ $# -eq 2 ]; then
    WEEK=$1
    EXERCISE=$2
else
    read -p "Week: " WEEK
    read -p "Exercise: " EXERCISE
fi

DIR="Week${WEEK}/Bai$(printf '%02d' "$EXERCISE")"

if [ ! -d "$DIR" ]; then
    echo "Directory $DIR not found!"
    exit 1
fi

if [ ! -f "$DIR/run.sh" ]; then
    echo "No run.sh found in $DIR!"
    exit 1
fi

echo "================================="
echo "Running $DIR"
echo "================================="

cd "$DIR"
chmod +x run.sh
./run.sh
