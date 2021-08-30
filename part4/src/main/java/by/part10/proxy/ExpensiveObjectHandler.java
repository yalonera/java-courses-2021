package by.part10.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ExpensiveObjectHandler implements InvocationHandler {

  private final ExpensiveObject original;

  public ExpensiveObjectHandler(ExpensiveObject original) {
    this.original = original;
  }

  public static ExpensiveObject create(ExpensiveObject original) {
    ExpensiveObjectHandler handler = new ExpensiveObjectHandler(original);
    return (ExpensiveObject) Proxy.newProxyInstance(
        ExpensiveObject.class.getClassLoader(),
        new Class[]{ExpensiveObject.class},
        handler
    );
  }

  public Object invoke(Object proxy, Method method, Object[] args)
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    System.out.println("BEFORE: " + method.getName());
    final Object invoke = method.invoke(original, args);
    System.out.println("AFTER: " + method.getName());
    return invoke;
  }
}

