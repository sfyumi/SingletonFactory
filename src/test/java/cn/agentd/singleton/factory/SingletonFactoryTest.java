package cn.agentd.singleton.factory;

import org.junit.Test;

import java.util.function.Supplier;

import static org.junit.Assert.*;

/**
 * SingletonFactory test class
 */
public class SingletonFactoryTest {

    @Test
    public void test() {
        Singleton instance = SingletonFactory.getInstance(Singleton.class);
        assertEquals(instance.getName(), "singleton");
    }

    @Test
    public void testMethodReference() {
        Singleton instance = SingletonFactory.getInstance(Singleton.class, Singleton::new);
        assertEquals(instance.getName(), "singleton");
    }

    @Test
    public void testSupplier() {
        Singleton instance = SingletonFactory.getInstance(Singleton.class,
                () -> new Singleton("supplier"));
        assertEquals(instance.getName(), "supplier");
    }
}