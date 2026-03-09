for dir in Bai*/ ; do
    if [ -f "$dir/run.sh" ]; then
        echo "================================="
        echo "Running $dir"
        echo "================================="
        
        cd "$dir"
        chmod +x run.sh
        ./run.sh
        
        cd ..
        echo ""
    fi
done