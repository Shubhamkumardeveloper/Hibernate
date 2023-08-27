package edu.tyss.Country_Capital;

public class A {
	static int countNoOfWord(String s)
	{
		int count=0;
		for(int i=0;i<s.length();i++)
		{
			char ch=s.charAt(i);
			if(ch==' ')
				count++;
		}
		return count;
	}
	public static void main(String[] args) {
		String s="cat is a cat";
		s+=" ";
		String str="";
		String word="";
		String replceWord="dog";
		String newWord="";
		int count=countNoOfWord(s);
		int k=0;
		String[] strings=new String[count];
		for(int i=0;i<s.length();i++)
		{
			char ch=s.charAt(i);
			if(ch!=' ')
				word+=ch;
			
			else
			{
				strings[k++]=word;
				word="";
			}
		}
		for(int j=0;j<strings.length;j++)
		{
			String st=strings[j];
			if(st.compareTo(replceWord)==-1)
				newWord+=replceWord+" ";
			
			else
				newWord+=st+" ";
		}
		System.out.println(s);
		System.out.println(newWord);
	}
}

