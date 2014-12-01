package mybikeshare.iastate.edu.mybikeshare;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Ben on 11/30/2014.
 */
public class LocationFragment extends Fragment {
    Activity mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        View view = inflater.inflate(R.layout.activity_main, container, false);
        ListView list = (ListView) view.findViewById(R.id.locations);
        createListItems(list);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_logout)
            mContext.onBackPressed();
        else{
            Toast.makeText(mContext, "Feature Not Available", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    String[] locations = {"Atanasoff Hall", "Armory", "Bessey Hall", "Carver Hall", "Communications Building",
            " Durham Center", "Gilman Hall", "Hoover Hall", "Howe Hall", "Physics Hall"};
    String [] estimates = {"1/3", "5/8", "6/10", "Full", "0/2",
            "2/5", "Full", "9/10", "4/5", "Full"};
    public void createListItems(ListView list){
        list.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return locations.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                StationView view = new StationView(mContext);
                view.setTitle(locations[position]);
                view.setAvailability(estimates[position]);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "Feature Not Available", Toast.LENGTH_SHORT).show();
                    }
                });
                return view;
            }
        });
    }
}
