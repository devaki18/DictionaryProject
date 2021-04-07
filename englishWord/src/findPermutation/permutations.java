package findPermutation;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import findPermutation.dictionary;

public class permutations {

	static Set<String> perm = new HashSet<String>();
	static Set<String> allWords = new HashSet<String>();
	
	static void permute(String word, int s, int e) {
		
		int i;
		if (s==e)
		{
			perm.add(word);
		}
		else
		{
			for (i=s; i<= e; i++)
			{
				String swapword = swap(word, s, i);
				permute(swapword, s+1, e);
				word = swap(swapword, s, i);
			}
		}
	}
	
	static String swap(String sword, int x, int y)
	{
		StringBuilder strB = new StringBuilder(sword);
		char l = strB.charAt(x);
		char r = strB.charAt(y);
		strB.setCharAt(x, r);
		strB.setCharAt(y, l);
		return strB.toString();
	}
	
	static void listWords()
	{
		Iterator<String> iter = perm.iterator();
		while(iter.hasNext())
		{
			StringBuilder newStrB = new StringBuilder(iter.next());
			for (int i=0; i < newStrB.length()-1; i++)
			{
				int j = i+2;
				allWords.add(newStrB.substring(0, j));
			}
		}
	}

	static void checkWord()
	{
		Iterator<String> iter = allWords.iterator();
		while(iter.hasNext())
		{
			String checkWord = iter.next();
			if (dictionary.isEnglishWord(checkWord))
			{
				System.out.println(checkWord);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
		System.out.print("Enter a string: ");  
		String str= sc.nextLine();              //reads string   
		System.out.print("You have entered: " + str + "\n");
		sc.close();
		int n = str.length();
		//System.out.print("Below are the permutation words for the entered string: \n");
		permute(str, 0, n-1);
		listWords();
		//System.out.println(allWords);
		System.out.print("Below are all the english words for the entered string: \n");
		checkWord();
	}

}
