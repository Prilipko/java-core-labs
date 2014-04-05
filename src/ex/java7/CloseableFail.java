package ex.java7;

public class CloseableFail implements AutoCloseable {
    private final String name;
    public CloseableFail(String name) {
        this.name = name;
    }
    public void close() throws Exception {
        System.err.println("close:" + name);
        throw new Error("close:" + name);
    }
}
