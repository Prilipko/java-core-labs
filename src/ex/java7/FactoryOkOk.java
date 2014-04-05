package ex.java7;

public class FactoryOkOk implements AutoCloseableFactory {
    private final String name;
    public FactoryOkOk(String name) {
        this.name = name;
    }
    public AutoCloseable create() throws Throwable {
        System.err.println("create:" + name);
        return new CloseableOk(name);
    }
}
