package com.revature.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@Data // generate getters/setter, toString, hashCode, and equals methods automatically
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//Make sure the length of these fields is > 1
	@Length(min=2)
	private String firstName;
	
	@Length(min=2)
	private String lastName;
	
	// Maybe we want a minimum length of 5 and want it to be alphanumeric
	@NotBlank
	@Length(min=5)
	@Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]*")
	private String username;
	
	@NotBlank
	private String password;
	
	// Make sure this is a well-formed email
	@Email // from javax.validation.constrains this ensures that every email property contains an @
	private String email;

	public User(@Length(min = 2) String firstName, @Length(min=2) String lastName,
			@NotBlank @Length(min = 5) @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]*") String username,
			@NotBlank String password, @Email String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	
	



}
