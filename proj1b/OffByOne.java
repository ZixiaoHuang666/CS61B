

public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        int a = x - y;
        if (a == 1 || a == -1) {
            if (x > 39 && y > 39 && x < 91 && y < 91) {
                return true;
            }
            if (x > 96 && y > 96 && x < 123 && y < 123) {
                return true;
            }
        }
        return false;
    }
}
