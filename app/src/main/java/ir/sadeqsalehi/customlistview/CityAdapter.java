package ir.sadeqsalehi.customlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class CityAdapter extends ArrayAdapter {

    private List<City> cities;

    public CityAdapter(Context context, List<City> cities) {
        super(context, R.layout.city_list_item, cities);
        this.cities = cities;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        City city = cities.get(position);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.city_list_item, parent, false);
        ImageView cityImage = view.findViewById(R.id.imgCityImage);
        TextView cityName = view.findViewById(R.id.tvCityName);
        TextView cityPopulation = view.findViewById(R.id.tvCityPopulation);
        if (city.getId() != 0) {
            cityImage.setImageResource(city.getId());
        }
        cityName.setText(city.getName());
        cityPopulation.setText(String.valueOf(city.getPopulation()));
        return view;
    }
}
