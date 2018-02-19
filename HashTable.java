import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;


public class HashTable {

    LinkedList<YelpData> [] table;

    public HashTable(int size) {

        table = new LinkedList[size];
    }

    public YelpData add(YelpData y, HashTable ht) {

        int hash = y.hashify(ht);


        if (this.table[hash] == null) {
            LinkedList<YelpData> ll = new LinkedList<>();
            this.table[hash] = ll;
            ll.add(y);
        } else {
            this.table[hash].add(y);
        }

        return y;
    }

    public boolean contains(YelpData y, HashTable ht) {
        int hash = y.hashify(ht);
        String name = y.name;
        ArrayList<YelpData> temp = new ArrayList<>();
        temp.addAll(ht.table[hash]);

        if (ht.table[hash] == null){
            return false;
        }

        for (int i = 0; i<temp.size(); i++) {
            if (temp.get(i).name.equals(name)){
                return true;
            }
        }
        return false;
    }


    public HashTable resize() {
        int slots = this.table.length;
        HashTable biggerHT = new HashTable(slots*2);

        for (int i = 0; i<this.table.length; i++) {
            if (this.table[i] != null) {
                for (int j = 0; j < this.table[i].size(); j++) {
                    biggerHT.add(this.table[i].get(j), biggerHT);
                }
            }
        }
        return biggerHT;
    }


}
