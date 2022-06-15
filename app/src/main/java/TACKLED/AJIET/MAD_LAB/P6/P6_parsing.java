package TACKLED.AJIET.MAD_LAB.P6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import TACKLED.AJIET.MAD_LAB.R;

public class P6_parsing extends AppCompatActivity {
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p6_parsing);

        display = findViewById(R.id.textViewParsedDdata);
    }

//    xml parsing codes starts
    public void parseXML(View V) {
        try {
            InputStream is = getAssets().open("city.xml"); //open file
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(is);  //prepare file

            StringBuilder stringBuilder = new StringBuilder();  //create string

            stringBuilder.append("XML DATA");
            stringBuilder.append("\n---------");

            NodeList nodeList = document.getElementsByTagName("city");  //get a single node

            for (int i = 0; i < nodeList.getLength(); i++) {    //start loop to fetch individual node data

                Node node = nodeList.item(i);       //fetch node id (index)
                if (node.getNodeType() == Node.ELEMENT_NODE) {  //start fetching element node
                    Element element = (Element) node;
                    stringBuilder.append("\nName: ").append(getValue("City_name", element));    //append individual data entity
                    stringBuilder.append("\nLatitude: ").append(getValue("Latitude", element));
                    stringBuilder.append("\nLongitude: ").append(getValue("Longitude", element));
                    stringBuilder.append("\nTemperature: ").append(getValue("Temperature", element));
                    stringBuilder.append("\nHumidity: ").append(getValue("Humidity", element));
                  stringBuilder.append("\n----------");
               }
            }
            display.setText(stringBuilder.toString());  //load data to View Component
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(P6_parsing.this, "Error Parsing XML", Toast.LENGTH_LONG).show();
        }
    }


    private String getValue(String tag, Element element) {
        return element.getElementsByTagName(tag).item(0).getChildNodes().item(0).getNodeValue();    //fetch data of each element using tags
    }

    //    xml parsing codes ends


    public void parseJS(View V) {

        StringBuilder stringBuilder = new StringBuilder();
        try {

            // get JSONObject from JSON file
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            // fetch JSONObject named cities
            JSONArray cityArray = obj.getJSONArray("cities");
            stringBuilder.append("JSON DATA");
            stringBuilder.append("\n--------");

            for (int i = 0; i < cityArray.length(); i++) {
                JSONObject jsonObject = cityArray.getJSONObject(i);
                stringBuilder.append("\nName: ").append(jsonObject.getString("City_name"));
                stringBuilder.append("\nLatitude: ").append(jsonObject.getString("Latitude"));
                stringBuilder.append("\nLongitude: ").append(jsonObject.getString("Longitude"));
                stringBuilder.append("\nTemperature: ").append(jsonObject.getString("Temperature"));
                stringBuilder.append("\nHumidity: ").append(jsonObject.getString("Humidity"));
                stringBuilder.append("\n----------");
            }

            display.setText(stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(P6_parsing.this, "Error in reading", Toast.LENGTH_LONG).show();
        }
    }

    public String loadJSONFromAsset() {
        String jsonString;
        try {
            InputStream inputStream = getAssets().open("city.json");

            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            jsonString = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return jsonString;
    }
}