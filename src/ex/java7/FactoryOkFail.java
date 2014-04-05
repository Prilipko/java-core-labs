package ex.java7;

public class FactoryOkFail implements AutoCloseableFactory {
    private final String name;
    public FactoryOkFail(String name) {
        this.name = name;
    }
    @Override
    public AutoCloseable create() throws Throwable {
        System.err.println("create:" + name);
        return new CloseableFail(name);
    }
}
