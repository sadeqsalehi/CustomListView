package ir.sadeqsalehi.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewActivity extends AppCompatActivity {

    List<City> cities;
    ListView citiesListView;
    CityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        citiesListView = findViewById(R.id.lstCities);
        cities = new ArrayList<>();
        populateCitiesList();
        refreshDisplay();

    }

    private void refreshDisplay() {
        adapter = new CityAdapter(this, cities);
        citiesListView.setAdapter(adapter);
    }

    private void populateCitiesList() {
        //addFakeCities(8);
        cities.add(new City("Amsterdam", 12000000, R.drawable.amsterdam));
        cities.add(new City("Austin", 800000, R.drawable.austin));
        cities.add(new City("Barcelona", 2000000, R.drawable.barcelona));
       // addFakeCities(8);
        cities.add(new City("Berlin", 3500000, R.drawable.berlin));
        cities.add(new City("Cape Town", 6700000, R.drawable.cape_town));
        cities.add(new City("Dublin", 3400000, R.drawable.dublin));
        cities.add(new City("London", 1000000, R.drawable.london));
        //addFakeCities(8);
        cities.add(new City("New York", 14000000, R.drawable.new_york));
        cities.add(new City("Paris", 5800000, R.drawable.paris));
        cities.add(new City("San Francisco", 9500000, R.drawable.san_francisco));
        cities.add(new City("Stockholm", 2300000, R.drawable.stockholm));
        //addFakeCities(4);
        cities.add(new City("Sydney", 4100000, R.drawable.sydney));
        cities.add(new City("Tokyo", 7800000, R.drawable.tokyo));
        cities.add(new City("Wellington", 300000, R.drawable.wellington));

    }

    private void addFakeCities(int n) {
        for (int i = 0; i < n; i++)
            cities.add(new City("Amsterdam", 12000000, R.drawable.amsterdam));
    }
}
