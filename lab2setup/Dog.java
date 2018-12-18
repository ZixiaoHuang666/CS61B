public class Dog {
    private int size;

    public Dog(int s) {
        size = s;
    }

    public void bark(){
        System.out.println("Moo");
    }
    public static void runFast(){
        System.out.println("Ruff Run");
    }

    /** Makes a noise. */
    public String noise() {
        if (size < 10) {
            return "yip";
        } 
        return "bark";
    }
}
