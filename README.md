# SingletonFactory

单例工厂，无需重复实现单例模式直接获取单例化实例。

SingletonFactory creates singleton instance of a class.

## 使用方法
```java
Singleton instance = SingletonFactory.getInstance(Singleton.class);
Singleton instance = SingletonFactory.getInstance(Singleton.class, Singleton::new);
Singleton instance = SingletonFactory.getInstance(Singleton.class, () -> new Singleton("supplier"));
```