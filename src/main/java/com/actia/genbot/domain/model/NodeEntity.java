package com.actia.genbot.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "node")
@SuppressFBWarnings
public class NodeEntity {
	@Id
	@SequenceGenerator(name = "node_instance_id_seq", sequenceName = "node_instance_id_seq", allocationSize = 50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "node_instance_id_seq")
	private long id;
	
	@NotNull
	private String name;
	private String nodeFile;
	private String databaseFile;
	
	@ManyToOne
	NetworkEntity network;

}
