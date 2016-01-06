package cn.zj.sunda.water.bo;

// default package

import java.sql.Timestamp;

/**
 * ControlLogId entity. @author MyEclipse Persistence Tools
 */

public class ControlLogId implements java.io.Serializable {

	// Fields

	private Long userId;
	private Long SId;
	private Timestamp createdAt;

	// Constructors

	/** default constructor */
	public ControlLogId() {
	}

	/** full constructor */
	public ControlLogId(Long userId, Long SId, Timestamp createdAt) {
		this.userId = userId;
		this.SId = SId;
		this.createdAt = createdAt;
	}

	// Property accessors

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getSId() {
		return this.SId;
	}

	public void setSId(Long SId) {
		this.SId = SId;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ControlLogId))
			return false;
		ControlLogId castOther = (ControlLogId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null
				&& castOther.getUserId() != null && this.getUserId().equals(
				castOther.getUserId())))
				&& ((this.getSId() == castOther.getSId()) || (this.getSId() != null
						&& castOther.getSId() != null && this.getSId().equals(
						castOther.getSId())))
				&& ((this.getCreatedAt() == castOther.getCreatedAt()) || (this
						.getCreatedAt() != null
						&& castOther.getCreatedAt() != null && this
						.getCreatedAt().equals(castOther.getCreatedAt())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getSId() == null ? 0 : this.getSId().hashCode());
		result = 37 * result
				+ (getCreatedAt() == null ? 0 : this.getCreatedAt().hashCode());
		return result;
	}

}