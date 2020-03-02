package ranggacikal.com.himtiapps.model;

public class ResponseLogin{

	private String pesan;

	private Data data;

	private boolean sukses;

	private int status;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setSukses(boolean sukses){
		this.sukses = sukses;
	}

	public boolean isSukses(){
		return sukses;
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
			"ResponseLogin{" + 
			"pesan = '" + pesan + '\'' + 
			",data = '" + data + '\'' + 
			",sukses = '" + sukses + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}