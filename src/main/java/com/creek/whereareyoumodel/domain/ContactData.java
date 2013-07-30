package com.creek.whereareyoumodel.domain;

import static com.creek.whereareyoumodel.domain.RequestAllowance.NEVER;
import static com.creek.whereareyoumodel.domain.RequestAllowance.ALWAYS;

/**
 * 
 * @author Andrey Pereverzin
 */
public class ContactData extends AbstractIdentifiable implements Identifiable {
    private RequestAllowance requestAllowance = NEVER;
    private long allowanceDate = -1L;

    public RequestAllowance getRequestAllowance() {
        return requestAllowance;
    }

    public void setRequestAllowance(RequestAllowance requestAllowance) {
        this.requestAllowance = requestAllowance;
    }

    public long getAllowanceDate() {
        return allowanceDate;
    }

    public void setAllowanceDate(long allowanceDate) {
        this.allowanceDate = allowanceDate;
    }

    public boolean isRequestAllowed() {
        return ALWAYS == requestAllowance;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ContactData [").append(super.toString()).append(", requestAllowance=").append(requestAllowance).append(", allowanceDate=").append(allowanceDate).append("]");
        return builder.toString();
    }
}
