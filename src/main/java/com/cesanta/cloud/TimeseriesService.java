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
public final class TimeseriesService {

    private final Clubby clubby;
    private ClubbyOptions defaultOpts;

    public static TimeseriesService createInstance(Clubby clubby) {
        return new TimeseriesService(clubby);
    }

    private TimeseriesService(Clubby clubby) {
        this.clubby = clubby;
        this.defaultOpts = clubby.getOptions();
    }


    //-- Query {{{

    /**
     * Query returns the result of executing `query` on the data stored. `query` uses Prometheus query language.
     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      TimeseriesService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void query(
            TimeseriesService.QueryArgs args,
            CmdListener<TimeseriesService.QueryResponse> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/Timeseries.Query",
                args,
                listener,
                TimeseriesService.QueryResponse.class,
                opts
                );
    }

    /**
     * Query returns the result of executing `query` on the data stored. `query` uses Prometheus query language.
     */
    public void query(
            TimeseriesService.QueryArgs args,
            CmdListener<TimeseriesService.QueryResponse> listener
            ) {
        query(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.TimeseriesService#query query} method.
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
     * Response of the {@link com.cesanta.cloud.TimeseriesService#query query} method.
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

    //-- Report {{{

    /**
     * Report adds new value to the storage. Label 'src' is implicitly added.
     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      TimeseriesService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void report(
            TimeseriesService.ReportArgs args,
            CmdListener<TimeseriesService.ReportResponse> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/Timeseries.Report",
                args,
                listener,
                TimeseriesService.ReportResponse.class,
                opts
                );
    }

    /**
     * Report adds new value to the storage. Label 'src' is implicitly added.
     */
    public void report(
            TimeseriesService.ReportArgs args,
            CmdListener<TimeseriesService.ReportResponse> listener
            ) {
        report(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.TimeseriesService#report report} method.
     */
    public static final class ReportArgs  {

        /**
         * Label set.
         */
        @JsonProperty("labels")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private ReportArgsLabel labels;

        /**
         * Timestamp.
         */
        @JsonProperty("timestamp")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Long timestamp;

        /**
         * Value.
         */
        @JsonProperty("value")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Double value;


        /**
         * Add an item to the label set.
         */
        public ReportArgs label(String key, String label) {
            this.labels.put(key, label);
            return this;
        }

        /**
         * Set timestamp.
         */
        public ReportArgs timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /**
         * Set value.
         */
        public ReportArgs value(double value) {
            this.value = value;
            return this;
        }

    }


    public static final class ReportArgsLabel extends HashMap<String, String> {

        static final long serialVersionUID = 1;


        public  ReportArgsLabel(String __name__) {
            this.put("__name__", __name__);
        }

        public ReportArgsLabel add(String key, String value) {
            super.put(key, value);
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.TimeseriesService#report report} method.
     */
    public static final class ReportResponse  {


    }


    // }}}

    // }}}

    //-- ReportMany {{{

    /**
     * ReportMany adds new values to the storage. Label 'src' is implicitly added to each timeseries.
     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      TimeseriesService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void reportMany(
            TimeseriesService.ReportManyArgs args,
            CmdListener<TimeseriesService.ReportManyResponse> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/Timeseries.ReportMany",
                args,
                listener,
                TimeseriesService.ReportManyResponse.class,
                opts
                );
    }

    /**
     * ReportMany adds new values to the storage. Label 'src' is implicitly added to each timeseries.
     */
    public void reportMany(
            TimeseriesService.ReportManyArgs args,
            CmdListener<TimeseriesService.ReportManyResponse> listener
            ) {
        reportMany(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.TimeseriesService#reportMany reportMany} method.
     */
    public static final class ReportManyArgs  {

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
        private List<ReportManyArgsVar> vars = new ArrayList<ReportManyArgsVar>();


        /**
         * Set timestamp.
         */
        public ReportManyArgs timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /**
         * Add an item to the list of labels and values. Each element must be an array with 2 elements: an object, which keys and values are used as label names and label values respectively, and a number - the actual value.
         */
        public ReportManyArgs var(ReportManyArgsVar var) {
            this.vars.add(var);
            return this;
        }

    }


    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    public static final class ReportManyArgsVar  {

        /**
         * Label set.
         */
        @JsonProperty("0")
        private ReportManyArgsVarFirst first;

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
        public  ReportManyArgsVar(ReportManyArgsVarFirst first, double second) {
            this.first = first;
            this.second = second;
        }

    }


    public static final class ReportManyArgsVarFirst extends HashMap<String, String> {

        static final long serialVersionUID = 1;


        public  ReportManyArgsVarFirst(String __name__) {
            this.put("__name__", __name__);
        }

        public ReportManyArgsVarFirst add(String key, String value) {
            super.put(key, value);
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.TimeseriesService#reportMany reportMany} method.
     */
    public static final class ReportManyResponse  {


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

