package ranggacikal.com.himtiapps.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ResponseJadwalSharing{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("DataJadwalSharing")
	private List<DataJadwalSharingItem> dataJadwalSharing;

	@SerializedName("status")
	private int status;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setDataJadwalSharing(List<DataJadwalSharingItem> dataJadwalSharing){
		this.dataJadwalSharing = dataJadwalSharing;
	}

	public List<DataJadwalSharingItem> getDataJadwalSharing(){
		return dataJadwalSharing;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseJadwalSharing{" + 
			"pesan = '" + pesan + '\'' + 
			",dataJadwalSharing = '" + dataJadwalSharing + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}