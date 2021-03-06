package edu.css.unit11_weather_async;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author Tom Gibbons
 * This class uses a button click to set all the text fields required.
 */

public class MainActivity extends AppCompatActivity {
    EditText etLoc;
    EditText etTemp;
    EditText etWind;
    EditText etVis;

    AsyncDownloadXML AsyncWeatherDownloader = new AsyncDownloadXML();

    @Override
    /**
     * OnCreate method
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set up our edit text variables
        etLoc =  (EditText) findViewById(R.id.textLoc);
        etTemp =  (EditText) findViewById(R.id.textTemp);
        etWind =  (EditText) findViewById(R.id.textWind);
        etVis =  (EditText) findViewById(R.id.textVis);
    }

    /**
     * Button that Downloads weather and sets all the text
     * @param v
     * @throws XmlPullParserException
     * @throws URISyntaxException
     * @throws IOException
     */
    public void btnClick (View v) throws XmlPullParserException, URISyntaxException, IOException {
        // Download the weather asynchronously
        AsyncWeatherDownloader.execute(this);
    }

    public void setTemp(String newTemp) {
        etTemp.setText(newTemp);
    }

    public void setWind(String newWind) {
        etWind.setText(newWind);
    }

    public String getLocation() {
        return etLoc.getText().toString();
    }


    public void setStatus(String newStatus) {
        Toast toast=Toast.makeText(getApplicationContext(), newStatus,Toast.LENGTH_LONG );
        toast.show();
    }

}
