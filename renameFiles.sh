#!/bin/bash

process_files() {
    for file in "$1"/*; do
        if [ -d "$file" ]; then
            process_files "$file"
        elif [[ "$file" == *.c ]]; then
            mv "$file" "${file%.c}"
            echo "Renamed: $file -> ${file%.c}"
        fi
    done
}

directory=${1:-.}
process_files "$directory"

