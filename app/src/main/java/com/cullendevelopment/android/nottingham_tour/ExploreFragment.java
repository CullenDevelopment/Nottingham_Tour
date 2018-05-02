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
public class ExploreFragment extends Fragment {


    public ExploreFragment() {
        // Required empty public constructor
    }

    //Layout inflater to open out fragment when swiped to.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);


        // Create a list of Tour destination details
        final ArrayList<Tour> details = new ArrayList<Tour>();
        details.add(new Tour("Theatre Royal", "Theatre Square,\nNottingham,\nNG1 5ND",
                "0115 989 5555", R.drawable.theatre_royal, "https://trch.co.uk/"));
        details.add(new Tour("Royal Concert Hall", "Theatre Square,\nNottingham,\nNG1 5ND",
                "0115 989 5555", R.drawable.royal_concert_hall, "https://trch.co.uk/"));
        details.add(new Tour("Playhouse Theatre", "Wellington Circus,\nNottingham\nNG1 5AF",
                "0115 941 9419", R.drawable.playhouse, "https://www.nottinghamplayhouse.co.uk"));
        details.add(new Tour("Robin Hood Experience", "94, Friar Ln,\nNottingham,\nNG1 6EB",
                "0115 947 4807", R.drawable.robin_hood_experience, "https://www.visit-nottinghamshire.co.uk/things-to-do/the-robin-hood-experience-p690221"));
        details.add(new Tour("Nottingham Castle", "Lenton Rd,\nNottingham,\nNG1 6EL",
                "0115 876 1400", R.drawable.castle, "https://www.nottinghamcastle.org.uk/"));
        details.add(new Tour("City of Caves", "Upper Level,\nBroadmarsh Shopping Centre,\nNottingham,\nNG1 7LS",
                "0115 988 1955", R.drawable.city_of_caves, "http://www.nationaljusticemuseum.org.uk/venue/city-of-caves/"));
        details.add(new Tour("Nottingham Contemporary ", "Weekday Cross,\nNottingham,\nNG1 2GB",
                "0115 948 9750", R.drawable.nottingham_contemporary, "http://www.nottinghamcontemporary.org/"));
        details.add(new Tour("Newstead Abbey", "Newstead Abbey,\nRavenshead,\nNottinghamshire,\nNG15 8NA",
                "0115 876 3100", R.drawable.newstead_abbey, "https://www.newsteadabbey.org.uk/"));
        details.add(new Tour("Wollaton Hall and Deer Park", "Wollaton Park,\nWollaton,\nNottingham,\nNG8 2AE",
                "0115 876 3100", R.drawable.wollaton_hall, "https://www.wollatonhall.org.uk/"));
        details.add(new Tour("National Video Game Arcade", "24-32, Carlton St,\nNottingham,\nNG1 1NN",
                "0115 881 3091", R.drawable.national_videogame_arcade, "https://www.thenva.com/"));

        // Create an {@link TourAdapter}, whose data source is a list of {@link Tour objects}. The
        // adapter knows how to create list items for each item in the list.
        TourAdapter adapter = new TourAdapter(getActivity(), details, R.color.category_explore);
        //R.color gives the correct color for the explore category

        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // tour_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link TourAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link details} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to open venues web site when the list item is clicked on
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