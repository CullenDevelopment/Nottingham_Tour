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
public class AccommodationFragment extends Fragment {


    public AccommodationFragment() {
        // Required empty public constructor
    }

    //Layout inflater to open out fragment when swiped to.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);


        // Create a list of Tour destination details
        //This is the list for the Accomodation fragment
        final ArrayList<Tour> details = new ArrayList<Tour>();
        details.add(new Tour("Crowne Plaza", "Wollaton St,\nNottingham,\nNG1 5RH",
                "0115 936 9988", R.drawable.crowne_plaza, "https://www.ihg.com/crowneplaza/hotels/gb/en/nottingham/notws/hoteldetail?cm_mmc=GoogleMaps-_-CP-_-GB-_-NOTWS"));
        details.add(new Tour("Mercure", "2, George St,\nNottingham,\nNG1 3BP",
                "0115 959 9777", R.drawable.mercurie, "https://www.mercurenottingham.com/"));
        details.add(new Tour("Lace Market Hotel", "29-31, High Pavement,\nNottingham,\nNG1 1HE",
                "0115 948 4414", R.drawable.lace_market, "https://www.lacemarkethotel.co.uk/"));
        details.add(new Tour("Jurys Inn", "Station St,\nNottingham,\nNG2 3BJ",
                "0115 901 6700", R.drawable.jurys_inn, "https://www.jurysinns.com/hotels/nottingham"));
        details.add(new Tour("Hilton", "Milton St,\nNottingham,\nNG1 3PZ",
                "0115 934 9700", R.drawable.hilton, "http://www3.hilton.com/en/hotels/united-kingdom/hilton-nottingham-EMANOHN/index.html"));
        details.add(new Tour("Park Inn by Radisson", "Mansfield Rd,\nNottingham,\nNG5 2BT",
                "0115 935 9988", R.drawable.park_inn, "https://www.parkinn.co.uk/hotel-nottingham"));
        details.add(new Tour("Premier Inn ", "7 Chapel Quarter,\nNottingham,\nNG1 6JS",
                "0871 527 9222", R.drawable.premier_inn, "https://www.premierinn.com/gb/en/hotels/england/nottinghamshire/nottingham/nottingham-city-centre-chapel-bar.html"));
        details.add(new Tour("Holiday Inn", "Castle Bridge Road,\nCastle Marina,\nNottingham,\nNG7 1GX",
                "0115 993 5000", R.drawable.holiday_inn, "https://www.ihg.com/holidayinn/hotels/gb/en/nottingham/notuk/hoteldetail?cm_mmc=GoogleMaps-_-HI-_-GB-_-NOTUK"));
        details.add(new Tour("Park Plaza", "41, Maid Marian Way,\nNottingham,\nNG1 6GD",
                "0 333 400 6148", R.drawable.park_plaza, "https://www.parkplaza.co.uk/nottingham-hotel-gb-ng1-6gd/gbnottin"));
        details.add(new Tour("Strathdon Hotel", "Derby Road,\nNottingham,\nNG1 5FT",
                "0115 941 8501", R.drawable.strathdon, "http://www.peelhotels.co.uk/hotels/strathdon-hotel-nottingham-nottinghamshire-england/"));

        // Create an {@link TourAdapter}, whose data source is a list of {@link Tour}s. The
        // adapter knows how to create list items for each item in the list.
        //R.color gives this fragment it's category color
        TourAdapter adapter = new TourAdapter(getActivity(), details, R.color.category_accomodation);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // tour_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link TourAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Tour} in the list.
        listView.setAdapter(adapter);

        // Get the {@link Tour} object at the given position the user clicked on
        // Set a click listener to divert to web page of venue when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Tour} object at the given position the user clicked on
                Tour detail = details.get(position);
                //Create intent to take user to web site of venue
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(detail.getWebAddress()));
                startActivity(intent);
            }
        });

        return rootView;
    }
}