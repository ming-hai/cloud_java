
package com.cesanta.cloud;

// GENERATED FILE DO NOT EDIT
// This file is automatically generated with clubbygen.

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.cesanta.clubby.lib.Clubby;
import com.cesanta.clubby.lib.CmdListener;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Provides methods for managing users. Used by the frontend.
 */
public final class UserService {

    private final Clubby clubby;

    public static UserService createInstance(Clubby clubby) {
        return new UserService(clubby);
    }

    private UserService(Clubby clubby) {
        this.clubby = clubby;
    }


    //-- Create {{{

    /**
     * Creates a new user. Can only be called by the frontend.
     */
    public void create(
            UserService.CreateArgs args,
            CmdListener<UserService.CreateResponse> listener
            ) {
        clubby.callBackend(
                "/v1/User.Create",
                args,
                listener,
                UserService.CreateResponse.class
                );
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.UserService#create create} method.
     */
    public static final class CreateArgs  {

        /**
         * User's email address.
         */
        @JsonProperty("email")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String email;

        /**
         * ID for the new user.
         */
        @JsonProperty("id")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String id;

        /**
         * Display name for the user.
         */
        @JsonProperty("name")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String name;

        /**
         * Password for the user.
         */
        @JsonProperty("password")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String password;


        /**
         * Set user's email address.
         */
        public CreateArgs email(String email) {
            this.email = email;
            return this;
        }

        /**
         * Set ID for the new user.
         */
        public CreateArgs id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Set display name for the user.
         */
        public CreateArgs name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Set password for the user.
         */
        public CreateArgs password(String password) {
            this.password = password;
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.UserService#create create} method.
     */
    public static final class CreateResponse  {


    }


    // }}}

    // }}}

    //-- Get {{{

    /**
     * Retrieves info about an existing user.
     */
    public void get(
            UserService.GetArgs args,
            CmdListener<UserService.GetResponse> listener
            ) {
        clubby.callBackend(
                "/v1/User.Get",
                args,
                listener,
                UserService.GetResponse.class
                );
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.UserService#get get} method.
     */
    public static final class GetArgs  {

        /**
         * ID of the user.
         */
        @JsonProperty("id")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String id;


        /**
         * Set ID of the user.
         */
        public GetArgs id(String id) {
            this.id = id;
            return this;
        }

    }


    // }}}

    //-- response {{{

    public static final class GetResponse  {

        @JsonProperty("email")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        public String email;

        @JsonProperty("name")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        public String name;


    }


    // }}}

    // }}}


}
