
package Modelo;

public class PuestoTrabajo {
    private int idPuestoTrabajo;
    private String nombrePuestoTrabajo;

    public PuestoTrabajo(int idPuestoTrabajo, String nombrePuestoTrabajo) {
        this.idPuestoTrabajo = idPuestoTrabajo;
        this.nombrePuestoTrabajo = nombrePuestoTrabajo;
    }

    public int getIdPuestoTrabajo() {
        return idPuestoTrabajo;
    }

    public void setIdPuestoTrabajo(int idPuestoTrabajo) {
        this.idPuestoTrabajo = idPuestoTrabajo;
    }

    public String getNombrePuestoTrabajo() {
        return nombrePuestoTrabajo;
    }

    public void setNombrePuestoTrabajo(String nombrePuestoTrabajo) {
        this.nombrePuestoTrabajo = nombrePuestoTrabajo;
    }

    @Override
    public String toString() {
        return getNombrePuestoTrabajo() ;
    }
    
}
