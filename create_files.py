import os
import re
import requests
from bs4 import BeautifulSoup

# Function to get question title from a problem slug
def get_question_title_by_number(question_number):
    url = f"https://leetcode.com/problems/{question_number}/"
    response = requests.get(url)
    
    if response.ok:
        soup = BeautifulSoup(response.text, 'html.parser')
        title_tag = soup.find('title')
        
        if title_tag:
            title = title_tag.text.strip()
            # Remove the extra "LeetCode" part from the title
            title = title.replace(' - LeetCode', '')
            return title
    return None

# Function to normalize filenames and retrieve question number
def normalize_filename(filename):
    # Remove extensions and make filename lowercase for easier matching
    base_name = os.path.splitext(filename)[0].lower()
    
    # Mapping of common patterns or parts of filenames to problem numbers
    # This should be a broader mapping based on the filenames you encounter
    patterns = {
        "two-sum": "1",
        "addtwo": "2",
        "longestsubstring": "3",
        "twosum": "1",
        "coinchange": "322",
        "combination": "39",
        "mostwater": "11",
        "polishnotation": "150",
        "jumpgame": "55",
        # Add other mappings here as needed
    }
    
    # Check for a match in the patterns
    for pattern, number in patterns.items():
        if pattern in base_name:
            return number  # Return the question number

    return None  # No match found

# Function to move the file to the new directory based on the question number
def move_file_to_question_directory(filename, question_number):
    question_title = get_question_title_by_number(question_number)
    
    if question_title:
        directory_name = f"{question_number}-{question_title.replace(' ', '-')}"
        os.makedirs(directory_name, exist_ok=True)  # Create directory if it doesn't exist
        destination_path = os.path.join(directory_name, filename)
        
        os.rename(filename, destination_path)  # Move the file to the directory
        print(f"Moved {filename} to {directory_name}")
    else:
        print(f"Could not find title for question {question_number}")

# Main function to process files
def process_files_in_directory():
    files = os.listdir(".")  # Get list of files in current directory

    for filename in files:
        if filename.endswith(".java") or filename.endswith(".py"):  # You can add other file types here
            question_number = normalize_filename(filename)
            
            if question_number:
                print(f"Processing file: {filename}, Question Number: {question_number}")
                move_file_to_question_directory(filename, question_number)
            else:
                print(f"No match found for file: {filename}")

# Run the script
if __name__ == "__main__":
    process_files_in_directory()

