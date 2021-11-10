package com.bookstore.bookstore.resources.exceptions;

public class StandardError {
	private Long timestamp;
	private Integer status;
	private String error;
	
	public StandardError(Long timestamp, Integer status, String error) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
	}

	public StandardError() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the timestamp
	 */
	public Long getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	
	
	
}
