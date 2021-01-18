/*
 * WSO2 API Manager - Developer Portal
 * This document specifies a **RESTful API** for WSO2 **API Manager** - **Developer Portal**. Please see [full OpenAPI Specification](https://raw.githubusercontent.com/wso2/carbon-apimgt/v6.7.206/components/apimgt/org.wso2.carbon.apimgt.rest.api.store.v1/src/main/resources/store-api.yaml) of the API which is written using [OAS 3.0](http://swagger.io/) specification.  # Authentication Our REST APIs are protected using OAuth2 and access control is achieved through scopes. Before you start invoking the API, you need to obtain an access token with the required scopes. This guide will walk you through the steps that you will need to follow to obtain an access token. First you need to obtain the consumer key/secret key pair by calling the dynamic client registration (DCR) endpoint. You can add your preferred grant types in the payload. A Sample payload is shown below. ```   {   \"callbackUrl\":\"www.google.lk\",   \"clientName\":\"rest_api_devportal\",   \"owner\":\"admin\",   \"grantType\":\"client_credentials password refresh_token\",   \"saasApp\":true   } ``` Create a file (payload.json) with the above sample payload, and use the cURL shown below to invoke the DCR endpoint. Authorization header of this should contain the base64 encoded admin username and password. **Format of the request** ```   curl -X POST -H \"Authorization: Basic Base64(admin_username:admin_password)\" -H \"Content-Type: application/json\"   \\ -d @payload.json https://<host>:<servlet_port>/client-registration/v0.17/register ``` **Sample request** ```   curl -X POST -H \"Authorization: Basic YWRtaW46YWRtaW4=\" -H \"Content-Type: application/json\"   \\ -d @payload.json https://localhost:9443/client-registration/v0.17/register ``` Following is a sample response after invoking the above curl. ``` { \"clientId\": \"fOCi4vNJ59PpHucC2CAYfYuADdMa\", \"clientName\": \"rest_api_store\", \"callBackURL\": \"www.google.lk\", \"clientSecret\": \"a4FwHlq0iCIKVs2MPIIDnepZnYMa\", \"isSaasApplication\": true, \"appOwner\": \"admin\", \"jsonString\": \"{\\\"grant_types\\\":\\\"client_credentials password refresh_token\\\",\\\"redirect_uris\\\":\\\"www.google.lk\\\",\\\"client_name\\\":\\\"rest_api_devportal\\\"}\", \"jsonAppAttribute\": \"{}\", \"tokenType\": null } ``` Next you must use the above client id and secret to obtain the access token. We will be using the password grant type for this, you can use any grant type you desire. You also need to add the proper **scope** when getting the access token. All possible scopes for devportal REST API can be viewed in **OAuth2 Security** section of this document and scope for each resource is given in **authorization** section of resource documentation. Following is the format of the request if you are using the password grant type. ``` curl -k -d \"grant_type=password&username=<admin_username>&password=<admin_password>&scope=<scopes separated by space>\" \\ -H \"Authorization: Basic base64(cliet_id:client_secret)\" \\ https://<host>:<gateway_port>/token ``` **Sample request** ``` curl https://localhost:8243/token -k \\ -H \"Authorization: Basic Zk9DaTR2Tko1OVBwSHVjQzJDQVlmWXVBRGRNYTphNEZ3SGxxMGlDSUtWczJNUElJRG5lcFpuWU1h\" \\ -d \"grant_type=password&username=admin&password=admin&scope=apim:subscribe apim:api_key\" ``` Shown below is a sample response to the above request. ``` { \"access_token\": \"e79bda48-3406-3178-acce-f6e4dbdcbb12\", \"refresh_token\": \"a757795d-e69f-38b8-bd85-9aded677a97c\", \"scope\": \"apim:subscribe apim:api_key\", \"token_type\": \"Bearer\", \"expires_in\": 3600 } ``` Now you have a valid access token, which you can use to invoke an API. Navigate through the API descriptions to find the required API, obtain an access token as described above and invoke the API with the authentication header. If you use a different authentication mechanism, this process may change.  # Try out in Postman If you want to try-out the embedded postman collection with \"Run in Postman\" option, please follow the guidelines listed below. * All of the OAuth2 secured endpoints have been configured with an Authorization Bearer header with a parameterized access token. Before invoking any REST API resource make sure you run the `Register DCR Application` and `Generate Access Token` requests to fetch an access token with all required scopes. * Make sure you have an API Manager instance up and running. * Update the `basepath` parameter to match the hostname and port of the APIM instance.  [![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/5bc0161b8aa7e701d7bf) 
 *
 * The version of the OpenAPI document: v1.1
 * Contact: architecture@wso2.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.wso2.am.integration.clients.store.api.v1.dto;

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
import org.wso2.am.integration.clients.store.api.v1.dto.APIInfoDTO;
import org.wso2.am.integration.clients.store.api.v1.dto.ApplicationInfoDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
/**
* SubscriptionDTO
*/

