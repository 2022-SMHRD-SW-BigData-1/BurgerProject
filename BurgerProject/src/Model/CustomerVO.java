package Model;

public class CustomerVO {

	private String customer;
	private String dialogue;

	
	public CustomerVO(String customer, String dialogue, String recepie) {
		super();
		this.customer = customer;
		this.dialogue = dialogue;

		
		
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
	
}
