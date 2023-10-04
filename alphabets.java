public class PrintAlphabets 
{
	public static void main(String args[])
	{
		char ch;

		//printing uppercase alphabets 
		System.out.println("Uppercase alphabets:");
		for(ch='A';ch<='Z';ch++)
			System.out.print(ch + " ");

		//printing new line
		System.out.println("");

		//printing lowercase alphabets 
		System.out.println("Lowercase alphabets:");
		for(ch='a';ch<='z';ch++)
			System.out.print(ch + " ");		
	}
}
