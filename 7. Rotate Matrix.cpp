#include <bits/stdc++.h>

void rotateMatrix(vector<vector<int>> &mat, int n, int m) {
    int rowStart = 0, colStart = 0;
    int previous, current;
    
    while (rowStart < n && colStart < m) {
        if (rowStart == n - 1 || colStart == m - 1) {
            break;
        }
        
        previous = mat[rowStart + 1][colStart];
        
        for (int i = colStart; i < m; i++) {
            current = mat[rowStart][i];
            mat[rowStart][i] = previous;
            previous = current;
        }
        
        rowStart++;
        
        for (int i = rowStart; i < n; i++) {
            current = mat[i][m - 1];
            mat[i][m - 1] = previous;
            previous = current;
        }
        
        m--;
        
        if (rowStart < n) {
            for (int i = m - 1; i >= colStart; i--) {
                current = mat[n - 1][i];
                mat[n - 1][i] = previous;
                previous = current;
            }
        }
        
        n--;
        
        if (colStart < m) {
            for (int i = n - 1; i >= rowStart; i--) {
                current = mat[i][colStart];
                mat[i][colStart] = previous;
                previous = current;
            }
        }
        
        colStart++;
    }
}
