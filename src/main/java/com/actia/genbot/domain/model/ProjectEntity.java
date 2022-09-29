package com.actia.genbot.domain.model;

import java.time.LocalDateTime;

import java.util.List;

import javax.persistence.*;
import javax.print.DocFlavor.BYTE_ARRAY;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.actia.genbot.domain.model.enumeration.Status;

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
@Table(name = "project")
@SuppressFBWarnings
public class ProjectEntity {
	@Id
	@SequenceGenerator(name = "project_instance_id_seq", sequenceName = "project_instance_id_seq", allocationSize = 50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_instance_id_seq")
	private long id;
	@NotNull
	@Size(min =2 , max = 50)
	private String projectName;
	@NotNull
	@Size(min =2 , max = 50)
	@Column(unique=true)
	private String projectIdentifier;
	@NotNull
	private String cutomerName;
	@NotNull
	@Pattern(regexp="^[a-zA-Z0-9]+$",message="name must be  with no special characters") 
	private String testPlanReference;

	@NotNull
	@Min(value = 0 , message = "Value should be greater then then equal to 0")
    @Max(value = 380 , message = "Value should be less then then equal to 380")
	private Float tension;

	
	@NotNull
	private String testPlanFile;
	@NotNull
	private Boolean isLocked;
	@NotNull
	private Boolean deleted;
	
	@NotNull
	private LocalDateTime createdAt;
	@NotNull
	private long createdBy;
	@NotNull
	private LocalDateTime lastUpdatedAt;
	@NotNull
	private long lastUpdatedBy;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@OneToOne
	private TestPlanTypeEntity testPlanType;
	@OneToOne
	private TestToolNameEntity testToolName;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy="project")
	private List<VtsEntity> Vts;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy="project")
	private List<ServiceEntity> Service;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy="project")
	private List<IoMappingEntity> IoMapping;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy="project")
	private List<NetworkEntity> Network;
	
	
	
}
