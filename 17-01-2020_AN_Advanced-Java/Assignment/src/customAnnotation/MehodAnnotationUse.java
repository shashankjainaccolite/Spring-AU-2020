package customAnnotation;

import java.lang.reflect.Method;

public class MehodAnnotationUse {
	
	@MethodAnnotation(key = 1, value = "Shashank")
	public static void getCustomAnnotation() {
		
		try {
			Class c = MehodAnnotationUse.class;
			
			Method[] methods = c.getMethods();
			Method method = null;
			
			for(Method m : methods) {
				if(m.getName().equals("getCustomAnnotation")) {
					method = m;
				}
			}
			
			MethodAnnotation annotation = method.getAnnotation(MethodAnnotation.class);
			
			System.out.println("Annotation for method object " + "has name : " +method.getName());
			System.out.println("Key Attribute of Annotation: " +annotation.key());
			System.out.println("Value Attribute of Annotation : " +annotation.value());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void getCustomAnnotation1() {
		
		try {
			Class c = MehodAnnotationUse.class;
			
			Method[] methods = c.getMethods();
			Method method = null;
			
			for(Method m : methods) {
				if(m.getName().equals("getCustomAnnotation2")) {
					method = m;
				}
			}
			
			MethodAnnotation annotation = method.getAnnotation(MethodAnnotation.class);
			
			System.out.println("Annotation for method object " + "has name : " +method.getName());
			System.out.println("Key Attribute of Annotation: " +annotation.key());
			System.out.println("Value Attribute of Annotation : " +annotation.value());
			
		} catch (Exception e) {
			System.out.println("This is the method without annotation");
		}
		
	}
	
	public static void main(String[] args) {
		getCustomAnnotation();
		getCustomAnnotation1();
	}
}
