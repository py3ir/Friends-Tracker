package teamProject.entities;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

/**
 * Created by adanu on 31.10.2016.
 */
@XmlRootElement
public class User {
	private int id;
	private String login;
	private String password;
	private String token;

	public User() {
	}

	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public User(String login, String password, String token) {
		this.login = login;
		this.password = password;
		this.setToken(token);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		User that = (User) o;

		if (id != that.id)
			return false;
		if (login != null ? !login.equals(that.login) : that.login != null)
			return false;
		if (password != null ? !password.equals(that.password) : that.password != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (login != null ? login.hashCode() : 0);
		result = 31 * result + (password != null ? password.hashCode() : 0);
		return result;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
