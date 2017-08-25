
package com.dicoding.asiangamesschedule.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventResponse {

    @SerializedName("arenas")
    @Expose
    private List<Arena> arenas = null;
    @SerializedName("arenasLocked")
    @Expose
    private boolean arenasLocked;
    @SerializedName("assetHash")
    @Expose
    private Object assetHash;
    @SerializedName("assetMimeType")
    @Expose
    private Object assetMimeType;
    @SerializedName("assetUrl")
    @Expose
    private String assetUrl;
    @SerializedName("createdBy")
    @Expose
    private String createdBy;
    @SerializedName("createdByLocked")
    @Expose
    private boolean createdByLocked;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("descriptionLocked")
    @Expose
    private boolean descriptionLocked;
    @SerializedName("endTime")
    @Expose
    private String endTime;
    @SerializedName("endTimeLocked")
    @Expose
    private boolean endTimeLocked;
    @SerializedName("eventOrder")
    @Expose
    private int eventOrder;
    @SerializedName("eventOrderLocked")
    @Expose
    private boolean eventOrderLocked;
    @SerializedName("externalId")
    @Expose
    private Object externalId;
    @SerializedName("externalIdLocked")
    @Expose
    private boolean externalIdLocked;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("imageUrl")
    @Expose
    private Object imageUrl;
    @SerializedName("imageUrlLocked")
    @Expose
    private boolean imageUrlLocked;
    @SerializedName("linkedEntities")
    @Expose
    private List<Object> linkedEntities = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("nameLocked")
    @Expose
    private boolean nameLocked;
    @SerializedName("parentId")
    @Expose
    private int parentId;
    @SerializedName("parentIdLocked")
    @Expose
    private boolean parentIdLocked;
    @SerializedName("poiListId")
    @Expose
    private Object poiListId;
    @SerializedName("poiListIdLocked")
    @Expose
    private boolean poiListIdLocked;
    @SerializedName("poiTagId")
    @Expose
    private Object poiTagId;
    @SerializedName("poiTagIdLocked")
    @Expose
    private Object poiTagIdLocked;
    @SerializedName("startTime")
    @Expose
    private String startTime;
    @SerializedName("startTimeLocked")
    @Expose
    private boolean startTimeLocked;
    @SerializedName("status")
    @Expose
    private Object status;
    @SerializedName("statusLocked")
    @Expose
    private boolean statusLocked;
    @SerializedName("subEvents")
    @Expose
    private List<SubEvent> subEvents = null;
    @SerializedName("subEventsLocked")
    @Expose
    private boolean subEventsLocked;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    @SerializedName("tagsLocked")
    @Expose
    private boolean tagsLocked;
    @SerializedName("url")
    @Expose
    private Object url;
    @SerializedName("urlLocked")
    @Expose
    private Object urlLocked;

    public List<Arena> getArenas() {
        return arenas;
    }

    public void setArenas(List<Arena> arenas) {
        this.arenas = arenas;
    }

    public boolean isArenasLocked() {
        return arenasLocked;
    }

    public void setArenasLocked(boolean arenasLocked) {
        this.arenasLocked = arenasLocked;
    }

    public Object getAssetHash() {
        return assetHash;
    }

    public void setAssetHash(Object assetHash) {
        this.assetHash = assetHash;
    }

    public Object getAssetMimeType() {
        return assetMimeType;
    }

    public void setAssetMimeType(Object assetMimeType) {
        this.assetMimeType = assetMimeType;
    }

    public String getAssetUrl() {
        return assetUrl;
    }

    public void setAssetUrl(String assetUrl) {
        this.assetUrl = assetUrl;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public boolean isCreatedByLocked() {
        return createdByLocked;
    }

    public void setCreatedByLocked(boolean createdByLocked) {
        this.createdByLocked = createdByLocked;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDescriptionLocked() {
        return descriptionLocked;
    }

    public void setDescriptionLocked(boolean descriptionLocked) {
        this.descriptionLocked = descriptionLocked;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public boolean isEndTimeLocked() {
        return endTimeLocked;
    }

    public void setEndTimeLocked(boolean endTimeLocked) {
        this.endTimeLocked = endTimeLocked;
    }

    public int getEventOrder() {
        return eventOrder;
    }

    public void setEventOrder(int eventOrder) {
        this.eventOrder = eventOrder;
    }

    public boolean isEventOrderLocked() {
        return eventOrderLocked;
    }

    public void setEventOrderLocked(boolean eventOrderLocked) {
        this.eventOrderLocked = eventOrderLocked;
    }

    public Object getExternalId() {
        return externalId;
    }

    public void setExternalId(Object externalId) {
        this.externalId = externalId;
    }

    public boolean isExternalIdLocked() {
        return externalIdLocked;
    }

    public void setExternalIdLocked(boolean externalIdLocked) {
        this.externalIdLocked = externalIdLocked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Object imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isImageUrlLocked() {
        return imageUrlLocked;
    }

    public void setImageUrlLocked(boolean imageUrlLocked) {
        this.imageUrlLocked = imageUrlLocked;
    }

    public List<Object> getLinkedEntities() {
        return linkedEntities;
    }

    public void setLinkedEntities(List<Object> linkedEntities) {
        this.linkedEntities = linkedEntities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNameLocked() {
        return nameLocked;
    }

    public void setNameLocked(boolean nameLocked) {
        this.nameLocked = nameLocked;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public boolean isParentIdLocked() {
        return parentIdLocked;
    }

    public void setParentIdLocked(boolean parentIdLocked) {
        this.parentIdLocked = parentIdLocked;
    }

    public Object getPoiListId() {
        return poiListId;
    }

    public void setPoiListId(Object poiListId) {
        this.poiListId = poiListId;
    }

    public boolean isPoiListIdLocked() {
        return poiListIdLocked;
    }

    public void setPoiListIdLocked(boolean poiListIdLocked) {
        this.poiListIdLocked = poiListIdLocked;
    }

    public Object getPoiTagId() {
        return poiTagId;
    }

    public void setPoiTagId(Object poiTagId) {
        this.poiTagId = poiTagId;
    }

    public Object getPoiTagIdLocked() {
        return poiTagIdLocked;
    }

    public void setPoiTagIdLocked(Object poiTagIdLocked) {
        this.poiTagIdLocked = poiTagIdLocked;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public boolean isStartTimeLocked() {
        return startTimeLocked;
    }

    public void setStartTimeLocked(boolean startTimeLocked) {
        this.startTimeLocked = startTimeLocked;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public boolean isStatusLocked() {
        return statusLocked;
    }

    public void setStatusLocked(boolean statusLocked) {
        this.statusLocked = statusLocked;
    }

    public List<SubEvent> getSubEvents() {
        return subEvents;
    }

    public void setSubEvents(List<SubEvent> subEvents) {
        this.subEvents = subEvents;
    }

    public boolean isSubEventsLocked() {
        return subEventsLocked;
    }

    public void setSubEventsLocked(boolean subEventsLocked) {
        this.subEventsLocked = subEventsLocked;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public boolean isTagsLocked() {
        return tagsLocked;
    }

    public void setTagsLocked(boolean tagsLocked) {
        this.tagsLocked = tagsLocked;
    }

    public Object getUrl() {
        return url;
    }

    public void setUrl(Object url) {
        this.url = url;
    }

    public Object getUrlLocked() {
        return urlLocked;
    }

    public void setUrlLocked(Object urlLocked) {
        this.urlLocked = urlLocked;
    }

}
