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
 * Allows to manage arbitrary string labels for entities.
 */
public final class LabelService {

    private final Clubby clubby;
    private ClubbyOptions defaultOpts;

    public static LabelService createInstance(Clubby clubby) {
        return new LabelService(clubby);
    }

    private LabelService(Clubby clubby) {
        this.clubby = clubby;
        this.defaultOpts = clubby.getOptions();
    }


    //-- Delete {{{

    /**
     * Deletes labels for entities.
     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      LabelService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void delete(
            LabelService.DeleteArgs args,
            CmdListener<LabelService.DeleteResponse> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/Label.Delete",
                args,
                listener,
                LabelService.DeleteResponse.class,
                opts
                );
    }

    /**
     * Deletes labels for entities.
     */
    public void delete(
            LabelService.DeleteArgs args,
            CmdListener<LabelService.DeleteResponse> listener
            ) {
        delete(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.LabelService#delete delete} method.
     */
    public static final class DeleteArgs  {

        /**
         * List of entity IDs to delete labels for.
         */
        @JsonProperty("ids")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private List<String> ids = new ArrayList<String>();

        /**
         * List of names of labels to delete.
         */
        @JsonProperty("labels")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private List<String> labels = new ArrayList<String>();


        /**
         * Add an item to the list of entity IDs to delete labels for.
         */
        public DeleteArgs id(String id) {
            this.ids.add(id);
            return this;
        }

        /**
         * Add an item to the list of names of labels to delete.
         */
        public DeleteArgs label(String label) {
            this.labels.add(label);
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.LabelService#delete delete} method.
     */
    public static final class DeleteResponse  {


    }


    // }}}

    // }}}

    //-- Get {{{

    /**
     * Returns labels set on a particular entities.
     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      LabelService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void get(
            LabelService.GetArgs args,
            CmdListener<LabelService.GetResponse> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/Label.Get",
                args,
                listener,
                LabelService.GetResponse.class,
                opts
                );
    }

    /**
     * Returns labels set on a particular entities.
     */
    public void get(
            LabelService.GetArgs args,
            CmdListener<LabelService.GetResponse> listener
            ) {
        get(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.LabelService#get get} method.
     */
    public static final class GetArgs  {

        /**
         * List of entity IDs to fetch labels for.
         */
        @JsonProperty("ids")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private List<String> ids = new ArrayList<String>();

        /**
         * Optional list of labels to fetch. If not set, all labels will be returned.
         */
        @JsonProperty("labels")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private List<String> labels = new ArrayList<String>();


        /**
         * Add an item to the list of entity IDs to fetch labels for.
         */
        public GetArgs id(String id) {
            this.ids.add(id);
            return this;
        }

        /**
         * Add an item to the optional list of labels to fetch. If not set, all labels will be returned.
         */
        public GetArgs label(String label) {
            this.labels.add(label);
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.LabelService#get get} method.
     */
    public static final class GetResponse extends ArrayList<GetResponseItem> {

        static final long serialVersionUID = 1;


    }


    public static final class GetResponseItem  {

        @JsonProperty("id")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        public String id;

        @JsonProperty("labels")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        public Map<String, String> labels;


    }


    // }}}

    // }}}

    //-- Set {{{

    /**
     * Sets labels for entities.
     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      LabelService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void set(
            LabelService.SetArgs args,
            CmdListener<LabelService.SetResponse> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/Label.Set",
                args,
                listener,
                LabelService.SetResponse.class,
                opts
                );
    }

    /**
     * Sets labels for entities.
     */
    public void set(
            LabelService.SetArgs args,
            CmdListener<LabelService.SetResponse> listener
            ) {
        set(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.LabelService#set set} method.
     */
    public static final class SetArgs  {

        /**
         * List of entity IDs to set labels for.
         */
        @JsonProperty("ids")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private List<String> ids = new ArrayList<String>();

        /**
         * An object with labels to set. Object keys are label names, corresponding values are label values to set.
         */
        @JsonProperty("labels")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Map<String, String> labels = new HashMap<String, String>();


        /**
         * Add an item to the list of entity IDs to set labels for.
         */
        public SetArgs id(String id) {
            this.ids.add(id);
            return this;
        }

        /**
         * Add an item to the an object with labels to set. Object keys are label names, corresponding values are label values to set.
         */
        public SetArgs label(String key, String label) {
            this.labels.put(key, label);
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.LabelService#set set} method.
     */
    public static final class SetResponse  {


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

