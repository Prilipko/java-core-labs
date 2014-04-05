package ex.java7;

public class FactoryFail implements AutoCloseableFactory {
    private final String name;
    public FactoryFail(String name) {
        this.name = name;
    }
    public AutoCloseable create() throws Throwable {
        System.err.println("create:" + name);
        throw new Error("create:" + name);
    }
}
