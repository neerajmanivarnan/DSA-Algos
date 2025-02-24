
import csv

fi = "iv.csv"

stations  = {}
def newName(name):
    return name.upper()

# with open(fi,"r") as file:
#     reader = csv.DictReader(file)
#
#     for row in reader:
#         if row['Will you be boarding from Ernakulam Jn'] == "No":
#             # print("{} :{} ".format(row["Name"],row["Will you be boarding from Ernakulam Jn"]))
#             if row['If no, specify boarding point'] not in stations:
#                 stations[row['If no, specify boarding point']] = []
#
#             stations[row['If no, specify boarding point']].append(row["Name"])
#
# print(stations)

print(newName("neeraj"))






