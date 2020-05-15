/*
 * This file is generated by jOOQ.
 */
package io.hikari.jooq.generated.tables.records;


import io.hikari.jooq.generated.tables.OauthAccessToken;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OauthAccessTokenRecord extends UpdatableRecordImpl<OauthAccessTokenRecord> implements Record7<String, byte[], String, String, String, byte[], String> {

    private static final long serialVersionUID = 1666608933;

    /**
     * Setter for <code>hikari.oauth_access_token.token_id</code>. 将access_token的值通过MD5加密后存储的
     */
    public void setTokenId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>hikari.oauth_access_token.token_id</code>. 将access_token的值通过MD5加密后存储的
     */
    public String getTokenId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>hikari.oauth_access_token.token</code>. 将OAuth2AccessToken.java对象序列化后的二进制数据, 是真实的AccessToken的数据值
     */
    public void setToken(byte[] value) {
        set(1, value);
    }

    /**
     * Getter for <code>hikari.oauth_access_token.token</code>. 将OAuth2AccessToken.java对象序列化后的二进制数据, 是真实的AccessToken的数据值
     */
    public byte[] getToken() {
        return (byte[]) get(1);
    }

    /**
     * Setter for <code>hikari.oauth_access_token.authentication_id</code>. 根据当前的username(如果有),client_id与scope通过MD5加密生成
     */
    public void setAuthenticationId(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>hikari.oauth_access_token.authentication_id</code>. 根据当前的username(如果有),client_id与scope通过MD5加密生成
     */
    public String getAuthenticationId() {
        return (String) get(2);
    }

    /**
     * Setter for <code>hikari.oauth_access_token.user_name</code>. 登录时的用户名, 若客户端没有用户名(如grant_type="client_credentials"),则该值等于client_id
     */
    public void setUserName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>hikari.oauth_access_token.user_name</code>. 登录时的用户名, 若客户端没有用户名(如grant_type="client_credentials"),则该值等于client_id
     */
    public String getUserName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>hikari.oauth_access_token.client_id</code>.
     */
    public void setClientId(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>hikari.oauth_access_token.client_id</code>.
     */
    public String getClientId() {
        return (String) get(4);
    }

    /**
     * Setter for <code>hikari.oauth_access_token.authentication</code>. 将OAuth2Authentication.java对象序列化后的二进制数据.
     */
    public void setAuthentication(byte[] value) {
        set(5, value);
    }

    /**
     * Getter for <code>hikari.oauth_access_token.authentication</code>. 将OAuth2Authentication.java对象序列化后的二进制数据.
     */
    public byte[] getAuthentication() {
        return (byte[]) get(5);
    }

    /**
     * Setter for <code>hikari.oauth_access_token.refresh_token</code>. 将refresh_token的值通过MD5加密后存储的.
     */
    public void setRefreshToken(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>hikari.oauth_access_token.refresh_token</code>. 将refresh_token的值通过MD5加密后存储的.
     */
    public String getRefreshToken() {
        return (String) get(6);
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
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<String, byte[], String, String, String, byte[], String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<String, byte[], String, String, String, byte[], String> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return OauthAccessToken.OAUTH_ACCESS_TOKEN.TOKEN_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<byte[]> field2() {
        return OauthAccessToken.OAUTH_ACCESS_TOKEN.TOKEN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return OauthAccessToken.OAUTH_ACCESS_TOKEN.AUTHENTICATION_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return OauthAccessToken.OAUTH_ACCESS_TOKEN.USER_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return OauthAccessToken.OAUTH_ACCESS_TOKEN.CLIENT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<byte[]> field6() {
        return OauthAccessToken.OAUTH_ACCESS_TOKEN.AUTHENTICATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return OauthAccessToken.OAUTH_ACCESS_TOKEN.REFRESH_TOKEN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getTokenId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] component2() {
        return getToken();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getAuthenticationId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getUserName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getClientId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] component6() {
        return getAuthentication();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getRefreshToken();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getTokenId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] value2() {
        return getToken();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getAuthenticationId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getUserName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getClientId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] value6() {
        return getAuthentication();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getRefreshToken();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OauthAccessTokenRecord value1(String value) {
        setTokenId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OauthAccessTokenRecord value2(byte[] value) {
        setToken(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OauthAccessTokenRecord value3(String value) {
        setAuthenticationId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OauthAccessTokenRecord value4(String value) {
        setUserName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OauthAccessTokenRecord value5(String value) {
        setClientId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OauthAccessTokenRecord value6(byte[] value) {
        setAuthentication(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OauthAccessTokenRecord value7(String value) {
        setRefreshToken(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OauthAccessTokenRecord values(String value1, byte[] value2, String value3, String value4, String value5, byte[] value6, String value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OauthAccessTokenRecord
     */
    public OauthAccessTokenRecord() {
        super(OauthAccessToken.OAUTH_ACCESS_TOKEN);
    }

    /**
     * Create a detached, initialised OauthAccessTokenRecord
     */
    public OauthAccessTokenRecord(String tokenId, byte[] token, String authenticationId, String userName, String clientId, byte[] authentication, String refreshToken) {
        super(OauthAccessToken.OAUTH_ACCESS_TOKEN);

        set(0, tokenId);
        set(1, token);
        set(2, authenticationId);
        set(3, userName);
        set(4, clientId);
        set(5, authentication);
        set(6, refreshToken);
    }
}