public class SubscriptionDTO {
        public static final String SERIALIZED_NAME_SUBSCRIPTION_ID = "subscriptionId";
        @SerializedName(SERIALIZED_NAME_SUBSCRIPTION_ID)
            private String subscriptionId;

        public static final String SERIALIZED_NAME_APPLICATION_ID = "applicationId";
        @SerializedName(SERIALIZED_NAME_APPLICATION_ID)
            private String applicationId;

        public static final String SERIALIZED_NAME_API_ID = "apiId";
        @SerializedName(SERIALIZED_NAME_API_ID)
            private String apiId;

        public static final String SERIALIZED_NAME_API_INFO = "apiInfo";
        @SerializedName(SERIALIZED_NAME_API_INFO)
            private APIInfoDTO apiInfo;

        public static final String SERIALIZED_NAME_APPLICATION_INFO = "applicationInfo";
        @SerializedName(SERIALIZED_NAME_APPLICATION_INFO)
            private ApplicationInfoDTO applicationInfo;

        public static final String SERIALIZED_NAME_THROTTLING_POLICY = "throttlingPolicy";
        @SerializedName(SERIALIZED_NAME_THROTTLING_POLICY)
            private String throttlingPolicy;

        public static final String SERIALIZED_NAME_REQUESTED_THROTTLING_POLICY = "requestedThrottlingPolicy";
        @SerializedName(SERIALIZED_NAME_REQUESTED_THROTTLING_POLICY)
            private String requestedThrottlingPolicy;

            /**
* Gets or Sets status
*/
    @JsonAdapter(StatusEnum.Adapter.class)
public enum StatusEnum {
        BLOCKED("BLOCKED"),
        
        PROD_ONLY_BLOCKED("PROD_ONLY_BLOCKED"),
        
        UNBLOCKED("UNBLOCKED"),
        
        ON_HOLD("ON_HOLD"),
        
        REJECTED("REJECTED"),
        
        TIER_UPDATE_PENDING("TIER_UPDATE_PENDING");

private String value;

StatusEnum(String value) {
this.value = value;
}

public String getValue() {
return value;
}

@Override
public String toString() {
return String.valueOf(value);
}

public static StatusEnum fromValue(String value) {
    for (StatusEnum b : StatusEnum.values()) {
    if (b.name().equals(value)) {
        return b;
    }
}
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
}

    public static class Adapter extends TypeAdapter<StatusEnum> {
    @Override
    public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
    jsonWriter.value(enumeration.getValue());
    }

