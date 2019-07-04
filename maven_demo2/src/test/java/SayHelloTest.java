import org.junit.Assert;

public class SayHelloTest {
    @org.junit.Test
    public void sayHello() {
        Assert.assertEquals("hello world", new SayHello().sayHello());
    }
}