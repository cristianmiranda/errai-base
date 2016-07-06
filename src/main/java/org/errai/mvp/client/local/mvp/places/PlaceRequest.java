package org.errai.mvp.client.local.mvp.places;

import java.util.LinkedHashMap;
import java.util.Map;

public class PlaceRequest {
    public static final class Builder {
        private IsPlace place;
        private Map<String, String> params;

        public Builder() {
        }

        public Builder(PlaceRequest request) {
            this.place = request.place;
            this.with(request.params);
        }

        public PlaceRequest.Builder to(IsPlace place) {
            this.place = place;
            return this;
        }

        public PlaceRequest.Builder with(String name, String value) {
            this.lazyInitializeParamMap();
            if (value != null) {
                this.params.put(name, value);
            }

            return this;
        }

        public PlaceRequest.Builder with(Map<String, String> params) {
            if (params != null) {
                this.lazyInitializeParamMap();
                this.params.putAll(params);
            }

            return this;
        }

        public PlaceRequest.Builder without(String name) {
            if (this.params != null) {
                this.params.remove(name);
            }

            return this;
        }

        private void lazyInitializeParamMap() {
            if (this.params == null) {
                this.params = new LinkedHashMap();
            }
        }

        public PlaceRequest build() {
            return new PlaceRequest(this.place, this.params);
        }
    }

    private IsPlace place;
    private Map<String, String> params;

    public PlaceRequest(IsPlace place, Map<String, String> params) {
        this.place = place;
        this.params = params;
    }

    public IsPlace getPlace() {
        return place;
    }

    public void setPlace(IsPlace place) {
        this.place = place;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PlaceRequest that = (PlaceRequest) o;

        if (place != null ? !place.equals(that.place) : that.place != null) {
            return false;
        }
        return !(params != null ? !params.equals(that.params) : that.params != null);
    }

    @Override
    public int hashCode() {
        int result = place != null ? place.hashCode() : 0;
        result = 31 * result + (params != null ? params.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PlaceRequest{" +
                "place=" + place +
                ", params=" + params +
                '}';
    }
}
