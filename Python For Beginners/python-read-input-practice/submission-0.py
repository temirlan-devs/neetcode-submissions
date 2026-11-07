def add_two_numbers() -> int:
    string_list = input().split(',')
    total = 0
    for str in string_list:
        total += int(str)
    return total



# do not modify below this line
print(add_two_numbers())
print(add_two_numbers())
print(add_two_numbers())
print(add_two_numbers())
