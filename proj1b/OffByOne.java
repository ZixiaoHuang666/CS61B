import org.junit.Test;

public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y){
        int a = x - y;
        if (a == 1 || a == -1) {
            return true;
        }
        return false;
    }
}
