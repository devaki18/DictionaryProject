package findPermutation;

public final class dictionary {
	
	static boolean isEnglishWord(String checkWord)
	{
		String[] validWords = { "apple", "mango", "and", "is", "with", "work", "king", "ring", "row", "know", "or", "in", "wing", "for" };
		
		for (int i = 0; i < validWords.length; i++) 
		{
			if (validWords[i].toLowerCase().equals(checkWord.toLowerCase()))
				{
						return true;
				}
		}
		return false;
	}

}
