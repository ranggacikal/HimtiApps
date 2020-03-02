package ranggacikal.com.himtiapps.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ResponseRegister{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("sukses")
	private boolean sukses;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setSukses(boolean sukses){
		this.sukses = sukses;
	}

	public boolean isSukses(){
		return sukses;
	}

	@Override
 	public String toString(){
		return 
			"ResponseRegister{" + 
			"pesan = '" + pesan + '\'' + 
			",sukses = '" + sukses + '\'' + 
			"}";
		}
}