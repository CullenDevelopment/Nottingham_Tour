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
public class DiningFragment extends Fragment {


    public DiningFragment() {
        // Required empty public constructor
    }

    //Layout inflater to open out fragment when swiped to.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);


        // Create a list of Tour destination details
        final ArrayList<Tour> details = new ArrayList<Tour>();
        details.add(new Tour("The Malt Cross", "16, St. James St,\nNottingham,\nNG1 6FG",
                "0115 941 1048", R.drawable.malt_cross, "https://www.maltcross.com/"));
        details.add(new Tour("Ye Olde Trip to Jerusalem", "Brewhouse Yard,\nNottingham\nNG1 6AD",
                "0115 947 3171", R.drawable.old_trip_to_jerusalem, "https://www.greeneking-pubs.co.uk/pubs/nottinghamshire/ye-olde-trip-to-jerusalem/"));
        details.add(new Tour("Bistrot Pierre", "13-17, Milton St,\nNottingham,\nNG1 3EN",
                "0115 941 2850", R.drawable.bistrot_pierre, "https://bistrotpierre.co.uk/locations/nottingham"));
        details.add(new Tour("Zaap Thai Street Food", "6 Bromley Pl,\nNottingham,\nNG1 6JG",
                "0115 947 0204", R.drawable.zaap, "https://zaapthai.co.uk/locations/nottingham/"));
        details.add(new Tour("Annie's Burger Shack", "5 Broadway,\nNottingham,\nNG1 1PR",
                "0115 684 9920", R.drawable.annies, "https://anniesburgershack.com/"));
        details.add(new Tour("Vat & Fiddle – Castle Rock's Brewery Tap", "12 Queensbridge Rd,\nNottingham,\nNG2 1NB",
                "0115 985 0611", R.drawable.vat_and_fiddle, "http://www.castlerockbrewery.co.uk/pubs/vat-and-fiddle/"));
        details.add(new Tour("Mem Saab,", "12-14, Maid Marian Way,\nNottingham,\nNG1 6HS",
                "0115 957 0009", R.drawable.mem_saab_meal, "http://www.mem-saab.co.uk"));
        details.add(new Tour("The Pudding Pantry", "27-29 Trinity Sq.,\nBurton St,\nNottingham,\nNG1 4AF",
                "0115 950 4660", R.drawable.thepuddingpantry, "http://www.thepuddingpantry.co.uk"));
        details.add(new Tour("Brown's Bar & Brasserie", "20, Park Row,\nNottingham.\nNG1 6GR",
                "0115 958 8183", R.drawable.browns, "https://www.browns-restaurants.co.uk/restaurants/eastandwestmidlands/nottingham"));
        details.add(new Tour("Baresca", "9, Byard Ln,\nNottingham,\nNG1 2GJ",
                "0115 948 3900", R.drawable.baresca, "http://www.baresca.co.uk/"));

        // Create an {@link TourAdapter}, whose data source is a list of {@link Tour objects}s. The
        // adapter knows how to create list items for each item in the list.
        TourAdapter adapter = new TourAdapter(getActivity(), details, R.color.category_dining);
        //R.color shows correct color for the Dining Category

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // tour_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link TourAdapter} we created above, so that the
        // {@link ListView} will display list items for the correct details in the list.
        listView.setAdapter(adapter);

        // Set a click listener to open venue web site when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Tour} object at the given position the user clicked on
                Tour detail = details.get(position);
                //create an intent to open that specific web page
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(detail.getWebAddress()));
                startActivity(intent);
            }

        });

        return rootView;
    }
}
