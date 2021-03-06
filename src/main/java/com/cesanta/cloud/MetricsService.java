/*
 * GENERATED FILE DO NOT EDIT
 * This file is automatically generated with miot clubbygen.
 *
 * Copyright (c) 2016 Cesanta Software Limited
 * All rights reserved
 */

package com.cesanta.cloud;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.cesanta.clubby.lib.Clubby;
import com.cesanta.clubby.lib.ClubbyOptions;
import com.cesanta.clubby.lib.CmdListener;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Metrics service provides timeseries storage.
 */
public final class MetricsService {

    private final Clubby clubby;
    private ClubbyOptions defaultOpts;

    public static MetricsService createInstance(Clubby clubby) {
        return new MetricsService(clubby);
    }

    private MetricsService(Clubby clubby) {
        this.clubby = clubby;
        this.defaultOpts = clubby.getOptions();
    }


    //-- Publish {{{

    /**
     * Publish adds new values to the storage. Label 'src' is implicitly added to each timeseries.
     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      MetricsService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void publish(
            MetricsService.PublishArgs args,
            CmdListener<MetricsService.PublishResponse> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/Metrics.Publish",
                args,
                listener,
                MetricsService.PublishResponse.class,
                opts
                );
    }

    /**
     * Publish adds new values to the storage. Label 'src' is implicitly added to each timeseries.
     */
    public void publish(
            MetricsService.PublishArgs args,
            CmdListener<MetricsService.PublishResponse> listener
            ) {
        publish(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.MetricsService#publish publish} method.
     */
    public static final class PublishArgs  {

        /**
         * Timestamp.
         */
        @JsonProperty("timestamp")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Long timestamp;

        /**
         * List of labels and values. Each element must be an array with 2 elements: an object, which keys and values are used as label names and label values respectively, and a number - the actual value.
         */
        @JsonProperty("vars")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private List<PublishArgsVar> vars = new ArrayList<PublishArgsVar>();


        /**
         * Set timestamp.
         */
        public PublishArgs timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /**
         * Add an item to the list of labels and values. Each element must be an array with 2 elements: an object, which keys and values are used as label names and label values respectively, and a number - the actual value.
         */
        public PublishArgs var(PublishArgsVar var) {
            this.vars.add(var);
            return this;
        }

    }


    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    public static final class PublishArgsVar  {

        /**
         * Label set.
         */
        @JsonProperty("0")
        private PublishArgsVarFirst first;

        /**
         * Value.
         */
        @JsonProperty("1")
        private Double second;


        /**
         *  
         * @param first Label set.
         * @param second Value.
         */
        public  PublishArgsVar(PublishArgsVarFirst first, double second) {
            this.first = first;
            this.second = second;
        }

    }


    public static final class PublishArgsVarFirst extends HashMap<String, String> {

        static final long serialVersionUID = 1;


        public  PublishArgsVarFirst(String __name__) {
            this.put("__name__", __name__);
        }

        public PublishArgsVarFirst add(String key, String value) {
            super.put(key, value);
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.MetricsService#publish publish} method.
     */
    public static final class PublishResponse  {


    }


    // }}}

    // }}}

    //-- Query {{{

    /**
     * Query returns the result of executing `query` on the data stored. `query` uses Prometheus query language.
     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      MetricsService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void query(
            MetricsService.QueryArgs args,
            CmdListener<MetricsService.QueryResponse> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/Metrics.Query",
                args,
                listener,
                MetricsService.QueryResponse.class,
                opts
                );
    }

    /**
     * Query returns the result of executing `query` on the data stored. `query` uses Prometheus query language.
     */
    public void query(
            MetricsService.QueryArgs args,
            CmdListener<MetricsService.QueryResponse> listener
            ) {
        query(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.MetricsService#query query} method.
     */
    public static final class QueryArgs  {

        /**
         * Query to execute.
         */
        @JsonProperty("query")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String query;


        /**
         * Set query to execute.
         */
        public QueryArgs query(String query) {
            this.query = query;
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.MetricsService#query query} method.
     */
    public static final class QueryResponse extends ArrayList<QueryResponseItem> {

        static final long serialVersionUID = 1;


    }


    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    public static final class QueryResponseItem  {

        @JsonProperty("0")
        public Map<String, String> first;

        @JsonProperty("1")
        public List<QueryResponseItemSecond> second;


    }


    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    public static final class QueryResponseItemSecond  {

        /**
         * Timestamp.
         */
        @JsonProperty("0")
        public Long first;

        /**
         * Value.
         */
        @JsonProperty("1")
        public Double second;


    }


    // }}}

    // }}}


    public void setDefaultOptions(ClubbyOptions opts) {
        this.defaultOpts = ClubbyOptions.createFrom(opts);
    }

    public ClubbyOptions getOptions() {
        return ClubbyOptions.createFrom(defaultOpts);
    }
}

