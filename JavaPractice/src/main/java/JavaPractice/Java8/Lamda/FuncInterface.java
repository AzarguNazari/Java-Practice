package JavaPractice.Java8.Lamda;

public class FuncInterface {

	Operation op = (a, b) -> a + b;
	
}


@FunctionalInterface
interface Operation{
	int op(int a, int b);
}