    @Override
    public StatusEnum read(final JsonReader jsonReader) throws IOException {
    String value =  jsonReader.nextString();
    return StatusEnum.fromValue(value);
    }
    }
}

        public static final String SERIALIZED_NAME_STATUS = "status";
        @SerializedName(SERIALIZED_NAME_STATUS)
            private StatusEnum status;

        public static final String SERIALIZED_NAME_REDIRECTION_PARAMS = "redirectionParams";
        @SerializedName(SERIALIZED_NAME_REDIRECTION_PARAMS)
            private String redirectionParams;


        public SubscriptionDTO subscriptionId(String subscriptionId) {
        
        this.subscriptionId = subscriptionId;
        return this;
        }

    /**
        * The UUID of the subscription
    * @return subscriptionId
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "faae5fcc-cbae-40c4-bf43-89931630d313", value = "The UUID of the subscription")
    
    public String getSubscriptionId() {
        return subscriptionId;
    }


    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }


        public SubscriptionDTO applicationId(String applicationId) {
        
        this.applicationId = applicationId;
        return this;
        }

    /**
        * The UUID of the application
    * @return applicationId
    **/
      @ApiModelProperty(example = "b3ade481-30b0-4b38-9a67-498a40873a6d", required = true, value = "The UUID of the application")
    
    public String getApplicationId() {
        return applicationId;
    }


    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }


        public SubscriptionDTO apiId(String apiId) {
        
        this.apiId = apiId;
        return this;
        }

    /**
        * The unique identifier of the API.
    * @return apiId
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "2962f3bb-8330-438e-baee-0ee1d6434ba4", value = "The unique identifier of the API.")
    
    public String getApiId() {
        return apiId;
    }


    public void setApiId(String apiId) {
        this.apiId = apiId;
    }


        public SubscriptionDTO apiInfo(APIInfoDTO apiInfo) {
        
        this.apiInfo = apiInfo;
        return this;
        }

    /**
        * Get apiInfo
    * @return apiInfo
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "")
    
    public APIInfoDTO getApiInfo() {
        return apiInfo;
    }


    public void setApiInfo(APIInfoDTO apiInfo) {
        this.apiInfo = apiInfo;
    }


        public SubscriptionDTO applicationInfo(ApplicationInfoDTO applicationInfo) {
        
        this.applicationInfo = applicationInfo;
        return this;
        }

    /**
        * Get applicationInfo
    * @return applicationInfo
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "")
    
    public ApplicationInfoDTO getApplicationInfo() {
        return applicationInfo;
    }


    public void setApplicationInfo(ApplicationInfoDTO applicationInfo) {
        this.applicationInfo = applicationInfo;
    }


        public SubscriptionDTO throttlingPolicy(String throttlingPolicy) {
        
        this.throttlingPolicy = throttlingPolicy;
        return this;
        }

    /**
        * Get throttlingPolicy
    * @return throttlingPolicy
    **/
      @ApiModelProperty(example = "Unlimited", required = true, value = "")
    
    public String getThrottlingPolicy() {
        return throttlingPolicy;
    }


    public void setThrottlingPolicy(String throttlingPolicy) {
        this.throttlingPolicy = throttlingPolicy;
    }


        public SubscriptionDTO requestedThrottlingPolicy(String requestedThrottlingPolicy) {
        
        this.requestedThrottlingPolicy = requestedThrottlingPolicy;
        return this;
        }

    /**
        * Get requestedThrottlingPolicy
    * @return requestedThrottlingPolicy
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "Unlimited", value = "")
    
    public String getRequestedThrottlingPolicy() {
        return requestedThrottlingPolicy;
    }


    public void setRequestedThrottlingPolicy(String requestedThrottlingPolicy) {
        this.requestedThrottlingPolicy = requestedThrottlingPolicy;
    }


        public SubscriptionDTO status(StatusEnum status) {
        
        this.status = status;
        return this;
        }

    /**
        * Get status
    * @return status
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "UNBLOCKED", value = "")
    
    public StatusEnum getStatus() {
        return status;
    }


    public void setStatus(StatusEnum status) {
        this.status = status;
    }


        public SubscriptionDTO redirectionParams(String redirectionParams) {
        
        this.redirectionParams = redirectionParams;
        return this;
        }

    /**
        * A url and other parameters the subscriber can be redirected.
    * @return redirectionParams
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "A url and other parameters the subscriber can be redirected.")
    
    public String getRedirectionParams() {
        return redirectionParams;
    }


    public void setRedirectionParams(String redirectionParams) {
        this.redirectionParams = redirectionParams;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
        return true;
        }
        if (o == null || getClass() != o.getClass()) {
        return false;
        }
            SubscriptionDTO subscription = (SubscriptionDTO) o;
            return Objects.equals(this.subscriptionId, subscription.subscriptionId) &&
            Objects.equals(this.applicationId, subscription.applicationId) &&
            Objects.equals(this.apiId, subscription.apiId) &&
            Objects.equals(this.apiInfo, subscription.apiInfo) &&
            Objects.equals(this.applicationInfo, subscription.applicationInfo) &&
            Objects.equals(this.throttlingPolicy, subscription.throttlingPolicy) &&
            Objects.equals(this.requestedThrottlingPolicy, subscription.requestedThrottlingPolicy) &&
            Objects.equals(this.status, subscription.status) &&
            Objects.equals(this.redirectionParams, subscription.redirectionParams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriptionId, applicationId, apiId, apiInfo, applicationInfo, throttlingPolicy, requestedThrottlingPolicy, status, redirectionParams);
    }


@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append("class SubscriptionDTO {\n");
    sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
    sb.append("    applicationId: ").append(toIndentedString(applicationId)).append("\n");
    sb.append("    apiId: ").append(toIndentedString(apiId)).append("\n");
    sb.append("    apiInfo: ").append(toIndentedString(apiInfo)).append("\n");
    sb.append("    applicationInfo: ").append(toIndentedString(applicationInfo)).append("\n");
    sb.append("    throttlingPolicy: ").append(toIndentedString(throttlingPolicy)).append("\n");
    sb.append("    requestedThrottlingPolicy: ").append(toIndentedString(requestedThrottlingPolicy)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    redirectionParams: ").append(toIndentedString(redirectionParams)).append("\n");
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

