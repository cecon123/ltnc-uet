public class Main {

    public static void useString() {
        String s = "";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            s += "Hello";
        }
        long end = System.currentTimeMillis();
        System.out.println(
            "String length: " + s.length() + " | Time: " + (end - start) + "ms"
        );
    }

    public static void useStringBuffer() {
        StringBuffer sb = new StringBuffer();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sb.append("Hello");
        }
        long end = System.currentTimeMillis();
        System.out.println(
            "StringBuffer length: " +
                sb.length() +
                " | Time: " +
                (end - start) +
                "ms"
        );
    }

    public static void contentAnalysis() {
        StringBuffer text = new StringBuffer(
            "Java is a powerful language. Do you like Java? " +
                "I think Java is widely used! " +
                "However, learning Java requires practice. " +
                "Java, Java, and more Java!"
        );

        // Count the number of sentences (.|?|!).
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (
                text.charAt(i) == '.' ||
                text.charAt(i) == '?' ||
                text.charAt(i) == '!'
            ) {
                count++;
            }
        }
        System.out.println("Number of sentences: " + count);

        // Find and replace all instances of the word "Java" with "Python" (Simulate the Find & Replace feature).
        int index;
        while ((index = text.indexOf("Java")) != -1) {
            text.replace(index, index + 4, "Python");
        }

        System.out.println("Replaced text: " + text);
    }

    public static void main(String[] args) {
        useString();
        useStringBuffer();
        contentAnalysis();
    }
}
