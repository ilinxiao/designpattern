public class MailSender implements Sender {  
	@Override  
	public void Send() {  
		System.out.println("this is mailsender!使用静态工厂实现。");  
	}  
}  