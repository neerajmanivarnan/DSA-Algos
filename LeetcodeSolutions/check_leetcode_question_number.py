import shutil
import os
import requests
import re

def slugify_variations(name):
    """
    Generate different possible slug variations for a given filename.
    """
    # Basic lowercase hyphenated (handles camelCase and PascalCase)
    s1 = re.sub('(.)([A-Z][a-z]+)', r'\1-\2', name)
    slug_basic = re.sub('([a-z0-9])([A-Z])', r'\1-\2', s1).lower()

    # Variations: lowercased with hyphens, underscores, and spaces removed
    slug_variations = [
        slug_basic.replace('_', '-').replace(' ', '-'),
        slug_basic.replace('-', ''),
        slug_basic.replace('-', '_'),
        slug_basic.replace('_', ' '),
        slug_basic.lower()
    ]
    
    # Remove non-alphanumeric characters except hyphens
    slug_variations = [re.sub(r'[^a-z0-9\-]', '', slug) for slug in slug_variations]
    
    # Ensure unique slugs in the list
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
    if response.ok:
        data = response.json()
        if data["data"]["question"]:
            return [data["data"]["question"]["title"], data["data"]["question"]["questionFrontendId"]]
    return None

def find_question_numbers_for_files():
    for file in os.listdir('.'):
        if os.path.isfile(file):
            file_name = os.path.splitext(file)[0]  # Remove the file extension
            
            # Generate slug variations for the filename
            slug_variants = slugify_variations(file_name)
            
            found = False
            for slug in slug_variants:
                info = get_problem_info_by_slug(slug)
                if info:
                    print(f"File '{file}' matches LeetCode Problem: {info[1]} - {info[0]}")
                    shutil.move(file, os.path.join("LeetcodeSolutions", file))
                    found = True
                    break
            if not found:
                print(f"No match found on LeetCode for file '{file}'.")

find_question_numbers_for_files()
