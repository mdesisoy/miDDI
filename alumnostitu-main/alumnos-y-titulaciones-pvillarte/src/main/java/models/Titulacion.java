package models;

public class Titulacion{

    private Integer Id;
    private String Titulo;
    public Titulacion(int id, String titulo) {
        this.Id=id;
        this.Titulo=titulo;
    }
    public Titulacion(){}

    public void setId(Integer id) {
        this.Id = id;
    }
    public void setTitulo(String titulo) {
        this.Titulo = titulo;
    }

    public Integer getId(){
        return this.Id;
    }

    public String getTitulo(){
        return this.Titulo;
    }

}