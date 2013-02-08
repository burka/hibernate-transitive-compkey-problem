/**
 *
 * This software is written by arcus(x) GmbH and subject 
 * to a contract between arcus(x) and its customer.
 *
 * This software stays property of arcus(x) unless differing
 * arrangements between arcus(x) and its customer apply.
 *
 * arcus(x) GmbH
 * Hamburg, Germany
 *
 * Tel.: +49 (0)40.333 102 92 
 * Fax.: +49 (0)40.333 102 93 
 * http://www.arcusx.com
 * mailto:info@arcusx.com
 *
 */

package compkey_problem.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "sampleGroupSequence", sequenceName = "sample_group_seq", allocationSize = 1)
@Table(name = "sample_group")
public class SampleGroup
{
	@Id
	@GeneratedValue(generator = "sampleGroupSequence", strategy = GenerationType.SEQUENCE)
	@Column(name = "sample_group_id")
	private Integer sampleGroupId;

	@OneToMany(mappedBy = "sampleGroup", cascade = { CascadeType.ALL})
	private List<FluidSample> fluidSamples = new ArrayList<>();

	@Column(name = "payload")
	private String payload;

	public SampleGroup()
	{
	}

	public FluidSample addNewPreFluidSample()
	{
		FluidSample sample = new FluidSample(this, PrePost.PRE);
		this.fluidSamples.add(sample);
		return sample;
	}
}
