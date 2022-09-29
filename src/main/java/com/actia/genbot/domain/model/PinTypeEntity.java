package com.actia.genbot.domain.model;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import lombok.Data;


@Data
@Entity
@Table(name = "pin_type")
@SuppressFBWarnings
public class PinTypeEntity {
	
	@Id
	@SequenceGenerator(name = "pin_type_instance_id_seq", sequenceName = "pin_type_instance_id_seq", allocationSize = 50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pin_type_instance_id_seq")
	private long id;
	
	private long inMax;
	
	private long inMin;
	
	private long outMax;
	
	private long outMin;
	
	@ManyToOne
	IoMappingEntity ioMapping;
}
