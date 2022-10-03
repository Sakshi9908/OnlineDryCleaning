package com.onlinedrycleaning.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "card")
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cardId")
	private long cardId;

	@Pattern(regexp = "^[a-zA-z]+$", message = "Only alphabets are allowed.")
	@Column(name = "cardName")
	private String cardName;

	@Pattern(regexp = "^[0-9]{12}$", message = "Number should contain only 12 digits ")
	@Column(name = "cardNumber")
	private String cardNumber;

	@Column(name = "expiryDate")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date expiryDate;

	@NotNull(message = "Bank Name Cannot Be Null.")
	@Column(name = "bankName")
	private String bankName;

	/*
	 * @ManyToOne(fetch=FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "paymentId") private Payment payment;
	 */
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Card(long cardId, String cardName, String cardNumber, Date expiryDate, String bankName) {
		super();
		this.cardId = cardId;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.bankName = bankName;

	}

	public long getCardId() {
		return cardId;
	}

	public void setCardId(long cardId) {
		this.cardId = cardId;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/*
	 * @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "paymentId", referencedColumnName = "paymentId")
	 * 
	 * @JsonIgnoreProperties("card")
	 */

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "paymentId")
	 * 
	 * private Payment payment;
	 */

}
