package com.cullendevelopment.android.nottingham_tour;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MuseumsFragment extends Fragment {


    public MuseumsFragment() {
        // Required empty public constructor
    }
    //Layout inflater to open out fragment when swiped to.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);


        // Create a list of Tour destination details
        final ArrayList<Tour> details = new ArrayList<Tour>();
        details.add(new Tour("Nottingham Industrial Museum", "The Courtyard,\nWollaton Hall and Deer Park,\nNottingham,\nNG8 2AE",
                "0115 915 3936", R.drawable.industrial_museum, "https://www.nottinghamindustrialmuseum.org.uk/"));
        details.add(new Tour("National Justice Museum", "High Pavement,\nNottingham,\nNG1 1HN",
                "0115 952 0555", R.drawable.national_justice_museum, "http://www.nationaljusticemuseum.org.uk/"));
        details.add(new Tour("Framework Knitters Museum", "Chapel St,\nRuddington,\nNottingham,\nNG11 6HE",
                "0115 984 6914", R.drawable.framework_knitters, "https://www.frameworkknittersmuseum.org.uk/"));
        details.add(new Tour("D.H. Lawrence Birthplace Museum", "8a, Victoria St,\nEastwood,\nNottingham,\nNG16 3AW",
                "0115 917 3824", R.drawable.dh_lawrence_birthplace, "https://www.lleisure.co.uk/d-h-lawrence-birthplace-museum/"));
        details.add(new Tour("William Booth Birthplace Museum", "14, Notintone Place,\nSneinton,\nNottingham,\nNG2 4QG ",
                "0115 979 3464", R.drawable.william_booth_birthplace, "https://www.salvationarmy.org.uk/william-booth-birthplace-museum"));
        details.add(new Tour("Papplewick Pumping Station", "Rigg Ln,\nRavenshead,\nNottingham,\nNG15 9AJ",
                "0115 963 2938", R.drawable.papplewick_pumping_station, "http://www.papplewickpumpingstation.co.uk/"));
        details.add(new Tour("Green's Windmill Museum ", "Windmill Ln,\nNottingham,\nNG2 4QB",
                "0115 915 6878", R.drawable.greens_windmill, "https://www.greensmill.org.uk/"));


        // Create an {@link TourAdapter}, whose data source is a list of {@link Tour object}s. The
        // adapter knows how to create list items for each item in the list.
        TourAdapter adapter = new TourAdapter(getActivity(), details, R.color.category_museums);
        //R.color gives the Museums category the correct color

        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // tour_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link TourAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Tour object} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Tour} object at the given position the user clicked on
                Tour detail = details.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(detail.getWebAddress()));
        startActivity(intent);
            }
        });
        return rootView;
    }
}