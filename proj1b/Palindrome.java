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
        int len = word.length();

        if (len == 0 || len == 1) {
            return true;
        }

        int l = 0;
        int r = len - 1;

        while (l < r) {
            if (cc.equalChars(word.charAt(l), word.charAt(r))) {
                l += 1;
                r -= 1;
            } else {
                return false;
            }
        }
        return true;
    }


}

