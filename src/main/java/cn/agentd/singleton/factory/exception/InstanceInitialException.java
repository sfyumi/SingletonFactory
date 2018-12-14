package cn.agentd.singleton.factory.exception;

/**
 * Singleton instance initializing error
 */
public class InstanceInitialException extends RuntimeException {

    private static final long serialVersionUID = -6304094242348145589L;

    /**
     * Initialize instance of class error
     *
     * @param   clazz   the class.
     * @param   cause   the cause
     */
    public InstanceInitialException(Class clazz, Throwable cause) {
        super(clazz.getCanonicalName() + " initialize error", cause);
    }
}