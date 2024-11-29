#include <bits/stdc++.h>

void setZeros(vector<vector<int>> &matrix)
{
	// Write your code here.
	    int m = matrix.size(), n = matrix[0].size();
    // cout << "m = " << m << endl;
    // cout << "n = " << n << endl;
    vector<int> row, col;

    
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (matrix[i][j] == 0) {
                row.push_back(i);
                col.push_back(j);
            }
        }
        
    }

    // cout << "Task 1 done\n";

    // // o/p col
    // for (int i = 0; i < c; i++)
    // {
    //     cout << col[i] << "\t";
    // }
    // cout << endl << "O/P\n";
    
    
    for (int i = 0; i < col.size(); i++)
    {
        for (int j = 0; j < m; j++)
        {
            matrix[j][col[i]] = 0;
        }
    }
    for (int i = 0; i < row.size(); i++)
    {
        for (int j = 0; j < n; j++)
        {
            matrix[row[i]][j] = 0;
        }
    }
}
