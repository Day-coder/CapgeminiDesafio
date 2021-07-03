import java.sql.Date;

public class Anuncio {
	private int Id;
	private int investimentoPorDia;
	private String nomeDoAnuncio;
	private String nomeDoCliente;
	private int diaInicio;
	private int mesInicio;
	private int anoInicio;
	private int diaFim;
	private int mesFim;
	private int anoFim;

	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getInvestimentoPorDia() {
		return investimentoPorDia;
	}
	public void setInvestimentoPorDia(int investimentoPorDia) {
		this.investimentoPorDia = investimentoPorDia;
	}
	public String getNomeDoAnuncio() {
		return nomeDoAnuncio;
	}
	public void setNomeDoAnuncio(String nomeDoAnuncio) {
		this.nomeDoAnuncio = nomeDoAnuncio;
	}
	public String getNomeDoCliente() {
		return nomeDoCliente;
	}
	public void setNomeDoCliente(String nomeDoCliente) {
		this.nomeDoCliente = nomeDoCliente;
	}
	public int getDiaInicio() {
		return diaInicio;
	}
	public void setDiaInicio(int diaInicio) {
		this.diaInicio = diaInicio;
	}
	public int getMesInicio() {
		return mesInicio;
	}
	public void setMesInicio(int mesInicio) {
		this.mesInicio = mesInicio;
	}
	public int getAnoInicio() {
		return anoInicio;
	}
	public void setAnoInicio(int anoInicio) {
		this.anoInicio = anoInicio;
	}
	public int getDiaFim() {
		return diaFim;
	}
	public void setDiaFim(int diaFim) {
		this.diaFim = diaFim;
	}
	public int getMesFim() {
		return mesFim;
	}
	public void setMesFim(int mesFim) {
		this.mesFim = mesFim;
	}
	public int getAnoFim() {
		return anoFim;
	}
	public void setAnoFim(int anoFim) {
		this.anoFim = anoFim;
	}



	
	
}
