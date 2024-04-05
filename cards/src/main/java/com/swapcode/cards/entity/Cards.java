package com.swapcode.cards.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cards extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cardId;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "card_number")
	private String cardNumber;

	@Column(name = "card_type")
	private String cardType;

	@Column(name = "total_limit")
	private int totalLimit;

	@Column(name = "amount_used")
	private int amountUsed;

	@Column(name = "available_amt")
	private int availableAmount;
	
}
