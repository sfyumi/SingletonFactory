package cn.agentd.singleton.factory;

/**
 * Singleton initializing test class
 */
public class Singleton {
    private String name;
    public Singleton() {
        this.name = "singleton";
    }

    public Singleton(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
