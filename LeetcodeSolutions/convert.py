import os
import requests
import re
import shutil

def slugify_variations(name):
    """
    Generate different possible slug variations for a given filename.
    """
    s1 = re.sub('(.)([A-Z][a-z]+)', r'\1-\2', name)
    slug_basic = re.sub('([a-z0-9])([A-Z])', r'\1-\2', s1).lower()

    slug_variations = [
        slug_basic.replace('_', '-').replace(' ', '-'),
        slug_basic.replace('-', ''),
        slug_basic.replace('-', '_'),
        slug_basic.replace('_', ' '),
        slug_basic.lower()
    ]
    
    slug_variations = [re.sub(r'[^a-z0-9\-]', '', slug) for slug in slug_variations]
    
    return list(set(slug_variations))

def get_problem_info_by_slug(slug):
    url = "https://leetcode.com/graphql"
    query = """
    query getQuestionTitle($titleSlug: String!) {
      question(titleSlug: $titleSlug) {
        questionFrontendId
        title
      }
    }
    """
    variables = {
        "titleSlug": slug
    }
    headers = {
        "Content-Type": "application/json"
    }
    response = requests.post(url, json={"query": query, "variables": variables}, headers=headers)
    print(response)
    if response.ok:
        data = response.json()
        print(data)
        if data["data"]["question"]:
            return [data["data"]["question"]["title"], data["data"]["question"]["questionFrontendId"]]
    return None

def organize_files():
    for file in os.listdir('.'):
        if os.path.isfile(file):
            file_name = os.path.splitext(file)[0]  # Remove the file extension
            
            slug_variants = slugify_variations(file_name)
            found = False
            
            for slug in slug_variants:
                info = get_problem_info_by_slug(slug)
                if info:
                    question_title, question_number = info[0], info[1]
                    # Format the directory name as 'XXXX-NAME'
                    dir_name = f"{question_number.zfill(4)}-{question_title.replace(' ', '-')}"
                    os.makedirs(dir_name, exist_ok=True)
                    
                    # Move the file into the new directory
                    shutil.move(file, os.path.join(dir_name, file))
                    
                    print(f"Moved '{file}' to directory '{dir_name}'")
                    found = True
                    break

            if not found:
                print(f"No match found on LeetCode for file '{file}'.")

# organize_files()
get_problem_info_by_slug(1)

