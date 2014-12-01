package mybikeshare.iastate.edu.mybikeshare;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * Created by Ben on 11/30/2014.
 */
public class StationView extends RelativeLayout {
    private View view;
    private TextView title;
    private TextView availability;

    public StationView(Context context) {
        super(context);
        Constructor(context);
    }

    public StationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Constructor(context);
    }

    public StationView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Constructor(context);
    }

    private void Constructor(Context context){
        view = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.location_layout_item, this, true);
        title = (TextView) view.findViewById(R.id.station_location);
        availability = (TextView) view.findViewById(R.id.station_availability);
    }

    public void setTitle(String text)
    {
        title.setText(text);
    }

    public void setAvailability(String avail)
    {
        if(avail.equals("Full"))
            availability.setTextColor(Color.RED);
        availability.setText(avail);
    }


}
