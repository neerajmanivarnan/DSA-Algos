#!/bin/bash

# Loop through all files in the current directory and its subdirectories
find . -type f | while read -r file; do
  # Check if the file contains the word 'public'
  if grep -q "public" "$file"; then
    # Rename the file by changing its extension to .java
    mv "$file" "${file%.*}.java"
    echo "Renamed $file to ${file%.*}.java"
  fi
done

