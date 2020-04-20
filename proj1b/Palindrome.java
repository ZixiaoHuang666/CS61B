public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> p = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            p.addLast(word.charAt(i));
        }
        return p;
    }

    public boolean isPalindrome(String word) {
        char[] p = new char[word.length()];
        char[] t = new char[word.length()];
        int j = 0;
        for (int i = 0; i < word.length(); i++) {
            p[i] = word.charAt(i);
            j = word.length() - 1 - i;
            t[j] = word.charAt(i);
        }
        for (int i = 0; i < word.length(); i++) {
            if (p[i] != t[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (!cc.equalChars(word.charAt(i), word.charAt(word.length() - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}

