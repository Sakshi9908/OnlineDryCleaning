package com.onlinedrycleaning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paymentId")
	private long paymentId;

	@Column(name = "type")
	@NotBlank(message = "Payment Type cannot be blank.")
	private String type;

	@Column(name = "status")
	@NotBlank(message = "Payment Status cannot be blank.")
	private String status;

	/*
	 * @OneToMany(fetch = FetchType.EAGER, mappedBy = "payment", cascade =
	 * CascadeType.ALL)
	 * 
	 * @JsonIgnoreProperties("payment")
	 */

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "paymentId", referencedColumnName = "paymentId")
	private List<Card> card = new ArrayList<>();

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Card> getCard() {
		return card;
	}

	public void setCard(List<Card> card) {
		this.card = card;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(long paymentId, String type, String status, List<Card> card) {
		super();
		this.paymentId = paymentId;
		this.type = type;
		this.status = status;
		this.card = card;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", type=" + type + ", status=" + status + ", card=" + card + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(card, paymentId, status, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(card, other.card) && paymentId == other.paymentId && Objects.equals(status, other.status)
				&& Objects.equals(type, other.type);
	}

}
