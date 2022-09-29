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



import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import lombok.Data;


@Data
@Entity
@Table(name = "network")
@SuppressFBWarnings
public class NetworkEntity {
	@Id
	@SequenceGenerator(name = "network_instance_id_seq", sequenceName = "network_instance_id_seq", allocationSize = 50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "network_instance_id_seq")
	private long id;
	
	@NotNull
	private String name;
	@NotNull
	private String type;
	
	@ManyToOne
	ProjectEntity project;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy="network")
	private List<NodeEntity> Node;
}
