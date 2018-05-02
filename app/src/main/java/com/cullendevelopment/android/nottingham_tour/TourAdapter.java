package com.cullendevelopment.android.nottingham_tour;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TourAdapter extends ArrayAdapter<Tour> {

    private int mColorResourceId; // mColorResourceId - declaring variable here


    private static final String LOG_TAG = TourAdapter.class.getSimpleName();

    public TourAdapter(Context context, ArrayList<Tour> details, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, details);
        //mColorResourceId relates to default background color of text container
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Tour} object located at this position in the list
        Tour currentTour = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView venueNameView = (TextView) listItemView.findViewById(R.id.venue_name_view);
        // Get the version name from the current Tour object and
        // set this text on the name TextView
        venueNameView.setText(currentTour.getVenueName());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView venueAddressView = (TextView) listItemView.findViewById(R.id.venue_address_view);
        // Get the version number from the current Tour object and
        // set this text on the address TextView
        venueAddressView.setText(currentTour.getVenueAddress());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView venueTelephoneView = (TextView) listItemView.findViewById(R.id.venue_telephone_view);
        // Get the version number from the current Tour object and
        // set this text on the telephone TextView
        venueTelephoneView.setText(currentTour.getVenueTelephone());


        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        // Get the version number from the current Tour object and
        // set this image on the main ImageView in list_item.xml
        imageView.setImageResource(currentTour.getImageResourceId());

        // Set the theme color for the list item - this is the default background
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);
        // Return the whole list item layout (containing 3 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}


