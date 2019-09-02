package com.myapp.myapp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class BranchHead extends User {

	@ManyToMany(fetch = FetchType.EAGER)
	List<Branch> ownedBraches;
	@OneToOne
	BranchHeadPolicy policy;
}
