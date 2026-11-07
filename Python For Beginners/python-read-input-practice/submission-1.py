def add_two_numbers() -> int:
    string_list = input().split(',')
    total = 0
    for string in string_list:
        total += int(string)
    return total



# do not modify below this line
print(add_two_numbers())
print(add_two_numbers())
print(add_two_numbers())
print(add_two_numbers())
