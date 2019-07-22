package cn.agentd.singleton.factory;

import cn.agentd.singleton.factory.exception.InstanceInitialException;
import cn.agentd.singleton.factory.exception.NoParameterlessConstructorException;

import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

/**
 * SingletonFactory creates singleton instance of a class.
 *
 */
public class SingletonFactory {
    private static volatile ConcurrentHashMap<String, Object> singletonMap = new ConcurrentHashMap<>();

    /**
     * The class must has a parameterless constructor, no matter private or public.
     */
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

    /**
     * The supplier construct a new instance.
     */
    @SuppressWarnings("unchecked")
    public static <T> T getInstance(Class<T> clazz, Supplier<T> supplier) {
        Object instance = singletonMap.get(clazz.getCanonicalName());
        if (instance == null) {
            synchronized (clazz.getCanonicalName()) {
                instance = singletonMap.get(clazz.getCanonicalName());
                if (instance == null) {
                    instance = supplier.get();
                    singletonMap.put(clazz.getCanonicalName(), instance);
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
}
