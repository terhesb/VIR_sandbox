package caller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Supplier;

import annotation.Decorate;

public class ReflectCaller {

	private Class<?> clazz; 
	
	public ReflectCaller(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T callFunc(String methodName) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Object clazzObject = clazz.getDeclaredConstructor().newInstance();
		Method method = clazz.getMethod(methodName);
		Decorate annotation = method.getAnnotation(Decorate.class);
		if (annotation != null) {
			Method decoratorfunction = clazz.getMethod(annotation.decoratorFunction(), Supplier.class);
			return (T) decoratorfunction.invoke(clazzObject, makeSupplierFromMethod(clazzObject, method));
		} else {
			return (T) method.invoke(clazzObject);
		}
	}

	private <T> Supplier<T> makeSupplierFromMethod(Object clazzObject, Method method) {
		return new Supplier<T>() {

			@SuppressWarnings("unchecked")
			@Override
			public T get() {
				try {
					return (T) method.invoke(clazzObject);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
					return null;
				}
			}
			
		};
	}
	
}
