/*
 * This file is generated by jOOQ.
 */
package io.hikari.jooq.generated.tables;


import io.hikari.jooq.generated.Hikari;
import io.hikari.jooq.generated.tables.records.OauthApprovalsRecord;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OauthApprovals extends TableImpl<OauthApprovalsRecord> {

    private static final long serialVersionUID = -1170320674;

    /**
     * The reference instance of <code>hikari.oauth_approvals</code>
     */
    public static final OauthApprovals OAUTH_APPROVALS = new OauthApprovals();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OauthApprovalsRecord> getRecordType() {
        return OauthApprovalsRecord.class;
    }

    /**
     * The column <code>hikari.oauth_approvals.userId</code>.
     */
    public final TableField<OauthApprovalsRecord, String> USERID = createField("userId", org.jooq.impl.SQLDataType.VARCHAR(256), this, "");

    /**
     * The column <code>hikari.oauth_approvals.clientId</code>.
     */
    public final TableField<OauthApprovalsRecord, String> CLIENTID = createField("clientId", org.jooq.impl.SQLDataType.VARCHAR(256), this, "");

    /**
     * The column <code>hikari.oauth_approvals.scope</code>.
     */
    public final TableField<OauthApprovalsRecord, String> SCOPE = createField("scope", org.jooq.impl.SQLDataType.VARCHAR(256), this, "");

    /**
     * The column <code>hikari.oauth_approvals.status</code>.
     */
    public final TableField<OauthApprovalsRecord, String> STATUS = createField("status", org.jooq.impl.SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>hikari.oauth_approvals.expiresAt</code>.
     */
    public final TableField<OauthApprovalsRecord, LocalDateTime> EXPIRESAT = createField("expiresAt", org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>hikari.oauth_approvals.lastModifiedAt</code>.
     */
    public final TableField<OauthApprovalsRecord, LocalDateTime> LASTMODIFIEDAT = createField("lastModifiedAt", org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * Create a <code>hikari.oauth_approvals</code> table reference
     */
    public OauthApprovals() {
        this(DSL.name("oauth_approvals"), null);
    }

    /**
     * Create an aliased <code>hikari.oauth_approvals</code> table reference
     */
    public OauthApprovals(String alias) {
        this(DSL.name(alias), OAUTH_APPROVALS);
    }

    /**
     * Create an aliased <code>hikari.oauth_approvals</code> table reference
     */
    public OauthApprovals(Name alias) {
        this(alias, OAUTH_APPROVALS);
    }

    private OauthApprovals(Name alias, Table<OauthApprovalsRecord> aliased) {
        this(alias, aliased, null);
    }

    private OauthApprovals(Name alias, Table<OauthApprovalsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> OauthApprovals(Table<O> child, ForeignKey<O, OauthApprovalsRecord> key) {
        super(child, key, OAUTH_APPROVALS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Hikari.HIKARI;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OauthApprovals as(String alias) {
        return new OauthApprovals(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OauthApprovals as(Name alias) {
        return new OauthApprovals(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public OauthApprovals rename(String name) {
        return new OauthApprovals(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public OauthApprovals rename(Name name) {
        return new OauthApprovals(name, null);
    }
}
