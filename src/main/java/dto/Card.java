package dto;

public class Card {
	
	private String cardId;
	private String cardName;
	private String cardType;
	private int cardHp;
	private String skill1;
	private String skill2;
	
	//引数なしコンストラクタ
	public Card() {
		
	}
	
	//引数ありコンストラクタ
	public Card(String cardId, String cardName, String cardType, int cardHp, String skill1, String skill2) {
		this.cardId = cardId;
		this.cardName = cardName;
		this.cardType = cardType;
		this.cardHp = cardHp;
		this.skill1 = skill1;
		this.skill2 = skill2;
	}
	
	//getter@ID
	public String getCardId() {
		return cardId;
	}
	
	//setter@ID
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
	//getter@NAME
	public String getCardName() {
		return cardName;
	}
	
	//setter@NAME
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	
	//getter@TYPE
	public String getCardType() {
		return cardType;
	}
	
	//setter@TYPE
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	//getter@HP
	public int getCardHp() {
		return cardHp;
	}
	
	//setter@HP
	public void setCardHp(int cardHp) {
		this.cardHp = cardHp;
	}
	
	//getter@SKILL1
	public String getSkill1() {
		return skill1;
	}
	
	//setter@SKILL1
	public void setSkill1(String skill1) {
		this.skill1 = skill1;
	}
	
	//getter@SKILL2
	public String getSkill2() {
		return skill2;
	}
		
	//setter@SKILL2
	public void setSkill2(String skill2) {
		this.skill2 = skill2;
	}
}
