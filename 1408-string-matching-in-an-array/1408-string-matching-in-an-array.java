class Solution {
	public List<String> stringMatching(String[] words) {
		List<String> result = new ArrayList<>();

		Arrays.sort(words, new java.util.Comparator<String>(){
			@Override
			public int compare(String s1, String s2){
				return s1.length() - s2.length();
			}
		});

		for (int i = 0; i < words.length; i++) {
			int mas[] = longPrefSub(words[i]);
			for (int j = i + 1; j < words.length; j++) {
				if (KMP(words[i], words[j], mas) == true) {
					result.add(words[i]);
					break;
				}
			}    
		}

		return result;
	}

	public boolean KMP(String sub, String basic, int[] mas) {
		int j = 0;

		for (int i = 0; i < basic.length(); i++) {
			char ch = basic.charAt(i);
			if (ch != sub.charAt(j)) {
				while (j > 0 && ch != sub.charAt(j))
					j = mas[j - 1];
			}

			if (ch == sub.charAt(j))
				j++;

			if (j == sub.length())
				return true;
		}

		return false;
	}


	public int[] longPrefSub(String word) {
		int[] mas = new int[word.length()];
		int j = 0;

		for (int i = 1; i < word.length(); i++) {
			char a = word.charAt(i);
			char b = word.charAt(j);
			if (a != b) {
				while (j > 0 && a != b) {
					j = mas[j - 1];
					b = word.charAt(j);
				}
			}

			if (a == b) {
				mas[i] = ++j;
			}
		}

		return mas;
	}
}