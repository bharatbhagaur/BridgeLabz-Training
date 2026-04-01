class NullPointerDemo {

    // method that generates exception
    static void generateException() {
        String text = null;
        System.out.println(text.length()); // will cause exception
    }

    // method that handles exception
    static void handleException() {
        String text = null;

        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled properly");
        }
    }

    public static void main(String[] args) {

        // first call to generate exception
        // generateException();

        // refactored safe call
        handleException();
    }
}
