package com.actia.genbot.domain.model;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import lombok.Data;


@Data
@Entity
@Table(name = "service")
@SuppressFBWarnings
public class ServiceEntity {
	
	@Id
	@SequenceGenerator(name = "service_instance_id_seq", sequenceName = "service_instance_id_seq", allocationSize = 50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_instance_id_seq")
	private long id;
	
	@NotNull
	private String serviceId;
	
	@NotNull
	@Size(max = 100)
	private String name;
	
	@NotNull
	private String type;
	
	@NotNull
	private String serviceRetId;
	
	@NotNull
	@Size(max = 100)
	private String serviceRetName;
	
	@NotNull
	private String serviceRetType;
	
	@NotNull
	private String argValueId;
	
	@NotNull
	private String argValue;
	
	@NotNull
	private String argValueIdType;
	
	@ManyToOne
	ProjectEntity project;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy="service")
	private List<ServiceArgumentEntity> ServiceArgument;
}
