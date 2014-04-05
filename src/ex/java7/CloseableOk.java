package ex.java7;

public class CloseableOk implements AutoCloseable {
    private final String name;
    public CloseableOk(String name) {
        this.name = name;
    }
    public void close() throws Exception {
        System.err.println("close:" + name);
    }
}
