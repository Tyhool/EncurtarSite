package LinkCurto;

public class Encurtar {
    private int idencurtar;
    private String site;
    private String linkcurto;

    public Encurtar(int idencurtar, String site, String linkcurto){
        this.idencurtar = idencurtar;
        this.site = site;
        this.linkcurto = linkcurto;

    }

    public int getIdencurtar() {
		return idencurtar;
	}

	public void setIdencurtar(int idencurtar) {
		this.idencurtar = idencurtar;
	}

    public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

    public String getLinkcurto() {
		return linkcurto;
	}

	public void setLinkcurto(String linkcurto) {
		this.linkcurto = linkcurto;
	}
}
