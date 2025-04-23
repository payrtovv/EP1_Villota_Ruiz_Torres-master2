public class Pokemon {
    private String nombre;
    private String tipo;
    private int nivelPoder;
    private String habilidad;
    private String estado;


    public Pokemon() {
        this.nombre = "Pikachu";
        this.tipo = "Electrico";
        this.nivelPoder = 120;
        this.habilidad = "Impactrueno";
        this.estado = "Activo";
    }

    public Pokemon(String nombre, String tipo, int nivelPoder, String habilidad, String estado) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivelPoder = nivelPoder;
        this.habilidad = habilidad;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivelPoder() {
        return nivelPoder;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setNivelPoder(int nivelPoder) {
        this.nivelPoder = nivelPoder;
    }

    public String toString() {
        return "Pokemon" + "\n" +
                "Nombre= " + nombre + '\n' +
                "Tipo= " + tipo + '\n' +
                "NivelPoder= " + nivelPoder +'\n' +
                "Habilidad= " + habilidad + '\n' +
                "Estado= " + estado + '\n';
    }
}
