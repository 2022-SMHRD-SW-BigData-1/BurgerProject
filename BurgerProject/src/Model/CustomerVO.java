package Model;

public class CustomerVO {

	private String customer;
	private String dialogue;
	private String recepie;
	
	public CustomerVO(String customer, String dialogue, String recepie) {
		super();
		this.customer = customer;
		this.dialogue = dialogue;
		this.recepie = recepie;
		
		
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getDialogue() {
		return dialogue;
	}

	public void setDialogue(String dialogue) {
		this.dialogue = dialogue;
	}
	
	public String getRecepie() {
		return recepie;
	}

	public void setRecepie(String recepie) {
		this.recepie = recepie;
	}
	
}
