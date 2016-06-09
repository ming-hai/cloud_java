
package com.cesanta.cloud;

// GENERATED FILE DO NOT EDIT
// This file is automatically generated with clubbygen.

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
 * The App service manages apps inside a project.
 */
public final class AppService {

    private final Clubby clubby;
    private ClubbyOptions defaultOpts;

    public static AppService createInstance(Clubby clubby) {
        return new AppService(clubby);
    }

    private AppService(Clubby clubby) {
        this.clubby = clubby;
        this.defaultOpts = clubby.getOptions();
    }


    //-- Deploy {{{

    /**
     * Deploy an app
     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      AppService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void deploy(
            AppService.DeployArgs args,
            CmdListener<AppService.DeployResponse> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/App.Deploy",
                args,
                listener,
                AppService.DeployResponse.class,
                opts
                );
    }

    /**
     * Deploy an app
     */
    public void deploy(
            AppService.DeployArgs args,
            CmdListener<AppService.DeployResponse> listener
            ) {
        deploy(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.AppService#deploy deploy} method.
     */
    public static final class DeployArgs  {

        /**
         * App-kind specific deployment attributes.
         */
        @JsonProperty("attrs")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Map<String, String> attrs = new HashMap<String, String>();

        @JsonProperty("path")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private List<String> path = new ArrayList<String>();

        /**
         * If true, the deploy is meant to only affect resources used by the developer, for development purposes.
         */
        @JsonProperty("preview")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Boolean preview;

        /**
         * Deployment target. Keys and semantics depend on the type of the app
         */
        @JsonProperty("target")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Map<String, String> target = new HashMap<String, String>();


        /**
         * Add an item to the app-kind specific deployment attributes.
         */
        public DeployArgs attr(String key, String attr) {
            this.attrs.put(key, attr);
            return this;
        }

        /**
         * Add an item to the path
         */
        public DeployArgs path(String path) {
            this.path.add(path);
            return this;
        }

        /**
         * Set if true, the deploy is meant to only affect resources used by the developer, for development purposes.
         */
        public DeployArgs preview(boolean preview) {
            this.preview = preview;
            return this;
        }

        /**
         * Add an item to the deployment target. Keys and semantics depend on the type of the app
         */
        public DeployArgs target(String key, String target) {
            this.target.put(key, target);
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.AppService#deploy deploy} method.
     */
    public static final class DeployResponse  {


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

