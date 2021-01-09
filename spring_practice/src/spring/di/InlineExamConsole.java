package spring.di;

public class InlineExamConsole extends Console {
	Exam exam;
	
	@Override
	public void setExam (Exam exam) {
		this.exam = exam;
	}
	
	@Autowired
	@Override
	public void print() {
		System.out.printf("total is %d, avg is %f\n",exam);
	}
	
}
