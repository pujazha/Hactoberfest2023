## Algorithm: Calculate Maximum Profit from Stock Prices

1. **Initialize** variables `profit` to 0 and `mini` to `Integer.MAX_VALUE`.

2. **Iterate** through the given array `prices`.

3. For each `price` in `prices`:
   - **Update** `mini` to be the minimum of the current `mini` and the current `price`. This keeps track of the minimum price encountered so far.
   - **Calculate** the profit that can be obtained by selling at the current `price` minus `mini`.
   - **Update** `profit` to be the maximum of the current `profit` and the calculated profit.

4. **Return** `profit` as the maximum profit that can be obtained.

### Explanation

- **Initialize `profit` to 0**: We start with zero profit because we haven't made any transactions yet.

- **Initialize `mini` to `Integer.MAX_VALUE`**: We set `mini` to the maximum possible integer value to ensure that the first price encountered will become the minimum.

- **Iterate through the `prices` array**: We loop through the array of stock prices.

- **Update `mini`**: At each step, we update `mini` to be the minimum of its current value and the current price. This ensures that `mini` always holds the minimum price encountered so far.

- **Calculate profit**: We calculate the profit that can be obtained by selling at the current price (`price - mini`) and update the `profit` variable with the maximum value between the current `profit` and the calculated profit. This step keeps track of the maximum profit as we traverse the prices.

- **Return `profit`**: Finally, we return the maximum profit obtained.

**Time Complexity**: The algorithm has a time complexity of O(n), where n is the length of the input array. We traverse the input array only once to populate the `mini` and `profit` variables.

**Space Complexity**: The space complexity is O(1) because we use a constant amount of extra space for the `profit` and `mini` variables, regardless of the input array size.
