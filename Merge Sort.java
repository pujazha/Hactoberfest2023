
public class Main
{
    static int [] mergesort(int [] arr,int low,int high)
    {
        if(low==high)
        {
            int []base=new int [1];
            base[0]=arr[low];
            return base;
        }
        int mid=(low+high)/2;
        int a[]=mergesort(arr,low,mid);
        int b[]=mergesort(arr,mid+1,high);
        int []ans=merge(a,b);
        return ans;
    }
    static int[] merge(int []a,int []b)
    {
        int i,j,k;
        int []res=new int[a.length+b.length];
        for( i=0,j=0,k=0;i<a.length && j<b.length ;k++)
        {
                if(a[i]<b[j])
                {
                    res[k]=a[i];
                    i++;
                }
                else
                {
                    res[k]=b[j];
                    j++;
                }
        }
         while (i < a.length)
            res[k++] = a[i++];
         while (j < b.length)
            res[k++] = b[j++];
        return res;
    }
	public static void main(String[] args) 
	{
		int []arr={2,7,3,10,9,50,37,11,0};
		int []res=mergesort(arr,0,arr.length-1);
		for(int i:res)
		{
		    System.out.print(i+ ",");
		}
	}
}
