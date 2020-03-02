package ranggacikal.com.himtiapps.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class DataJadwalSharingItem{

	@SerializedName("id_jadwal_sharing")
	private String idJadwalSharing;

	@SerializedName("waktu_sharing")
	private String waktuSharing;

	@SerializedName("link_gambar_sharing")
	private String linkGambarSharing;

	@SerializedName("detail_sharing")
	private String detailSharing;

	@SerializedName("judul_sharing")
	private String judulSharing;

	@SerializedName("bahasa_pemrograman")
	private String bahasaPemrograman;

	public void setIdJadwalSharing(String idJadwalSharing){
		this.idJadwalSharing = idJadwalSharing;
	}

	public String getIdJadwalSharing(){
		return idJadwalSharing;
	}

	public void setWaktuSharing(String waktuSharing){
		this.waktuSharing = waktuSharing;
	}

	public String getWaktuSharing(){
		return waktuSharing;
	}

	public void setLinkGambarSharing(String linkGambarSharing){
		this.linkGambarSharing = linkGambarSharing;
	}

	public String getLinkGambarSharing(){
		return linkGambarSharing;
	}

	public void setDetailSharing(String detailSharing){
		this.detailSharing = detailSharing;
	}

	public String getDetailSharing(){
		return detailSharing;
	}

	public void setJudulSharing(String judulSharing){
		this.judulSharing = judulSharing;
	}

	public String getJudulSharing(){
		return judulSharing;
	}

	public void setBahasaPemrograman(String bahasaPemrograman){
		this.bahasaPemrograman = bahasaPemrograman;
	}

	public String getBahasaPemrograman(){
		return bahasaPemrograman;
	}

	@Override
 	public String toString(){
		return 
			"DataJadwalSharingItem{" + 
			"id_jadwal_sharing = '" + idJadwalSharing + '\'' + 
			",waktu_sharing = '" + waktuSharing + '\'' + 
			",link_gambar_sharing = '" + linkGambarSharing + '\'' + 
			",detail_sharing = '" + detailSharing + '\'' + 
			",judul_sharing = '" + judulSharing + '\'' + 
			",bahasa_pemrograman = '" + bahasaPemrograman + '\'' + 
			"}";
		}
}