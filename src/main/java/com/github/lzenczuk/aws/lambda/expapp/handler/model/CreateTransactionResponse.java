package com.github.lzenczuk.aws.lambda.expapp.handler.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lzenczuk on 28/03/17.
 */
public class CreateTransactionResponse {
    private Long transactionId;
    private TransactionStatus status;
    private List<String> errors;

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public void addError(String error){
        if(errors==null){
            errors = new LinkedList<String>();
        }

        errors.add(error);
    }

    public boolean hasErrors(){
        return !(errors == null || errors.isEmpty());
    }

    @Override
    public String toString() {
        return "CreateTransactionResponse{" +
                "errors=" + errors +
                ", transactionId=" + transactionId +
                ", status=" + status +
                '}';
    }
}
