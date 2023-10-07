# Python code to find sum of the array

# Function to find the sum of elements in an array
def find_sum(arr):
    # Initialize a variable to store the sum
    total_sum = 0
    
    # Iterate through the elements in the array
    for element in arr:
        # Add the current element to the total_sum
        total_sum += element
    
    return total_sum

# Main function
if __name__ == "__main__":
    # Input values into the array
    arr = [12, 3, 4, 15]

    # Calculate the length of the array
    n = len(arr)

    # Call the function to find the sum and store it in ans
    ans = find_sum(arr)

    # Display the sum
    print('Sum of the array is', ans)
