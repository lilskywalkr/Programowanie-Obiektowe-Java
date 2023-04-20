public class Main {
    public static void main(String[] args) {
        try {
            if (args.length != 3) {
                throw new Exception("Incorrect arguments");
            }

            String str = args[0];
            int start = Integer.parseInt(args[1]);
            int end = Integer.parseInt(args[2]);

            if (start < 0 || end < 0 || start >= end || end > str.length()) {
                throw new Exception("Incorrect inputs");
            }

            String result = str.substring(start, end);
            System.out.println(result);
        } catch (Exception e) {
            System.out.format("%s", e.getMessage());
        }
    }
}