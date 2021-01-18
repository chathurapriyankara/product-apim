/*
 * WSO2 API Manager - Admin
 * This document specifies a **RESTful API** for WSO2 **API Manager** - **Admin Portal**. Please see [full OpenAPI Specification](https://raw.githubusercontent.com/wso2/carbon-apimgt/v6.7.206/components/apimgt/org.wso2.carbon.apimgt.rest.api.admin.v1/src/main/resources/admin-api.yaml) of the API which is written using [OAS 3.0](http://swagger.io/) specification.  # Authentication Our REST APIs are protected using OAuth2 and access control is achieved through scopes. Before you start invoking the the API you need to obtain an access token with the required scopes. This guide will walk you through the steps that you will need to follow to obtain an access token. First you need to obtain the consumer key/secret key pair by calling the dynamic client registration (DCR) endpoint. You can add your preferred grant types in the payload. A sample payload is shown below. ```   {   \"callbackUrl\":\"www.google.lk\",   \"clientName\":\"rest_api_admin\",   \"owner\":\"admin\",   \"grantType\":\"client_credentials password refresh_token\",   \"saasApp\":true   } ``` Create a file (payload.json) with the above sample payload, and use the cURL shown bellow to invoke the DCR endpoint. Authorization header of this should contain the base64 encoded admin username and password. **Format of the request** ```   curl -X POST -H \"Authorization: Basic Base64(admin_username:admin_password)\" -H \"Content-Type: application/json\"   \\ -d @payload.json https://<host>:<servlet_port>/client-registration/v0.17/register ``` **Sample request** ```   curl -X POST -H \"Authorization: Basic YWRtaW46YWRtaW4=\" -H \"Content-Type: application/json\"   \\ -d @payload.json https://localhost:9443/client-registration/v0.17/register ``` Following is a sample response after invoking the above curl. ``` { \"clientId\": \"fOCi4vNJ59PpHucC2CAYfYuADdMa\", \"clientName\": \"rest_api_admin\", \"callBackURL\": \"www.google.lk\", \"clientSecret\": \"a4FwHlq0iCIKVs2MPIIDnepZnYMa\", \"isSaasApplication\": true, \"appOwner\": \"admin\", \"jsonString\": \"{\\\"grant_types\\\":\\\"client_credentials password refresh_token\\\",\\\"redirect_uris\\\":\\\"www.google.lk\\\",\\\"client_name\\\":\\\"rest_api_admin\\\"}\", \"jsonAppAttribute\": \"{}\", \"tokenType\": null } ``` Next you must use the above client id and secret to obtain the access token. We will be using the password grant type for this, you can use any grant type you desire. You also need to add the proper **scope** when getting the access token. All possible scopes for Admin REST API can be viewed in **OAuth2 Security** section of this document and scope for each resource is given in **authorizations** section of resource documentation. Following is the format of the request if you are using the password grant type. ``` curl -k -d \"grant_type=password&username=<admin_username>&password=<admin_passowrd>&scope=<scopes seperated by space>\" \\ -H \"Authorization: Basic base64(cliet_id:client_secret)\" \\ https://<host>:<gateway_port>/token ``` **Sample request** ``` curl https://localhost:8243/token -k \\ -H \"Authorization: Basic Zk9DaTR2Tko1OVBwSHVjQzJDQVlmWXVBRGRNYTphNEZ3SGxxMGlDSUtWczJNUElJRG5lcFpuWU1h\" \\ -d \"grant_type=password&username=admin&password=admin&scope=apim:admin apim:tier_view\" ``` Shown below is a sample response to the above request. ``` { \"access_token\": \"e79bda48-3406-3178-acce-f6e4dbdcbb12\", \"refresh_token\": \"a757795d-e69f-38b8-bd85-9aded677a97c\", \"scope\": \"apim:admin apim:tier_view\", \"token_type\": \"Bearer\", \"expires_in\": 3600 } ``` Now you have a valid access token, which you can use to invoke an API. Navigate through the API descriptions to find the required API, obtain an access token as described above and invoke the API with the authentication header. If you use a different authentication mechanism, this process may change.  # Try out in Postman If you want to try-out the embedded postman collection with \"Run in Postman\" option, please follow the guidelines listed below. * All of the OAuth2 secured endpoints have been configured with an Authorization Bearer header with a parameterized access token. Before invoking any REST API resource make sure you run the `Register DCR Application` and `Generate Access Token` requests to fetch an access token with all required scopes. * Make sure you have an API Manager instance up and running. * Update the `basepath` parameter to match the hostname and port of the APIM instance.  [![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/f5ac2ca9fb22afef6ed6) 
 *
 * The version of the OpenAPI document: v1.2
 * Contact: architecture@wso2.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.wso2.am.integration.clients.admin.api.dto;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import org.wso2.am.integration.clients.admin.api.dto.CustomUrlInfoDevPortalDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
/**
* The custom url information of the tenant domain
*/
    @ApiModel(description = "The custom url information of the tenant domain")

