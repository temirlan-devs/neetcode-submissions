from typing import List

def read_integers() -> List[int]:
    string_list = input().split(',')
    int_list = []
    for string in string_list:
        int_list.append(int(string))
    return int_list

# do not modify the code below
print(read_integers())
print(read_integers())
print(read_integers())
