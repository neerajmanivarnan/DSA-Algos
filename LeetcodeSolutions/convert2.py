import os
import re
import requests
import shutil

def get_problem_info_by_number(question_number):
    url = "https://leetcode.com/graphql"
    query = """
    query getQuestionTitle($questionFrontendId: String!) {
      question(questionFrontendId: $questionFrontendId) {
        questionFrontendId
        title
      }
    }
    """
    variables = {
        "questionFrontendId": question_number
    }
    headers = {
        "Content-Type": "application/json"
    }
    response = requests.post(url, json={"query": query, "variables": variables}, headers=headers)
    print(response)
    
    if response.ok:
        data = response.json()
        if data["data"]["question"]:
            title = data["data"]["question"]["title"]
            return title, question_number
    return None, question_number

def organize_files():
    for file in os.listdir('.'):
        if os.path.isfile(file) and re.match(r'leetcode(\d+)', file, re.IGNORECASE):
            # Extract the question number
            question_number_match = re.search(r'leetcode(\d+)', file, re.IGNORECASE)
            if question_number_match:
                question_number = question_number_match.group(1)
                
                # Fetch the question title by question number
                question_title, _ = get_problem_info_by_number(question_number)
                
                if question_title:
                    # Format the directory name as 'XXXX-NAME'
                    dir_name = f"{question_number.zfill(4)}-{question_title.replace(' ', '-')}"
                    os.makedirs(dir_name, exist_ok=True)
                    
                    # Move the file into the new directory
                    shutil.move(file, os.path.join(dir_name, file))
                    
                    print(f"Moved '{file}' to directory '{dir_name}'")
                else:
                    print(f"No match found for question number '{question_number}'.")

# organize_files()
get_problem_info_by_number(1)

