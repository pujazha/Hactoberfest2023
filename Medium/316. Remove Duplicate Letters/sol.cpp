#include <string>
#include <stack>
#include <vector>

class Solution {
public:
    std::string removeDuplicateLetters(std::string s) {
        std::stack<char> charStack;
        std::vector<bool> inStack(26, false);  // To track whether a character is in the stack
        std::vector<int> lastIndex(26, 0);     // To track the last index of each character

        // Populate the lastIndex array with the last index of each character in the string
        for (int i = 0; i < s.size(); ++i) {
            lastIndex[s[i] - 'a'] = i;
        }

        for (int i = 0; i < s.size(); ++i) {
            char currentChar = s[i];

            // If the character is already in the stack, skip it
            if (inStack[currentChar - 'a']) {
                continue;
            }

            // While the stack is not empty and the current character is smaller,
            // and the last index of the character at the top of the stack is greater
            while (!charStack.empty() && currentChar < charStack.top() && i < lastIndex[charStack.top() - 'a']) {
                inStack[charStack.top() - 'a'] = false;  // Mark as not in stack
                charStack.pop();
            }

            // Push the current character onto the stack and mark it as in stack
            charStack.push(currentChar);
            inStack[currentChar - 'a'] = true;
        }

        // Pop the characters from the stack and add them to a string
        std::string result = "";
        while (!charStack.empty()) {
            result = charStack.top() + result;  // Add characters in reverse order
            charStack.pop();
        }

        return result;
    }
};
