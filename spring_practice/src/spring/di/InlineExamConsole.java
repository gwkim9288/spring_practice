package spring.di;

@Component
public class InlineExamConsole extends Console {
	
	privat e Exam exam;
	
	@Autowired
	public InlineExamConsole(Exam exam) {
		this.exam = exam;
	}
	
	@Autowired
	@Override
	public void setExam (Exam exam) {
		this.exam = exam;
	}
	
	@Override
	public void print() {
		System.out.printf("total is %d, avg is %f\n",exam);
	}
	
}
