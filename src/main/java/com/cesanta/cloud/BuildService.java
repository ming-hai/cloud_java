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
 * The Build service allows to build a SJS project living in a Workspace.
 */
public final class BuildService {

    private final Clubby clubby;
    private ClubbyOptions defaultOpts;

    public static BuildService createInstance(Clubby clubby) {
        return new BuildService(clubby);
    }

    private BuildService(Clubby clubby) {
        this.clubby = clubby;
        this.defaultOpts = clubby.getOptions();
    }


    //-- Build {{{

    /**
     * 
     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      BuildService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void build(
            BuildService.BuildArgs args,
            CmdListener<String> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/Build.Build",
                args,
                listener,
                String.class,
                opts
                );
    }

    /**
     * 
     */
    public void build(
            BuildService.BuildArgs args,
            CmdListener<String> listener
            ) {
        build(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.BuildService#build build} method.
     */
    public static final class BuildArgs  {

        /**
         * Path on the blobstore service to the root of the workspace to be built
         */
        @JsonProperty("workspace")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private List<String> workspace = new ArrayList<String>();


        /**
         * Add an item to the path on the blobstore service to the root of the workspace to be built
         */
        public BuildArgs workspace(String workspace) {
            this.workspace.add(workspace);
            return this;
        }

    }


    // }}}

    //-- response {{{

    // }}}

    // }}}

    //-- List {{{

    /**
     * List the last `limit` build jobs, filtered by an optional filter, ordered by descending acceptance time.
     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      BuildService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void list(
            BuildService.ListArgs args,
            CmdListener<BuildService.ListResponse> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/Build.List",
                args,
                listener,
                BuildService.ListResponse.class,
                opts
                );
    }

    /**
     * List the last `limit` build jobs, filtered by an optional filter, ordered by descending acceptance time.
     */
    public void list(
            BuildService.ListArgs args,
            CmdListener<BuildService.ListResponse> listener
            ) {
        list(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.BuildService#list list} method.
     */
    public static final class ListArgs  {

        @JsonProperty("filter")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private ListArgsFilter filter = new ListArgsFilter();

        /**
         * Maximum number of returned entries
         */
        @JsonProperty("limit")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Long limit;


        /**
         * Set filter
         */
        public ListArgs filter(ListArgsFilter filter) {
            this.filter = filter;
            return this;
        }

        /**
         * Set maximum number of returned entries
         */
        public ListArgs limit(long limit) {
            this.limit = limit;
            return this;
        }

    }


    public static final class ListArgsFilter  {

        /**
         * list only the result which matches the given job ID
         */
        @JsonProperty("id")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String id;

        /**
         * list only builds matching workspaces belonging to a given project
         */
        @JsonProperty("projectid")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String projectid;

        /**
         * list only builds matching a given workspace
         */
        @JsonProperty("workspace")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private List<String> workspace = new ArrayList<String>();


        /**
         * Set list only the result which matches the given job ID
         */
        public ListArgsFilter id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Set list only builds matching workspaces belonging to a given project
         */
        public ListArgsFilter projectid(String projectid) {
            this.projectid = projectid;
            return this;
        }

        /**
         * Add an item to the list only builds matching a given workspace
         */
        public ListArgsFilter workspace(String workspace) {
            this.workspace.add(workspace);
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.BuildService#list list} method.
     */
    public static final class ListResponse extends ArrayList<ListResponseItem> {

        static final long serialVersionUID = 1;


    }


    public static final class ListResponseItem  {

        /**
         * Build artefacts such as FW zip files. Usually a Firmware build will produce only one artefact.
         */
        @JsonProperty("artifacts")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        public List<ListResponseItemArtifact> artifacts;

        /**
         * timestamp of when the job is done
         */
        @JsonProperty("doneTime")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        public String doneTime;

        @JsonProperty("id")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        public String id;

        /**
         * once done, is it success or failure
         */
        @JsonProperty("outcome")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        public String outcome;

        /**
         * timestamp of when the first task is switched to running state
         */
        @JsonProperty("startTime")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        public String startTime;

        /**
         * execution state: pending, running, done
         */
        @JsonProperty("state")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        public String state;

        /**
         * timestamp of job submission
         */
        @JsonProperty("submissionTime")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        public String submissionTime;


    }


    public static final class ListResponseItemArtifact  {

        @JsonProperty("name")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        public String name;

        @JsonProperty("path")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        public List<String> path;


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

