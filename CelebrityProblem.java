//Function to find if there is a celebrity in the party or not.
class CelebrityProblem
{ 
  
    int celebrity(int M[][], int n)
    {
    	// code here 
    	int ind=-1;
    	boolean flag=true;
    	int count=0;
    	for(int i=0; i<n; i++)
    	{
    	    flag=true;
    	    for(int j=0; j<n; j++)
    	    {
    	        if(M[i][j]==1)
    	        {
    	            flag=false;
    	        }
    	    }
    	    if(flag)
    	    {
    	        ind=i;
    	        count++;
    	    }
    	}
    	if(count==1)
    	{
    	    return ind;
    	}
    	else
    	{
    	    return -1;
    	}
    }
}
