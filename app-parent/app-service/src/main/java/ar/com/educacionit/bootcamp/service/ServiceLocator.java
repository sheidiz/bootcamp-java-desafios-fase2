package ar.com.educacionit.bootcamp.service;

public class ServiceLocator {
	public static EntidadBaseService<?> getService(Class<?> clazz) {
		String name = clazz.getCanonicalName() + "Impl";

		try {
			return (EntidadBaseService<?>) Class.forName(name).getConstructors()[0].newInstance();
		} catch (Exception e) {
			throw new IllegalArgumentException(name);
		}
	}
}