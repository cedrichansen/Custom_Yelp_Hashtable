import java.io.BufferedReader;
import java.io.FileReader;


import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;



class ReadJson {


    public HashTable readToHash(String filename){
        HashTable ht = new HashTable(512);

        try {

            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line = "";

            for (int i = 0; i<17000; i++) {
                //get each line and make a json object from the line
                line = br.readLine();
                org.json.JSONObject jobj = new org.json.JSONObject(line);

                //get relevant data and create new java object
                YelpData yd = new YelpData(jobj.get("name").toString(), jobj.get("business_id").toString(),
                        jobj.get("city").toString(),jobj.getFloat("latitude"),
                        jobj.getFloat("longitude"));

                //get json categories and put them in newly created java object
                List <String> ca = new ArrayList<String>();

                JSONArray jarr = new JSONArray(jobj.getJSONArray("categories").toString());

                //add json category array to our categories arraylist
                for (int j =0; j<jarr.length(); j++) {
                    ca.add(jarr.get(j).toString());
                }

                //add categories from json to object
                yd.categories.addAll(ca);

                //print contents of object
                //System.out.println(yd.toString());

                if ((float)(i+1)/(float)ht.table.length <= 0.5) {
                    ht.add(yd,ht);
                } else {
                    ht = ht.resize();
                    ht.add(yd,ht);
                }
                //ht.add(yd,ht);

                System.out.println(yd.toString());

            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ht;
    }
}
