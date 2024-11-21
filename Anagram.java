/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1).replaceAll(" ", "");
		str2 = preProcess(str2).replaceAll(" ", "");

		if (str1.length() != str2.length()) {
			return false;
		}

		for (int i = 0; i < str1.length(); i++) {
			char currentChar = str1.charAt(i);
			int charIndex = str2.indexOf(currentChar);
			if (charIndex == -1) {
				return false;
			} else {
				str2 = str2.substring(0, charIndex) + str2.substring(charIndex + 1);
			}
		}
		return str2.isEmpty();
	}

	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if ((int) c >= 97 && (int) c <= 122){
				result += c;
			}
			else if ((int) c >= 65 && (int) c <= 90) {
				result += (char) ((int) c + 32);
			}
			else if ((int) c == 32) {
				result += c;
			}
		}
		return result;
	} 

	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String word = str;
		String anagram = "";
		for (int i = 0; i < str.length(); i++) {
			int randomIndex = (int) (Math.random() * word.length());
			anagram += word.charAt(randomIndex);
			word = word.substring(0, randomIndex) + word.substring(randomIndex + 1);
		}
		return anagram;
	}
}
