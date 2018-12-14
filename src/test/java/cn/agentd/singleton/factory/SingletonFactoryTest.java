package cn.agentd.singleton.factory;

import org.junit.Test;

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

}