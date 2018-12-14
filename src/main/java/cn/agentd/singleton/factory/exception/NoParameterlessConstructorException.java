package cn.agentd.singleton.factory.exception;

/**
 * An NoParameterlessConstructorException is thrown when generate
 * singleton instance of a class with no parameterless constructor.
 */
public class NoParameterlessConstructorException extends RuntimeException {
    private static final long serialVersionUID = 1094727476141677842L;

    /**
     * Constructs an <code>NoParameterlessConstructorException</code> without a
     * detail message.
     */
    public NoParameterlessConstructorException() {
        super();
    }

    /**
     * Constructs an <code>NoParameterlessConstructorException</code> with the class.
     *
     * @param   clazz   the class.
     */
    public NoParameterlessConstructorException(Class clazz) {
        super(clazz.getCanonicalName() + " has no parameterless constructor");
    }
}
