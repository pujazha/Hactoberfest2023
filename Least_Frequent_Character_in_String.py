# Python 3 code to demonstrate
# Least Frequent Character in String
# using a more efficient method

# initializing string
test_str = "GeeksforGeeks"

# printing original string
print("The original string is: " + test_str)

# using a dictionary to count frequency of characters
all_freq = {}
for char in test_str:
    all_freq[char] = all_freq.get(char, 0) + 1

# finding the least frequent character
least_frequent_char = min(all_freq, key=all_freq.get)

# printing result
print("The least frequent character in 'GeeksforGeeks' is: " + str(least_frequent_char))
