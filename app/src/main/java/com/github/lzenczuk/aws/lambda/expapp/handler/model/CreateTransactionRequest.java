package com.github.lzenczuk.aws.lambda.expapp.handler.model;

/**
 * Created by lzenczuk on 28/03/17.
 */
public class CreateTransactionRequest {
    private Long sourceAccountId;
    private Long targetAccountId;
    private String amount;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Long getSourceAccountId() {
        return sourceAccountId;
    }

    public void setSourceAccountId(Long sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public Long getTargetAccountId() {
        return targetAccountId;
    }

    public void setTargetAccountId(Long targetAccountId) {
        this.targetAccountId = targetAccountId;
    }

    @Override
    public String toString() {
        return "CreateTransactionRequest{" +
                "amount='" + amount + '\'' +
                ", sourceAccountId=" + sourceAccountId +
                ", targetAccountId=" + targetAccountId +
                '}';
    }
}
