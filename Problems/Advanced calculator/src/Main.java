/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
        String operator = args[0];
        int temp = Integer.parseInt(args[1]);

        if (args.length == 2) {
            System.out.println(args[1]);
            System.exit(0);
        }

        if ("MAX".equals(operator)) {
            for (int i = 1; i < args.length; i++) {
                if (temp < Integer.parseInt(args[i])) {
                    temp = Integer.parseInt(args[i]);
                }
            }
            System.out.println(temp);
        } else if ("MIN".equals(operator)) {
            for (int i = 1; i < args.length; i++) {
                if (temp > Integer.parseInt(args[i])) {
                    temp = Integer.parseInt(args[i]);
                }
            }
            System.out.println(temp);
        } else if ("SUM".equals(operator)) {
            for (int i = 2; i < args.length; i++) {
                temp += Integer.parseInt(args[i]);
            }
            System.out.println(temp);
        }
    }
}