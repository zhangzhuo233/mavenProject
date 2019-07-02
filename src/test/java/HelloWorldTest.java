import org.junit.Assert;
import org.junit.Test;

public class HelloWorldTest {
    @Test
    public void sayHello() {
        Assert.assertEquals("hello world", new HelloWorld().sayHello());
    }
}