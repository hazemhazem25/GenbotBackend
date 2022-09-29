package com.actia.genbot.domain.model;



import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import com.actia.genbot.domain.model.enumeration.TypeArgument;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import lombok.Data;


@Data
@Entity
@Table(name = "service_argument")
@SuppressFBWarnings
public class ServiceArgumentEntity {
	
	@Id
	@SequenceGenerator(name = "service_argument_instance_id_seq", sequenceName = "service_argument_instance_id_seq", allocationSize = 50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_argument_instance_id_seq")
	private long id;

	@NotNull
	private String name;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private TypeArgument type;
	
	@ManyToOne
	ServiceEntity service;
}
