package com.models.db;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by piyush.agarwal on 24/01/17.
 */

@Entity
@Table(name = "digital_campaigns")
public class Campaign {

    public enum Status {
        ACTIVE,
        INACTIVE
    }

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "campaign_id")
    private String campaignId;

    @Column(name = "parent_fsn")
    private String parentFsn;

    @Column(name = "child_listing_id")
    private String childListingId;

    @Column(name = "start_time")
    private long startTime;

    @Column(name = "end_time")
    private long endTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "parent_listing_id")
    private String parentListingId;

    @Column(name = "rate_card_id")
    private String rateCardId;

    @Column(name = "child_fsn")
    private String childFsn;


    @Column(name = "property_id")
    private String propertyId;

    @Column(name = "external_id")
    private String externalId;

    public Campaign() {

    }

    private Campaign(Builder builder) {
        this.campaignId = builder.campaignId;
        this.parentFsn = builder.parentFsn;
        this.parentListingId = builder.parentListingId;
        this.childFsn = builder.childFsn;
        this.childListingId = builder.childListingId;
        this.propertyId = builder.propertyId;
        this.externalId = builder.externalId;
        this.rateCardId = builder.rateCardId;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.status = builder.status;
    }
    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getParentFsn() {
        return parentFsn;
    }

    public void setParentFsn(String parentFsn) {
        this.parentFsn = parentFsn;
    }

    public String getChildListingId() {
        return childListingId;
    }

    public void setChildListingId(String childListingId) {
        this.childListingId = childListingId;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getParentListingId() {
        return parentListingId;
    }

    public void setParentListingId(String parentListingId) {
        this.parentListingId = parentListingId;
    }

    public String getRateCardId() {
        return rateCardId;
    }

    public void setRateCardId(String rateCardId) {
        this.rateCardId = rateCardId;
    }

    public String getChildFsn() {
        return childFsn;
    }

    public void setChildFsn(String childFsn) {
        this.childFsn = childFsn;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public static class Builder {

        private String campaignId;
        private String parentFsn;
        private String childListingId;
        private long startTime;
        private long endTime;
        private Status status;
        private String parentListingId;
        private String rateCardId;
        private String childFsn;
        private String propertyId;
        private String externalId;

        public Builder withCampaignId(String campaignId) {
            this.campaignId = campaignId;
            return this;
        }

        public Builder withParentFsn(String parentFsn) {
            this.parentFsn = parentFsn;
            return this;
        }

        public Builder withParentListingId(String parentListingId) {
            this.parentListingId = parentListingId;
            return this;
        }

        public Builder withChildFsn(String childFsn) {
            this.childFsn = childFsn;
            return this;
        }

        public Builder withChildListingId(String childListingId) {
            this.childListingId = childListingId;
            return this;
        }

        public Builder withRateCardId(String rateCardId) {
            this.rateCardId = rateCardId;
            return this;
        }

        public Builder withPropertyId(String propertyId) {
            this.propertyId = propertyId;
            return this;
        }

        public Builder withExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public Builder withStartTime(long startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder withEndTime(long endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder withStatus(Status status) {
            this.status = status;
            return this;
        }

        public Campaign build() {
            return new Campaign(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Campaign)) return false;

        Campaign campaign = (Campaign) o;

        return new EqualsBuilder()
                .append(getCampaignId(), campaign.getCampaignId())
                .append(getStartTime(), campaign.getStartTime())
                .append(getEndTime(), campaign.getEndTime())
                .append(getCampaignId(), campaign.getCampaignId())
                .append(getParentFsn(), campaign.getParentFsn())
                .append(getChildListingId(), campaign.getChildListingId())
                .append(getStatus(), campaign.getStatus())
                .append(getParentListingId(), campaign.getParentListingId())
                .append(getRateCardId(), campaign.getRateCardId())
                .append(getChildFsn(), campaign.getChildFsn())
                .append(getPropertyId(), campaign.getPropertyId())
                .append(getExternalId(), campaign.getExternalId())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getCampaignId())
                .append(getParentFsn())
                .append(getChildListingId())
                .append(getStartTime())
                .append(getEndTime())
                .append(getStatus())
                .append(getParentListingId())
                .append(getRateCardId())
                .append(getChildFsn())
                .append(getPropertyId())
                .append(getExternalId())
                .toHashCode();
    }
}
