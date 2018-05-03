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
        details.add(new Tour(getContext().getString(R.string.industrial_museum), getContext().getString(R.string.industrial_museum_address),
                getContext().getString(R.string.industrial_museum_telephone), R.drawable.industrial_museum, getContext().getString(R.string.industrial_museum_website)));
        details.add(new Tour(getContext().getString(R.string.justice_museum), getContext().getString(R.string.justice_museum_address),
                getContext().getString(R.string.justice_museum_telephone), R.drawable.national_justice_museum, getContext().getString(R.string.justice_museum_website)));
        details.add(new Tour(getContext().getString(R.string.knitters_museum), getContext().getString(R.string.knitters_museum_address),
                getContext().getString(R.string.knitters_museum_telephone), R.drawable.framework_knitters, getContext().getString(R.string.knitters_museum_website)));
        details.add(new Tour(getContext().getString(R.string.d_h_lawrence), getContext().getString(R.string.d_h_lawrence_address),
                getContext().getString(R.string.d_h_lawrence_telephone), R.drawable.dh_lawrence_birthplace, getContext().getString(R.string.d_h_lawrence_website)));
        details.add(new Tour(getContext().getString(R.string.booth), getContext().getString(R.string.booth_address),
                getContext().getString(R.string.booth_telephone), R.drawable.william_booth_birthplace, getContext().getString(R.string.booth_website)));
        details.add(new Tour(getContext().getString(R.string.papplewick), getContext().getString(R.string.papplewick_address),
                getContext().getString(R.string.papplewick_telephone), R.drawable.papplewick_pumping_station, getContext().getString(R.string.papplewick_website)));
        details.add(new Tour(getContext().getString(R.string.greens_mill), getContext().getString(R.string.greens_mill_address),
                getContext().getString(R.string.greens_mill_telephone), R.drawable.greens_windmill, getContext().getString(R.string.greens_mill_website)));


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