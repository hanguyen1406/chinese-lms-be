package lms.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "otp_verify")
public class OtpVerify {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String otpCode;

	@Column(nullable = false)
	private Date createdAt;

	@Column(nullable = false)
	private Date expiresAt;

	private Boolean isVerified = false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOtpCode() {
		return otpCode;
	}

	public void setOtpCode(String otpCode) {
		this.otpCode = otpCode;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}

	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	public OtpVerify() {
		super();
	}

	public OtpVerify(Long id, String email, String otpCode, Date createdAt, Date expiresAt, Boolean isVerified) {
		super();
		this.id = id;
		this.email = email;
		this.otpCode = otpCode;
		this.createdAt = createdAt;
		this.expiresAt = expiresAt;
		this.isVerified = isVerified;
	}

}