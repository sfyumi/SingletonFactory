package cn.agentd.singleton.factory;

/**
 * Singleton initializing test class
 */
public class Singleton {
    private String name;
    private Singleton() {
        this.name = "singleton";
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
