package com.mystruts.actions;

import java.io.UnsupportedEncodingException;
import com.mystruts.models.User;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class RegistrationAction extends ActionSupport {
	public void validate() {
		if (getId().length() == 0) {
			addFieldError("id", getText("MSE001"));
		}
		// check already exist ID

		else
			try {
				if (getId().getBytes("MS932").length > getId().length()) {
					addFieldError("id", getText("MSE008"));
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (getName().length() == 0) {
			addFieldError("name", getText("MSE009"));
		}
	}

	public String execute() {
		return "success";
	}

	public String confirmRegistration() {
		User user = new User();
		user.setId(id);
		user.setPassword(password);
		user.setName(name);
		user.setNameKatakana(nameKatakana);
		user.setDateOfBirth(dateOfBirth);
		user.setClub(club);
		user.save();
		return "success";
	}

	private String id;
	private String password;
	private String passwordConfirmation;
	private String name;
	private String nameKatakana;
	private String dateOfBirth;
	private String club;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameKatakana() {
		return nameKatakana;
	}

	public void setNameKatakana(String nameKatakana) {
		this.nameKatakana = nameKatakana;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}
}