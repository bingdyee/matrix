package io.hikari.transaction.server.coordinator;

import io.hikari.transaction.common.TransactionStatus;
import io.netty.channel.Channel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Noa Swartz
 * @date 2020-04-05
 */
public class TransactionGroup {

    private String xid;
    private List<TransactionStatus> votes = new ArrayList<>();
    private Set<Channel> channels = new HashSet<>();

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public List<TransactionStatus> getVotes() {
        return votes;
    }

    public void setVotes(List<TransactionStatus> votes) {
        this.votes = votes;
    }

    public Set<Channel> getChannels() {
        return channels;
    }

    public void setChannels(Set<Channel> channels) {
        this.channels = channels;
    }

}
