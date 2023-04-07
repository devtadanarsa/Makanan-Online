public class Restoran {
    private static int jmlResto;
    private String namaResto;
    private String alamatResto;

    public Restoran(String namaResto, String alamatResto){
        this.namaResto = namaResto;
        this.alamatResto = alamatResto;
        jmlResto++;
    }

    //Getter Method
    public static int getJmlResto() {
        return jmlResto;
    }
    public String getNamaResto() {
        return namaResto;
    }
    public String getAlamatResto() {
        return alamatResto;
    }

    //Setter Method
    public void setNamaResto(String namaResto) {
        this.namaResto = namaResto;
    }
    public void setAlamatResto(String alamatResto) {
        this.alamatResto = alamatResto;
    }

}
