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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "fluid_sample")
public class FluidSample
{
	@Id
	private SampleGroup sampleGroup;

	@Id
	@Column(name = "pre_post")
	@Enumerated(EnumType.STRING)
	private PrePost prePost;

	@OneToMany(mappedBy = "sample")
	private List<FluidSampleLabel> labels = new ArrayList<>();

	@Column(name = "amount")
	private BigDecimal amount;

	@SuppressWarnings("unused")
	private FluidSample()
	{
	}

	public FluidSample(SampleGroup sampleGroup, PrePost prePost)
	{
		this.sampleGroup = sampleGroup;
		this.prePost = prePost;
	}

	public FluidSampleLabel addNewLabel(String value)
	{
		FluidSampleLabel label = new FluidSampleLabel(this, value);
		this.labels.add(label);
		return label;
	}

}
