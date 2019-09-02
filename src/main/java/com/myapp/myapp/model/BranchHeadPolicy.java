package com.myapp.myapp.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class BranchHeadPolicy {
	@Id
	@GeneratedValue
	Long id;
	boolean isEnableMailNotification;
	boolean isEnableSMSNotification;
}
