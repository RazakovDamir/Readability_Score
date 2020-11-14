class Problem {
    public static void main(String[] args) {
        String test = "test";
        boolean f = false;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals(test)) {
                System.out.println(i);
                f = true;
            }
        }
        if (!f) {
            System.out.println("-1");
        }
    }
}