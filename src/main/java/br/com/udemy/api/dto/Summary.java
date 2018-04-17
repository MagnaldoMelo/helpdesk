package br.com.udemy.api.dto;

import java.io.Serializable;

public class Summary implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Integer amountNew;
    private Integer amountResolved;
    private Integer amountApproved;
    private Integer amountDisapproved;
    private Integer amountAssigned;
    private Integer amountClosed;
	/**
	 * @return the amountNew
	 */
	public Integer getAmountNew() {
		return amountNew;
	}
	/**
	 * @param amountNew the amountNew to set
	 */
	public void setAmountNew(Integer amountNew) {
		this.amountNew = amountNew;
	}
	/**
	 * @return the amountResolved
	 */
	public Integer getAmountResolved() {
		return amountResolved;
	}
	/**
	 * @param amountResolved the amountResolved to set
	 */
	public void setAmountResolved(Integer amountResolved) {
		this.amountResolved = amountResolved;
	}
	/**
	 * @return the amountApproved
	 */
	public Integer getAmountApproved() {
		return amountApproved;
	}
	/**
	 * @param amountApproved the amountApproved to set
	 */
	public void setAmountApproved(Integer amountApproved) {
		this.amountApproved = amountApproved;
	}
	/**
	 * @return the amountDisapproved
	 */
	public Integer getAmountDisapproved() {
		return amountDisapproved;
	}
	/**
	 * @param amountDisapproved the amountDisapproved to set
	 */
	public void setAmountDisapproved(Integer amountDisapproved) {
		this.amountDisapproved = amountDisapproved;
	}
	/**
	 * @return the amountAssigned
	 */
	public Integer getAmountAssigned() {
		return amountAssigned;
	}
	/**
	 * @param amountAssigned the amountAssigned to set
	 */
	public void setAmountAssigned(Integer amountAssigned) {
		this.amountAssigned = amountAssigned;
	}
	/**
	 * @return the amountClosed
	 */
	public Integer getAmountClosed() {
		return amountClosed;
	}
	/**
	 * @param amountClosed the amountClosed to set
	 */
	public void setAmountClosed(Integer amountClosed) {
		this.amountClosed = amountClosed;
	}

}