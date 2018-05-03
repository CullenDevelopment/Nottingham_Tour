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
        details.add(new Tour(getContext().getString(R.string.crowne_plaza), getContext().getString(R.string.crowne_plaza_address),
                getContext().getString(R.string.crowne_plaza_telephone), R.drawable.crowne_plaza, getContext().getString(R.string.crowne_plaza_website)));
        details.add(new Tour(getContext().getString(R.string.mercure), getContext().getString(R.string.mercure_address),
                getContext().getString(R.string.mercure_telephone), R.drawable.mercurie, getContext().getString(R.string.mercure_website)));
        details.add(new Tour(getContext().getString(R.string.lace_market), getContext().getString(R.string.lace_market_address),
                getContext().getString(R.string.lace_market_telephone), R.drawable.lace_market, getContext().getString(R.string.lace_market_website)));
        details.add(new Tour(getContext().getString(R.string.jurys_inn), getContext().getString(R.string.jurys_inn_address),
                getContext().getString(R.string.jurys_inn_telephone), R.drawable.jurys_inn, getContext().getString(R.string.jurys_inn_website)));
        details.add(new Tour(getContext().getString(R.string.hilton), getContext().getString(R.string.hilton_address),
                getContext().getString(R.string.hilton_telephone), R.drawable.hilton, getContext().getString(R.string.hilton_website)));
        details.add(new Tour(getContext().getString(R.string.park_inn), getContext().getString(R.string.park_inn_address),
                getContext().getString(R.string.park_inn_telephone), R.drawable.park_inn, getContext().getString(R.string.park_inn_website)));
        details.add(new Tour(getContext().getString(R.string.premier_inn), getContext().getString(R.string.premier_inn_address),
                getContext().getString(R.string.premier_inn_telephone), R.drawable.premier_inn, getContext().getString(R.string.premier_inn_website)));
        details.add(new Tour(getContext().getString(R.string.holiday_inn), getContext().getString(R.string.holiday_inn_address),
                getContext().getString(R.string.holiday_inn_telephone), R.drawable.holiday_inn, getContext().getString(R.string.holiday_inn_website)));
        details.add(new Tour(getContext().getString(R.string.park_plaza), getContext().getString(R.string.park_plaza_address),
                getContext().getString(R.string.park_plaza_telephone), R.drawable.park_plaza, getContext().getString(R.string.park_plaza_website)));
        details.add(new Tour(getContext().getString(R.string.strathdon), getContext().getString(R.string.strathdon_address),
                getContext().getString(R.string.strathdon_telephone), R.drawable.strathdon, getContext().getString(R.string.strathdon_website)));

        // Create an {@link TourAdapter}, whose data source is a list of {@link Tour}s. The
        // adapter knows how to create list items for each item in the list.
        //R.color gives this fragment it's category color
        TourAdapter adapter = new TourAdapter(getActivity(), details, R.color.category_accommodation);

        /*
        Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        There should be a {@link ListView} with the view ID called list, which is declared in the
        tour_list.xml layout file.
        */
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