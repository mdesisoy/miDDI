package models;

public class Alumno{

    private Integer Id;
    private String Nombre;
    private Integer Edad;
    private Titulacion Titulacion;

    public Alumno(){

    }


    public void setId(Integer id) {
        this.Id = id;
    }
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
    public Integer getId(){
        return this.Id;
    }

    public String getNombre(){
        return this.Nombre;
    }

    public void setEdad(Integer edad) {
        this.Edad = edad;
    }

    public Integer getEdad(){
        return this.Edad;
    }


    public models.Titulacion getTitulacion() {
        return Titulacion;
    }
    public void setTitulacion(models.Titulacion titulacion) {
        Titulacion = titulacion;
    }
}