import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.text.Element;
import javax.swing.text.TabableView;
import javax.swing.text.TableView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Arrays; //simply to have easy sorted arrays


public class Main extends Application{


    // create another method that limits it to the ten best
    public static ArrayList<YelpData> getManySimilar(String name, HashTable ht){
        YelpData y = new YelpData(name, null, null, 1,1);
        if (!ht.contains(y, ht)) {
            System.out.println("This element does not exist");
            return null;
        } else {
            for (YelpData yd: ht.table[y.hashify(ht)]){
                if (y.name.equals(yd.name)){
                    y = yd;
                }
            }

            ArrayList <YelpData> mostSimilarBusinesses = new ArrayList<>();
            for (int i = 0; i<ht.table.length; i++) {
                if (ht.table[i]!=null){
                    for (YelpData yd: ht.table[i]){
                        if (yd.name != y.name){
                            double similarity = y.getSimilarity(yd);
                            if (similarity < 0.005){
                                mostSimilarBusinesses.add(yd);
                            }
                        }
                    }
                }
            }
            return mostSimilarBusinesses;
        }
    }


    public static YelpData getMostSimilar(String name, HashTable ht){
        YelpData y = new YelpData(name, null, null, 1,1);
        if (!ht.contains(y, ht)) {
            System.out.println("This element does not exist");
            return null;
        } else {
                for (YelpData yd: ht.table[y.hashify(ht)]){
                    if (y.name.equals(yd.name)){
                        y = yd;
                    }
                }

            YelpData best = new YelpData(null, null, null, 0,0 );
            for (int i = 0; i<ht.table.length; i++) {
                if (ht.table[i]!=null){
                    for (YelpData yd: ht.table[i]){
                        if (yd.name != y.name) {
                            double similarity = y.getSimilarity(yd);
                            if (similarity <best.similarity){
                                best = yd;
                            }
                        }
                    }

                }
            }
            return best;
        }
    }

/*
    public static void getInput(HashTable ht) {
        Scanner kb = new Scanner(System.in);

        System.out.println("Please type a business name to get it's information");
        String command = kb.nextLine();


        while (!command.equals("quit")) {
            YelpData y = new YelpData(command, null, null,11,11);
            int num = y.hashify(ht);

            if (ht.table[num] != null){

                YelpData ya = new YelpData(null,null,null, 1,1);

                ArrayList<YelpData> t = new ArrayList<>();
                t.addAll(ht.table[num]);

                if (ht.contains(y, ht)){
                    for (int a = 0; a<t.size(); a++) {
                        if (y.name.equals(t.get(a).name)) {
                            ya = ht.table[num].get(a);
                        }
                    }

                    System.out.println(ya.toString());
                    System.out.println("Most Similar Business---> " + getMostSimilar(ya.name, ht).toString() + "\n");

                    System.out.println("------Below are many similar businesses------" );
                    for (YelpData a: getManySimilar(ya.name, ht)) {
                        System.out.println(a.toString());
                    }

                } else {
                    System.out.println("This element does not exist");
                }
            } else {
                System.out.println("This Business does not exist");
            }

            System.out.println("Type element you would like to see: ");
            command = kb.nextLine();
        }
    }*/

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("display.fxml"));
        primaryStage.setTitle("CSC365 Hw01");
        primaryStage.setScene(new Scene(root, 1200, 771));
        primaryStage.show();
    }




    public static void main(String [] args) {
        /*
        ReadJson r = new ReadJson();

        HashTable good = r.readToHash("business.json");

        System.out.println("\nAll businesses have sucessfully been added, and table successfully resized! \n");

        getInput(good);
        */

        launch(args);

    }

}






// <<<----------- to do list -------------------------->>>


// fix it so that if you look for stuff in empty slots, it doesnt crash ----- fixed

// keep track of 10 most similar elements--- keep 10 doubles of most similarity, overwriting
// the similarity thing in each yelpreview, and once gone through all similairties, go back through the hashtable
// and if the similarity matches the ones in top 10, return that yelp data

// gui configuration

//when looking at certain spot, get the correct item all the time. create a method for this in hashtable class ----- i think fixed

// create static method in main that takes params hashtable and basically asks user for which element they want
// to see or compare, and then use the hashify(ht) method to get the items and compare or whatever ------ fixed
