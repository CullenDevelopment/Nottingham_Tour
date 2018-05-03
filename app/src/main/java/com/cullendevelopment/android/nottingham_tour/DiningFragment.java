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
        details.add(new Tour(getContext().getString(R.string.malt_cross), getContext().getString(R.string.malt_cross_address),
                getContext().getString(R.string.malt_cross_telephone), R.drawable.malt_cross, getContext().getString(R.string.malt_cross_website)));
        details.add(new Tour(getContext().getString(R.string.trip), getContext().getString(R.string.trip_address),
                getContext().getString(R.string.trip_telephone), R.drawable.old_trip_to_jerusalem, getContext().getString(R.string.trip_website)));
        details.add(new Tour(getContext().getString(R.string.bistrot_pierre), getContext().getString(R.string.bistrot_pierre_address),
                getContext().getString(R.string.bistrot_pierre_telephone), R.drawable.bistrot_pierre, getContext().getString(R.string.bistrot_pierre_website)));
        details.add(new Tour(getContext().getString(R.string.zaap), getContext().getString(R.string.zaap_address),
                getContext().getString(R.string.zaap_telephone), R.drawable.zaap, getContext().getString(R.string.zaap_website)));
        details.add(new Tour(getContext().getString(R.string.annies), getContext().getString(R.string.annies_address),
                getContext().getString(R.string.annies_telephone), R.drawable.annies, getContext().getString(R.string.annies_website)));
        details.add(new Tour(getContext().getString(R.string.vat_and_fiddle), getContext().getString(R.string.vat_and_fiddle_address),
                getContext().getString(R.string.vat_and_fiddle_telephone), R.drawable.vat_and_fiddle, getContext().getString(R.string.vat_and_fiddle_website)));
        details.add(new Tour(getContext().getString(R.string.mem_saab), getContext().getString(R.string.mem_saab_address),
                getContext().getString(R.string.mem_saab_telephone), R.drawable.mem_saab_meal, getContext().getString(R.string.mem_saab_website)));
        details.add(new Tour(getContext().getString(R.string.pudding_pantry), getContext().getString(R.string.pudding_pantry_address),
                getContext().getString(R.string.pudding_pantry_telephone), R.drawable.thepuddingpantry, getContext().getString(R.string.pudding_pantry_website)));
        details.add(new Tour(getContext().getString(R.string.browns), getContext().getString(R.string.browns_address),
                getContext().getString(R.string.browns_telephone), R.drawable.browns, getContext().getString(R.string.browns_website)));
        details.add(new Tour(getContext().getString(R.string.baresca), getContext().getString(R.string.baresca_address),
                getContext().getString(R.string.baresca_telephone), R.drawable.baresca, getContext().getString(R.string.baresca_website)));

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