public class CustomUrlInfoDTO {
        public static final String SERIALIZED_NAME_TENANT_DOMAIN = "tenantDomain";
        @SerializedName(SERIALIZED_NAME_TENANT_DOMAIN)
            private String tenantDomain;

        public static final String SERIALIZED_NAME_TENANT_ADMIN_USERNAME = "tenantAdminUsername";
        @SerializedName(SERIALIZED_NAME_TENANT_ADMIN_USERNAME)
            private String tenantAdminUsername;

        public static final String SERIALIZED_NAME_ENABLED = "enabled";
        @SerializedName(SERIALIZED_NAME_ENABLED)
            private Boolean enabled;

        public static final String SERIALIZED_NAME_DEV_PORTAL = "devPortal";
        @SerializedName(SERIALIZED_NAME_DEV_PORTAL)
            private CustomUrlInfoDevPortalDTO devPortal;


        public CustomUrlInfoDTO tenantDomain(String tenantDomain) {
        
        this.tenantDomain = tenantDomain;
        return this;
        }

    /**
        * Get tenantDomain
    * @return tenantDomain
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "carbon.super", value = "")
    
    public String getTenantDomain() {
        return tenantDomain;
    }


    public void setTenantDomain(String tenantDomain) {
        this.tenantDomain = tenantDomain;
    }


        public CustomUrlInfoDTO tenantAdminUsername(String tenantAdminUsername) {
        
        this.tenantAdminUsername = tenantAdminUsername;
        return this;
        }

    /**
        * Get tenantAdminUsername
    * @return tenantAdminUsername
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "john@foo.com", value = "")
    
    public String getTenantAdminUsername() {
        return tenantAdminUsername;
    }


    public void setTenantAdminUsername(String tenantAdminUsername) {
        this.tenantAdminUsername = tenantAdminUsername;
    }


        public CustomUrlInfoDTO enabled(Boolean enabled) {
        
        this.enabled = enabled;
        return this;
        }

    /**
        * Get enabled
    * @return enabled
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "true", value = "")
    
    public Boolean isEnabled() {
        return enabled;
    }


    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }


        public CustomUrlInfoDTO devPortal(CustomUrlInfoDevPortalDTO devPortal) {
        
        this.devPortal = devPortal;
        return this;
        }

    /**
        * Get devPortal
    * @return devPortal
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "")
    
    public CustomUrlInfoDevPortalDTO getDevPortal() {
        return devPortal;
    }


    public void setDevPortal(CustomUrlInfoDevPortalDTO devPortal) {
        this.devPortal = devPortal;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
        return true;
        }
        if (o == null || getClass() != o.getClass()) {
        return false;
        }
            CustomUrlInfoDTO customUrlInfo = (CustomUrlInfoDTO) o;
            return Objects.equals(this.tenantDomain, customUrlInfo.tenantDomain) &&
            Objects.equals(this.tenantAdminUsername, customUrlInfo.tenantAdminUsername) &&
            Objects.equals(this.enabled, customUrlInfo.enabled) &&
            Objects.equals(this.devPortal, customUrlInfo.devPortal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenantDomain, tenantAdminUsername, enabled, devPortal);
    }


@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append("class CustomUrlInfoDTO {\n");
    sb.append("    tenantDomain: ").append(toIndentedString(tenantDomain)).append("\n");
    sb.append("    tenantAdminUsername: ").append(toIndentedString(tenantAdminUsername)).append("\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    devPortal: ").append(toIndentedString(devPortal)).append("\n");
sb.append("}");
return sb.toString();
}

/**
* Convert the given object to string with each line indented by 4 spaces
* (except the first line).
*/
private String toIndentedString(Object o) {
if (o == null) {
return "null";
}
return o.toString().replace("\n", "\n    ");
}

}

