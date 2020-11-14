class Application {

    String name;

    void run(String[] args) {
        this.name = name;
        System.out.println(name);
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}