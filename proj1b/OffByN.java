public class OffByN implements CharacterComparator {
    private int size;

    public OffByN(int size) {
        this.size = size;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == size;
    }
}
