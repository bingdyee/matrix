/*
 * This file is generated by jOOQ.
 */
package io.hikari.jooq.generated.tables.records;


import io.hikari.jooq.generated.tables.OauthClientDetails;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OauthClientDetailsRecord extends UpdatableRecordImpl<OauthClientDetailsRecord> implements Record11<String, String, String, String, String, String, String, Integer, Integer, String, String> {

    private static final long serialVersionUID = -1520222494;

    /**
     * Setter for <code>hikari.oauth_client_details.client_id</code>. 用于唯一标识每一个客户端
     */
    public void setClientId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>hikari.oauth_client_details.client_id</code>. 用于唯一标识每一个客户端
     */
    public String getClientId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>hikari.oauth_client_details.resource_ids</code>. 客户端所能访问的资源id集合，多个资源时用逗号(,)分隔
     */
    public void setResourceIds(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>hikari.oauth_client_details.resource_ids</code>. 客户端所能访问的资源id集合，多个资源时用逗号(,)分隔
     */
    public String getResourceIds() {
        return (String) get(1);
    }

    /**
     * Setter for <code>hikari.oauth_client_details.client_secret</code>. 客户端(client)的访问密匙
     */
    public void setClientSecret(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>hikari.oauth_client_details.client_secret</code>. 客户端(client)的访问密匙
     */
    public String getClientSecret() {
        return (String) get(2);
    }

    /**
     * Setter for <code>hikari.oauth_client_details.scope</code>. 客户端申请的权限范围,可选值包括read,write,trust
     */
    public void setScope(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>hikari.oauth_client_details.scope</code>. 客户端申请的权限范围,可选值包括read,write,trust
     */
    public String getScope() {
        return (String) get(3);
    }

    /**
     * Setter for <code>hikari.oauth_client_details.authorized_grant_types</code>. 指定客户端支持的grant_type,可选值包括authorization_code,password,refresh_token,implicit,client_credentials, 若支持多个grant_type用逗号(,)分隔,如: "authorization_code,password".
     */
    public void setAuthorizedGrantTypes(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>hikari.oauth_client_details.authorized_grant_types</code>. 指定客户端支持的grant_type,可选值包括authorization_code,password,refresh_token,implicit,client_credentials, 若支持多个grant_type用逗号(,)分隔,如: "authorization_code,password".
     */
    public String getAuthorizedGrantTypes() {
        return (String) get(4);
    }

    /**
     * Setter for <code>hikari.oauth_client_details.web_server_redirect_uri</code>. 客户端的重定向URI,可为空, 当grant_type为authorization_code或implicit时, 在Oauth的流程中会使用并检查与注册时填写的redirect_uri是否一致. 下面分别说明:
当grant_type=authorization_code时, 第一步 从 spring-oauth-server获取 'code'时客户端发起请求时必须有redirect_uri参数, 该参数的值必须与 web_server_redirect_uri的值一致. 第二步 用 'code' 换取 'access_token' 时客户也必须传递相同的redirect_uri. 
在实际应用中, web_server_redirect_uri在注册时是必须填写的, 一般用来处理服务器返回的code, 验证state是否合法与通过code去换取access_token值. 
在spring-oauth-client项目中, 可具体参考AuthorizationCodeController.java中的authorizationCodeCallback方法.
当grant_type=implicit时通过redirect_uri的hash值来传递access_token值.如:
     */
    public void setWebServerRedirectUri(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>hikari.oauth_client_details.web_server_redirect_uri</code>. 客户端的重定向URI,可为空, 当grant_type为authorization_code或implicit时, 在Oauth的流程中会使用并检查与注册时填写的redirect_uri是否一致. 下面分别说明:
当grant_type=authorization_code时, 第一步 从 spring-oauth-server获取 'code'时客户端发起请求时必须有redirect_uri参数, 该参数的值必须与 web_server_redirect_uri的值一致. 第二步 用 'code' 换取 'access_token' 时客户也必须传递相同的redirect_uri. 
在实际应用中, web_server_redirect_uri在注册时是必须填写的, 一般用来处理服务器返回的code, 验证state是否合法与通过code去换取access_token值. 
在spring-oauth-client项目中, 可具体参考AuthorizationCodeController.java中的authorizationCodeCallback方法.
当grant_type=implicit时通过redirect_uri的hash值来传递access_token值.如:
     */
    public String getWebServerRedirectUri() {
        return (String) get(5);
    }

    /**
     * Setter for <code>hikari.oauth_client_details.authorities</code>. 客户端所拥有的Spring Security的权限值,可选, 若有多个权限值,用逗号(,)分隔
     */
    public void setAuthorities(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>hikari.oauth_client_details.authorities</code>. 客户端所拥有的Spring Security的权限值,可选, 若有多个权限值,用逗号(,)分隔
     */
    public String getAuthorities() {
        return (String) get(6);
    }

    /**
     * Setter for <code>hikari.oauth_client_details.access_token_validity</code>. 客户端的access_token的有效时间值(单位:秒)
     */
    public void setAccessTokenValidity(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>hikari.oauth_client_details.access_token_validity</code>. 客户端的access_token的有效时间值(单位:秒)
     */
    public Integer getAccessTokenValidity() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>hikari.oauth_client_details.refresh_token_validity</code>. 客户端的refresh_token的有效时间值(单位:秒)
     */
    public void setRefreshTokenValidity(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>hikari.oauth_client_details.refresh_token_validity</code>. 客户端的refresh_token的有效时间值(单位:秒)
     */
    public Integer getRefreshTokenValidity() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>hikari.oauth_client_details.additional_information</code>. 预留的字段，必须是JSON格式
     */
    public void setAdditionalInformation(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>hikari.oauth_client_details.additional_information</code>. 预留的字段，必须是JSON格式
     */
    public String getAdditionalInformation() {
        return (String) get(9);
    }

    /**
     * Setter for <code>hikari.oauth_client_details.autoapprove</code>. 设置用户是否自动Approval操作, 默认值为 'false', 可选值包括 'true','false', 'read','write'. 
该字段只适用于grant_type="authorization_code"的情况,当用户登录成功后,若该值为'true'或支持的scope值,则会跳过用户Approve的页面, 直接授权. 
该字段与 trusted 有类似的功能, 是 spring-security-oauth2 的 2.0 版本后添加的新属性
     */
    public void setAutoapprove(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>hikari.oauth_client_details.autoapprove</code>. 设置用户是否自动Approval操作, 默认值为 'false', 可选值包括 'true','false', 'read','write'. 
该字段只适用于grant_type="authorization_code"的情况,当用户登录成功后,若该值为'true'或支持的scope值,则会跳过用户Approve的页面, 直接授权. 
该字段与 trusted 有类似的功能, 是 spring-security-oauth2 的 2.0 版本后添加的新属性
     */
    public String getAutoapprove() {
        return (String) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<String, String, String, String, String, String, String, Integer, Integer, String, String> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<String, String, String, String, String, String, String, Integer, Integer, String, String> valuesRow() {
        return (Row11) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return OauthClientDetails.OAUTH_CLIENT_DETAILS.CLIENT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return OauthClientDetails.OAUTH_CLIENT_DETAILS.RESOURCE_IDS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return OauthClientDetails.OAUTH_CLIENT_DETAILS.CLIENT_SECRET;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return OauthClientDetails.OAUTH_CLIENT_DETAILS.SCOPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return OauthClientDetails.OAUTH_CLIENT_DETAILS.AUTHORIZED_GRANT_TYPES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return OauthClientDetails.OAUTH_CLIENT_DETAILS.WEB_SERVER_REDIRECT_URI;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return OauthClientDetails.OAUTH_CLIENT_DETAILS.AUTHORITIES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return OauthClientDetails.OAUTH_CLIENT_DETAILS.ACCESS_TOKEN_VALIDITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field9() {
        return OauthClientDetails.OAUTH_CLIENT_DETAILS.REFRESH_TOKEN_VALIDITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return OauthClientDetails.OAUTH_CLIENT_DETAILS.ADDITIONAL_INFORMATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return OauthClientDetails.OAUTH_CLIENT_DETAILS.AUTOAPPROVE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getClientId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getResourceIds();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getClientSecret();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getScope();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getAuthorizedGrantTypes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getWebServerRedirectUri();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getAuthorities();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component8() {
        return getAccessTokenValidity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component9() {
        return getRefreshTokenValidity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component10() {
        return getAdditionalInformation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component11() {
        return getAutoapprove();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getClientId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getResourceIds();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getClientSecret();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getScope();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getAuthorizedGrantTypes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getWebServerRedirectUri();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getAuthorities();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getAccessTokenValidity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value9() {
        return getRefreshTokenValidity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getAdditionalInformation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getAutoapprove();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OauthClientDetailsRecord value1(String value) {
        setClientId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OauthClientDetailsRecord value2(String value) {
        setResourceIds(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OauthClientDetailsRecord value3(String value) {
        setClientSecret(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OauthClientDetailsRecord value4(String value) {
        setScope(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OauthClientDetailsRecord value5(String value) {
        setAuthorizedGrantTypes(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OauthClientDetailsRecord value6(String value) {
        setWebServerRedirectUri(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OauthClientDetailsRecord value7(String value) {
        setAuthorities(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OauthClientDetailsRecord value8(Integer value) {
        setAccessTokenValidity(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OauthClientDetailsRecord value9(Integer value) {
        setRefreshTokenValidity(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OauthClientDetailsRecord value10(String value) {
        setAdditionalInformation(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OauthClientDetailsRecord value11(String value) {
        setAutoapprove(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OauthClientDetailsRecord values(String value1, String value2, String value3, String value4, String value5, String value6, String value7, Integer value8, Integer value9, String value10, String value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OauthClientDetailsRecord
     */
    public OauthClientDetailsRecord() {
        super(OauthClientDetails.OAUTH_CLIENT_DETAILS);
    }

    /**
     * Create a detached, initialised OauthClientDetailsRecord
     */
    public OauthClientDetailsRecord(String clientId, String resourceIds, String clientSecret, String scope, String authorizedGrantTypes, String webServerRedirectUri, String authorities, Integer accessTokenValidity, Integer refreshTokenValidity, String additionalInformation, String autoapprove) {
        super(OauthClientDetails.OAUTH_CLIENT_DETAILS);

        set(0, clientId);
        set(1, resourceIds);
        set(2, clientSecret);
        set(3, scope);
        set(4, authorizedGrantTypes);
        set(5, webServerRedirectUri);
        set(6, authorities);
        set(7, accessTokenValidity);
        set(8, refreshTokenValidity);
        set(9, additionalInformation);
        set(10, autoapprove);
    }
}
