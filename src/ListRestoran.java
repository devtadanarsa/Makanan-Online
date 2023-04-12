import java.util.ArrayList;

public class ListRestoran {
    private static ArrayList <Restoran> restaurants;

    public ListRestoran(){
        restaurants = new ArrayList<>();
    }

    public static int size(){
        return restaurants.size();
    }

    public static void tambah(Restoran restoran){
        restaurants.add(restoran);
    }

    public static void hapus(int index){
        restaurants.remove(index);
    }

    public static Restoran get(int index){
        return restaurants.get(index);
    }
}
