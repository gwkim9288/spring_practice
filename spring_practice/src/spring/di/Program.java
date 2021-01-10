package spring.di;

public class Program {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathxmlApplicationContext("spring");
		
		Exam exam = context.getBean(Exam.class);
		System.out.println(exam.toString());
		
		ExamConsole console  = (ExamConsole) context.getBean(Console.class);
		
		console.print();
	}
}
