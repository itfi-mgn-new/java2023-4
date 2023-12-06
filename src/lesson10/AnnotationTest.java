package lesson10;

import java.lang.annotation.Annotation;

@Deprecated
@MyAnnotation(value="sdfsdfsdf")
public class AnnotationTest {

	@Deprecated
	@MyAnnotation(/*value=*/"45984598")
	public static void main(@Deprecated String[] args) {
		// TODO Auto-generated method stub
		Class	cl = AnnotationTest.class;
		Annotation a = cl.getAnnotation(MyAnnotation.class);
		
		System.err.println("a="+a);
	}

}
