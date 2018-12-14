package cn.agentd.singleton.factory;

import cn.agentd.singleton.factory.exception.InstanceInitialException;
import cn.agentd.singleton.factory.exception.NoParameterlessConstructorException;

import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;

/**
 * SingletonFactory creates singleton instance of a class.
 *
 * The class must has a parameterless constructor, no matter private or public.
 *
 */
public class SingletonFactory {
    private static volatile ConcurrentHashMap<String, Object> singletonMap = new ConcurrentHashMap<>();

    @SuppressWarnings("unchecked")
    public static <T> T getInstance(Class<T> clazz) {
        Object instance = singletonMap.get(clazz.getCanonicalName());
        if (instance == null) {
            synchronized (clazz.getCanonicalName()) {
                instance = singletonMap.get(clazz.getCanonicalName());
                if (instance == null) {
                    try {
                        Constructor<?> constructor = getParameterlessConstructor(clazz);
                        constructor.setAccessible(true);
                        instance = constructor.newInstance();
                        singletonMap.put(clazz.getCanonicalName(), instance);
                    } catch (Exception e) {
                        throw new InstanceInitialException(clazz, e);
                    }
                }
            }
        }

        return (T) instance;
    }

    private static Constructor<?> getParameterlessConstructor(Class<?> clazz) {
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            if (constructor.getParameters().length == 0) {
                return constructor;
            }
        }

        throw new NoParameterlessConstructorException(clazz);
    }

    public static void main(String[] args) {

    }
}
