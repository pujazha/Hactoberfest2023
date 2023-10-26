class Solution {
public:
    int lengthOfLongestSubstring(string s) 
    {   
    //   int l =0 ; int r=0 ; int count = 0;int ans =0 ; int n =s.size();
        
    //     for(;r<n;i++)
    //     {   
    //       new element enters and might make the window invalid    
    //         for(;IsWindowInvalid;l++)
    //          {
    //               try to make the window valid

    //                            TEMPLATE                                                              
    //          }
    //          ans = max( ans , r-l+1 );
    //     }
    //     return ans;



    int l =0 ; int r=0 ; int count = 0;int ans =0 ; int n =s.size();
        unordered_map<char,int>m;

        for(;r<n;r++)
        {   
            m[s[r]]++;   
            for(;m[s[r]]>1;l++)
             {
                  m[s[l]]--; 
             }
             ans = max( ans , r-l+1 );
        }
        return ans;
    }
};
