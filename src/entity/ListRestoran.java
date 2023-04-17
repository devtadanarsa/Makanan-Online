package entity;
import java.util.ArrayList;

public class ListRestoran {
    private static ArrayList <Restoran> restaurants;

    //Constructor
    public ListRestoran(){
        restaurants = new ArrayList<>();
    }

    //Getter dan Setter
    public static int size(){return restaurants.size();}
    public static void tambah(Restoran restoran){restaurants.add(restoran);}
    public static void hapus(int index){restaurants.remove(index);}
    public static Restoran get(int index){return restaurants.get(index);}

    /**
     * Fungsi untuk mengetahui apakah array list restaurants kosong atau tidak.
     * @return true/false
     */
    public static boolean isEmpty(){
        if(restaurants.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
