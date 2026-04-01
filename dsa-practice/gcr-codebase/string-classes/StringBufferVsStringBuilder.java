public class StringBufferVsStringBuilder {

    public static void main(String[] args) {

        int iterations = 1_000_000;

        // -------- StringBuilder Test --------
        StringBuilder stringBuilder = new StringBuilder();
        long startBuilder = System.nanoTime();

        for (int i = 0; i < iterations; i++) {
            stringBuilder.append("hello");
        }

        long endBuilder = System.nanoTime();
        long builderTime = endBuilder - startBuilder;

        // -------- StringBuffer Test --------
        StringBuffer stringBuffer = new StringBuffer();
        long startBuffer = System.nanoTime();

        for (int i = 0; i < iterations; i++) {
            stringBuffer.append("hello");
        }

        long endBuffer = System.nanoTime();
        long bufferTime = endBuffer - startBuffer;

        // -------- Output Results --------
        System.out.println("Time taken by StringBuilder: " + builderTime + " ns");
        System.out.println("Time taken by StringBuffer : " + bufferTime + " ns");
    }
}
