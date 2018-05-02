package com.cullendevelopment.android.nottingham_tour;

public class Tour {

    @Override
    public String toString() {
        return "Tour {" +
                "mVenueName='" + mVenueName + '\'' +
                ", mVenueAddress='" + mVenueAddress + '\'' +
                ", mVenueTelephone='" + mVenueTelephone + '\'' +
                ", mImageResourceId=" + mImageResourceId;
    }
    /**
     * private string value
     * of Venue Name
     */
    private String mVenueName;

    /**
     * private string value
     * Of Venue Address
     */
    private String mVenueAddress;

    /**
     * private string value
     * Of Venue Address
     */
    private String mVenueTelephone;

    // Drawable resource ID
    private int mImageResourceId;

   // private string value for web address of venue
    private String mWebAddress;

    //Constructor with five inputs
    public Tour(String venueName, String venueAddress, String venueTelephone, int imageResourceId, String webAddress) {
        mVenueName = venueName;
        mVenueAddress = venueAddress;
        mVenueTelephone = venueTelephone;
        mImageResourceId = imageResourceId;
        mWebAddress = webAddress;
    }

    /**
     * Get the Venue Name
     */
    public String getVenueName() {

        return mVenueName;
    }

    /**
     * Get the Venue Address
     */
    public String getVenueAddress() {

        return mVenueAddress;
    }

    /**
     * Get the Venue Telephone Number
     */
    public String getVenueTelephone() {

        return mVenueTelephone;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() {

        return mImageResourceId;
    }
    /**
     * Get the image resource ID
     */
    public String getWebAddress() {

        return mWebAddress;
    }
}
