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
        details.add(new Tour(getContext().getString(R.string.theatre_royal), getContext().getString(R.string.theatre_royal_address),
                getContext().getString(R.string.theatre_royal_telephone), R.drawable.theatre_royal, getContext().getString(R.string.theatre_royal_website)));
        details.add(new Tour(getContext().getString(R.string.royal_concert_hall), getContext().getString(R.string.royal_concert_hall_address),
                getContext().getString(R.string.royal_concert_hall_telephone), R.drawable.royal_concert_hall, getContext().getString(R.string.royal_concert_hall_website)));
        details.add(new Tour(getContext().getString(R.string.playhouse), getContext().getString(R.string.playhouse_address),
                getContext().getString(R.string.playhouse_telephone), R.drawable.playhouse, getContext().getString(R.string.playhouse_website)));
        details.add(new Tour(getContext().getString(R.string.robin_hood), getContext().getString(R.string.robin_hood_address),
                getContext().getString(R.string.robin_hood_telephone), R.drawable.robin_hood_experience, getContext().getString(R.string.robin_hood_website)));
        details.add(new Tour(getContext().getString(R.string.castle), getContext().getString(R.string.castle_address),
                getContext().getString(R.string.castle_telephone), R.drawable.castle, getContext().getString(R.string.castle_website)));
        details.add(new Tour(getContext().getString(R.string.caves), getContext().getString(R.string.caves_address),
                getContext().getString(R.string.caves_telephone), R.drawable.city_of_caves, getContext().getString(R.string.caves_website)));
        details.add(new Tour(getContext().getString(R.string.nottingham_contemporary), getContext().getString(R.string.nottingham_contemporary_address),
                getContext().getString(R.string.nottingham_contemporary_telephone), R.drawable.nottingham_contemporary, getContext().getString(R.string.nottingham_contemporary_website)));
        details.add(new Tour(getContext().getString(R.string.newstead), getContext().getString(R.string.newstead_address),
                getContext().getString(R.string.newstead_telephone), R.drawable.newstead_abbey, getContext().getString(R.string.newstead_website)));
        details.add(new Tour(getContext().getString(R.string.wollaton), getContext().getString(R.string.wollaton_address),
                getContext().getString(R.string.wollaton_telephone), R.drawable.wollaton_hall, getContext().getString(R.string.wollaton_website)));
        details.add(new Tour(getContext().getString(R.string.national_video), getContext().getString(R.string.national_video_address),
                getContext().getString(R.string.national_video_telephone), R.drawable.national_videogame_arcade, getContext().getString(R.string.national_video_website)));

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