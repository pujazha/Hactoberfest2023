vector<vector<long long int>> printPascal(int n) 
{
  vector<vector<long long int>> num;
  for (int i = 1; i <= n; i++)
  {
    vector<long long int> v1;
    for (int j = 1; j <= i; j++)
    {
      if (j==1 || j==i)
        v1.push_back(1);
      else 
        v1.push_back(num[i - 2][j - 2] + num[i - 2][j - 1]);
    }
    num.push_back(v1);
  }
  return num;
}
