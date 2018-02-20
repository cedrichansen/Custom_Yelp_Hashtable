import java.util.ArrayList;
import java.io.DataInputStream;
import java.io.IOException;

public class YelpData {


    String name, id, city;
    float lattitude, longitude;
    double similarity;
    ArrayList<String> categories;


    public YelpData(String n, String i, String c , float la, float lo) {
            name = n;
            id = i;
            city = c;
            lattitude = la;
            longitude = lo;
            categories = new ArrayList<>();
            similarity = 999999;

    }

    public String getName(){
        return name;
    }

    public String getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public float getLattitude() {
        return lattitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public double getSimilarity() {
        return similarity;
    }

    public String getCategories(){
        String c = "";
        for (int i = 0; i<categories.size(); i++) {
            c = c.concat(categories.get(i).toString() + ", ");
        }

        return c;

    }

    @Override
    public String toString(){
        return "name: "+  name + " id: " + id + " City: " + city + " latitude: "+ lattitude + " longitude: " + longitude +
                " categories: " + this.getCategories() + "similarity" + similarity;
    }


    public int hashify(HashTable ht){
        int size = ht.table.length;

        int hash = 7;
        char [] chars = this.name.toCharArray();
        for (int i =0; i<name.length(); i++) {
            hash = hash*137 + chars[(i)];
        }

        return Math.abs(hash) & (size-1);
        //return Math.abs(hash) % (size);
    }

    //establish similarity between this data point and other data points
    public double getSimilarity(YelpData y){

        int similarCategories = 0;
        double manhattan;

        //if categories match, then find closest mahatten distance
        for (int i = 0; i<this.categories.size(); i++) {
            for (int j=0; j<y.categories.size(); j++) {
                if (this.categories.get(i).toString().equals(y.categories.get(j).toString())) {
                    similarCategories++;
                }
            }
        }

        if (similarCategories <2) {
            return 99999999;
        } else {
            manhattan = Math.sqrt((Math.pow((this.lattitude- y.lattitude),2)) +
                    (Math.pow((this.longitude- y.longitude),2)));
        }
        double score = manhattan/ (similarCategories <<2);
        y.similarity = score;
        return score;
    }



    //get 10 most similar elements --- put this in hashtable class or put array in each yelpdata instance
    public YelpData[] top10Similar() {
        YelpData [] top10 = new YelpData[10];

        return top10;
    }

}
