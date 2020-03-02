package ranggacikal.com.himtiapps.model;



public class Data{

	private String password;

	private String userId;

	private String profilePicture;

	private String email;

	private String username;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setProfilePicture(String profilePicture){
		this.profilePicture = profilePicture;
	}

	public String getProfilePicture(){
		return profilePicture;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"password = '" + password + '\'' + 
			",user_id = '" + userId + '\'' + 
			",profile_picture = '" + profilePicture + '\'' + 
			",email = '" + email + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}