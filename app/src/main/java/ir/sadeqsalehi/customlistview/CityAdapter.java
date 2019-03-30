package ir.sadeqsalehi.customlistview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.TimeoutException;

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
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.city_list_item, parent, false);
            holder = new ViewHolder();
            holder.cityImage = convertView.findViewById(R.id.imgCityImage);
            holder.cityName = convertView.findViewById(R.id.tvCityName);
            holder.cityPopulation = convertView.findViewById(R.id.tvCityPopulation);
            holder.imgSearch = convertView.findViewById(R.id.imgSearch);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();

        }
        holder.fill(city);
        return convertView;
    }

    private class ViewHolder implements View.OnClickListener {
        ImageView cityImage;
        TextView cityName;
        TextView cityPopulation;
        ImageView imgSearch;

        public void fill(City city) {
            if (city.getId() != 0) {
                cityImage.setImageResource(city.getId());
            }
            cityName.setText(city.getName());
            cityPopulation.setText(String.valueOf(city.getPopulation()));
            imgSearch.setTag(city.getName());
            imgSearch.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            String uri= "https://ar.wikipedia.org/wiki/"+v.getTag().toString();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(uri));
            getContext().startActivity(intent);
           // Toast.makeText(getContext(), "Search for "+v.getTag().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
