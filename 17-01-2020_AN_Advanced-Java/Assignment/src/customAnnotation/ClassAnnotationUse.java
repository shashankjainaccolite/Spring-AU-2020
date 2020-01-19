package customAnnotation;

@ClassAnnotation(key = 1, value = "Shashank")
public class ClassAnnotationUse {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		Class myClassName = ClassAnnotationUse.class;
		
		System.out.println("Class represented is : " +myClassName.toString());
		
		System.out.println("Annotation of my class : " +myClassName.getAnnotation(ClassAnnotation.class));
		
	}

}
