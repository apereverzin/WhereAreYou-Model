package com.creek.whereareyoumodel.domain;

/**
 * 
 * @author Andrey Pereverzin
 */
public class ContactData extends AbstractIdentifiable implements Identifiable {
    private String displayName;
    private boolean requestAllowed;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isRequestAllowed() {
        return requestAllowed;
    }

    public void setRequestAllowed(boolean requestAllowed) {
        this.requestAllowed = requestAllowed;
    }
}
