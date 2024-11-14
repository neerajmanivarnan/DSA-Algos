import os
import re
import requests
import shutil
from bs4 import BeautifulSoup

def get_problem_title_by_number(question_number):
    # Construct the URL for the LeetCode problem
    url = f"https://leetcode.com/problemset/all/?search={question_number}"
    
    response = requests.get(url)
    if response.ok:
        # Parse the HTML
        soup = BeautifulSoup(response.text, "html.parser")
        
        # Find the title element based on the question number
        problem_link = soup.find("a", href=re.compile(f"/problems/.*{question_number}.*"))
        if problem_link:
            title = problem_link.text.strip()
            return title
    return None

def organize_files():
    for file in os.listdir('.'):
        if os.path.isfile(file) and re.match(r'leetcode(\d+)', file, re.IGNORECASE):
            # Extract the question number
            question_number_match = re.search(r'leetcode(\d+)', file, re.IGNORECASE)
            if question_number_match:
                question_number = question_number_match.group(1)
                
                # Fetch the question title by question number
                question_title = get_problem_title_by_number(question_number)
                
                if question_title:
                    # Format the directory name as 'XXXX-NAME'
                    dir_name = f"{question_number.zfill(4)}-{question_title.replace(' ', '-')}"
                    os.makedirs(dir_name, exist_ok=True)
                    
                    # Move the file into the new directory
                    shutil.move(file, os.path.join(dir_name, file))
                    
                    print(f"Moved '{file}' to directory '{dir_name}'")
                else:
                    print(f"No match found for question number '{question_number}'.")

organize_files()

