package com.actia.genbot.domain.model;



import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.actia.genbot.domain.model.enumeration.InputServices;
import com.actia.genbot.domain.model.enumeration.OutputServices;


import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import lombok.Data;


@Data
@Entity
@Table(name = "io_mapping")
@SuppressFBWarnings
public class IoMappingEntity {
	@Id
	@SequenceGenerator(name = "io_mapping_instance_id_seq", sequenceName = "io_mapping_instance_id_seq", allocationSize = 50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "io_mapping_instance_id_seq")
	private long id;
	
	@NotNull
	@Pattern(regexp="^[^0-9][a-zA-Z0-9]{1,50}$",message="name must be of 1 to 50 length with no special characters") 
	private String name;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private InputServices inputService;
	
	@Enumerated(EnumType.STRING)
	private OutputServices OutputService;
	
	@ManyToOne
	ProjectEntity project;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy="ioMapping")
	private List<PinTypeEntity> PinType;
	
}
