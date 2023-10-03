#include <bits/stdc++.h>
using namespace std;
int distinctSubsequences(string s)
{
    int mod=1e9+7;
    int n=s.size();
    vector<int> dp(n+1,0);
    dp[0]=1;
    unordered_map<char,int> mp; 
    mp[s[0]]=0;
    for(int i=1;i<=n;i++){
        char ch=s[i-1];
        dp[i]=(dp[i-1]*2)%mod;
        if(mp.count(ch)){
        dp[i]=(dp[i]-dp[mp[ch]-1]+mod)%mod;
        }
        dp[i]%=mod;
        mp[ch]=i;
    }
    return dp[n]%mod;
}
int main() {
    string s;
    cin>>s;
    cout<<distinctSubsequences(s)<<endl;
}
