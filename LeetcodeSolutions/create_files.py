import os
import re
import requests
from bs4 import BeautifulSoup
import subprocess

def extract_num(files):
    question_number_list = []
    for file in files:
        pattern = r"(leetcode)(\w+)(.\w+)"        
        result = re.search(pattern,file)
        if result: 
            question_number_list.append(result[2])
    
    return question_number_list

#######################################



def extract_problem_name_from_url(url):
    """
    Extracts the problem name from the LeetCode URL.
    """
    if "/problems/" in url:
        start_index = url.find("/problems/") + len("/problems/")
        end_index = url.find("/", start_index)
        if end_index == -1:  # No trailing slash
            end_index = len(url)
        return url[start_index:end_index]
    return None

def get_problem_name_from_google(query):
    """
    Fetches the problem name from Google search results for a given query.
    """
    # Google search URL
    google_search_url = f"https://www.google.com/search?q={query}"
    
    # Headers to mimic a browser
    headers = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36"
    }
    
    try:
        # Make the request
        response = requests.get(google_search_url, headers=headers)
        response.raise_for_status()
    except requests.RequestException as e:
        return f"Error fetching data: {e}"

    # Parse the HTML content
    soup = BeautifulSoup(response.text, "html.parser")
    
    # Find the first link containing the LeetCode problem URL
    link = soup.find("a", href=lambda href: href and "https://leetcode.com/problems/" in href)
    
    if link:
        href = link["href"]
        problem_name = extract_problem_name_from_url(href)
        if problem_name:
            return problem_name

    return "Problem name not found"

# Example usage
















########################################

# def extract_problem_name_from_url(url):
#     """
#     Extracts the problem name from a LeetCode problem URL.
#     """
#     if "/problems/" in url:
#         start_index = url.find("/problems/") + len("/problems/")
#         end_index = url.find("/", start_index)
#         if end_index == -1:  
#             end_index = len(url)
#         return url[start_index:end_index]
#     return None
#
# def get_problem_name_from_google(query):
#     """
#     Fetches the problem name from Google search results for a given query.
#     """
#     google_search_url = f"https://www.google.com/search?q={query}"
#
#
#     headers = {
#         "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36"
#     }
#
#     try:
#         response = requests.get(google_search_url, headers=headers)
#         response.raise_for_status()
#     except requests.RequestException as e:
#         return f"Error fetching data: {e}"
#
#     soup = BeautifulSoup(response.text, "html.parser")
#
#     links = soup.find_all("a", href=True)
#
#     for link in links:
#         href = link["href"]
#         if "https://leetcode.com/problems/" in href:
#             problem_name = extract_problem_name_from_url(href)
#             if problem_name:
#                 return problem_name
#
#     return "Problem name not found"
#


files = os.listdir();
new_file_list = []

for file in files:
    if file.startswith('leetcode'):
        new_file_list.append(file)

leetcode_numbers = extract_num(new_file_list)
leetcode_query_numbers = []
just_numbers = []

for number in leetcode_numbers:
    string_new = "{} {}".format("leetcode",number)
    just_numbers.append(number)
    leetcode_query_numbers.append(string_new)

for each_query,number in zip(leetcode_query_numbers,just_numbers):
    problem_name = get_problem_name_from_google(each_query)
    print("{} : {}".format(number,problem_name))
    problem_name_array = problem_name.split('-')

    for i in range(0,len(problem_name_array)):
        problem_name_array[i] = problem_name_array[i].capitalize()

    string_part = "-".join(problem_name_array)
    
    file_name = "{}-{}".format(number,string_part)
    # print("{} : {}".format(each_query,file_name))   

    for each_file in new_file_list:
        if number in each_file:
            subprocess.run(["mkdir",file_name])            
            subprocess.run(["mv",each_file,file_name])
            # os.rename(each_file,file_name)





