package io.hikari.transaction.account.pojo.domain;

import java.math.BigDecimal;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
public class AccountDO {

    private Long id;
    private String username;
    private BigDecimal amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "AccountDO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", amount=" + amount +
                '}';
    }

}
