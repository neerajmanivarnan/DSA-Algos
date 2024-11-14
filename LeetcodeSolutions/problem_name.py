import requests

def get_problem_name_by_number(problem_number):
    if not problem_number:
        print("Give me something useful")
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
        "titleSlug": f"{problem_number}"
    }
    headers = {
        "Content-Type": "application/json"
    }
    response = requests.post(url, json={"query": query, "variables": variables}, headers=headers)
    if response.ok:
        data = response.json()
        # print(data)
        return [data["data"]["question"]["title"],data["data"]["question"]["questionFrontendId"]]
    else:
        print("Failed to fetch data.")
        return None

print(get_problem_name_by_number("two-sum"))  # Example slug for problem 1

