inputs = input()

n , m , k = map(int,inputs.split())

size = input()
size_of_apartments = size.split()

room = input()
room_size = room.split()

count = 0

size_of_apartments.sort()
room_size.sort()

for size in size_of_apartments:
    for room in room_size:
        if room <= size - k:
            count+=1

print(count)

