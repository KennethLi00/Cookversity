package com.example.cookversity.Entities;

import java.io.Serializable;
import java.util.List;

import com.example.cookversity.Entities.RecipeShort;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RecipeShortResponse implements Serializable
{

    @SerializedName("results")
    @Expose
    private List<RecipeShort> results = null;
    @SerializedName("baseUri")
    @Expose
    private String baseUri;
    @SerializedName("offset")
    @Expose
    private Integer offset;
    @SerializedName("number")
    @Expose
    private Integer number;
    @SerializedName("totalResults")
    @Expose
    private Integer totalResults;
    @SerializedName("processingTimeMs")
    @Expose
    private long processingTimeMs;
    @SerializedName("expires")
    @Expose
    private long expires;
    @SerializedName("isStale")
    @Expose
    private Boolean isStale;
    private final static long serialVersionUID = -3212328946874672359L;

    /**
     * No args constructor for use in serialization
     *
     */
    public RecipeShortResponse() {
    }

    /**
     *
     * @param number
     * @param totalResults
     * @param expires
     * @param offset
     * @param processingTimeMs
     * @param baseUri
     * @param isStale
     * @param results
     */
    public RecipeShortResponse(List<RecipeShort> results, String baseUri, Integer offset, Integer number, Integer totalResults, long processingTimeMs, long expires, Boolean isStale) {
        super();
        this.results = results;
        this.baseUri = baseUri;
        this.offset = offset;
        this.number = number;
        this.totalResults = totalResults;
        this.processingTimeMs = processingTimeMs;
        this.expires = expires;
        this.isStale = isStale;
    }

    public List<RecipeShort> getResults() {
        return results;
    }

    public void setResults(List<RecipeShort> results) {
        this.results = results;
    }

    public RecipeShortResponse withResults(List<RecipeShort> results) {
        this.results = results;
        return this;
    }

    public String getBaseUri() {
        return baseUri;
    }

    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }

    public RecipeShortResponse withBaseUri(String baseUri) {
        this.baseUri = baseUri;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public RecipeShortResponse withOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public RecipeShortResponse withNumber(Integer number) {
        this.number = number;
        return this;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public RecipeShortResponse withTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
        return this;
    }

    public long getProcessingTimeMs() {
        return processingTimeMs;
    }

    public void setProcessingTimeMs(Integer processingTimeMs) {
        this.processingTimeMs = processingTimeMs;
    }

    public RecipeShortResponse withProcessingTimeMs(Integer processingTimeMs) {
        this.processingTimeMs = processingTimeMs;
        return this;
    }

    public long getExpires() {
        return expires;
    }

    public void setExpires(long expires) {
        this.expires = expires;
    }

    public RecipeShortResponse withExpires(long expires) {
        this.expires = expires;
        return this;
    }

    public Boolean getIsStale() {
        return isStale;
    }

    public void setIsStale(Boolean isStale) {
        this.isStale = isStale;
    }

    public RecipeShortResponse withIsStale(Boolean isStale) {
        this.isStale = isStale;
        return this;
    }

}