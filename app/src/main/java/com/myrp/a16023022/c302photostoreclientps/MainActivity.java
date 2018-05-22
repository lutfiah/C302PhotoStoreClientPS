package com.myrp.a16023022.c302photostoreclientps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvCat;
    ArrayList<String> alCat = new ArrayList<String>();
    ArrayAdapter<String> aaCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object lvItem = alCat.get(position);
            }
        });

    }

    protected void onResume() {
        super.onResume();

        lvCat = (ListView) findViewById(R.id.lvCat);
        aaCat = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alCat);
        lvCat.setAdapter(aaCat);

        // Code for step 1 start
        HttpRequest request = new HttpRequest
                ("http://10.0.2.2/C302_P06_PhotoStoreWS/getCategories.php");
        request.setOnHttpResponseListener(mHttpResponseListener);
        request.setMethod("GET");
        request.execute();
        // Code for step 1 end
    }
    private HttpRequest.OnHttpResponseListener mHttpResponseListener =
            new HttpRequest.OnHttpResponseListener() {
                @Override
                public void onResponse(String response){

                    // process response here
                    try {
                        JSONArray jsonArray = new JSONArray(response);

                        for (int i=0; i<jsonArray.length(); i++){
                            JSONObject jsonObj = jsonArray.getJSONObject(i);

                            int categoryId = jsonObj.getInt("category_id");
                            String categoryName = jsonObj.getString("name");
                            String description = jsonObj.getString("description");

                            String displayResults = "Category Id: " + categoryId + "\n\nCategory Name: "
                                    + categoryName + "\n\nDescription: " + description + "\n";
                            alCat.add(displayResults);
                        }
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }

                    aaCat.notifyDataSetChanged();
                }
            };
}
